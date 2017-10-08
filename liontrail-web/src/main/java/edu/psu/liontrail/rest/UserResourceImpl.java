package edu.psu.liontrail.rest;

import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.CreateUserDTO;
import edu.psu.liontrail.enumeration.Role;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.UserNotFoundException;
import edu.psu.liontrail.model.AuthUser;
import edu.psu.liontrail.model.User;
import edu.psu.liontrail.service.UserService;

public class UserResourceImpl implements UserResource {
  
  @Inject
  UserService userService;

  @Override
  public Response createUser(CreateUserDTO userDto) {
    try {
      Set<Role> roles = Stream.of(userDto.getRole()).collect(Collectors.toSet());
      AuthUser authUser = userService.registerUser(userDto.getName(), userDto.getPassword(), roles);
      return Response.ok().entity(authUser.getUserName()).build();
    } catch (NoSuchAlgorithmException e) {
      ErrorMessage em = new ErrorMessage();
      em.addErrorMessage("Error Creating User");
      return em.toResponse();
    }

  }

  @Override
  public Response changePassword(int id, String password) {
    try {
      User user = userService.getUser(id).orElseThrow(() -> new UserNotFoundException("Unable to find user with id: "+id));
      userService.updatePassword(user.getUsername(), password);
      return Response.accepted().build();
    } catch (UserNotFoundException e) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, e.getMessage());
      return em.toResponse();
    } catch (NoSuchAlgorithmException e) {
      ErrorMessage em = new ErrorMessage(Status.INTERNAL_SERVER_ERROR, "Unable to save password");
      return em.toResponse();
    }
  }

}
