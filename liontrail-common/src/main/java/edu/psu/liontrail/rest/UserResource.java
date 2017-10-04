package edu.psu.liontrail.rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.CreateUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(UserResource.PATH)
@Api(UserResource.PATH)
public interface UserResource {
  
  public static final String PATH = "users";
  
  @POST
  @Path("create")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Produces({ MediaType.TEXT_PLAIN })
  @ApiOperation(value = "Create User")
  Response createUser(CreateUserDTO userDto);
  
  @PUT
  @Path("id/{id}")
  @Consumes({ MediaType.TEXT_PLAIN })
  @ApiOperation(value = "Change User Password")
  Response changePassword(@PathParam("id") int id, String password);

}
