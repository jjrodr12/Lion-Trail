package edu.psu.liontrail.util;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.enumeration.Role;
import edu.psu.liontrail.model.AuthUser;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.Name;
import edu.psu.liontrail.service.BuildingService;
import edu.psu.liontrail.service.UserService;

@Singleton
@Startup
public class StartUpTester {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  @Inject
  UserService userService;
  
  @Inject
  BuildingService buildingService;

  @PostConstruct
  public void init() throws Exception {
    /*String userId = "admin";
    AuthUser user = em.find(AuthUser.class, userId);
    System.out.println("User username: "+user.getUserName()+" password: "+user.getPassword());
    
    System.out.println("Number of Roles: "+user.getRoles().size());
    user.getRoles().forEach(r -> System.out.println("Role: "+r.getValue()));
    
    Name name = new Name("Mike", "E", "Zalewski");
    AuthUser user2 = userService.registerUser(name, "P@ssword1");
    //user.setRoles(Stream.of(Role.DEAN, Role.ADMISSIONS).collect(Collectors.toList()));
    userService.addRoles(user2.getUserName(), Stream.of(Role.ADMISSIONS, Role.DEAN).collect(Collectors.toSet()));*/
    
    //Building b = buildingService.getBuildingByRoomId(2);
    //System.out.printf("\n\nBuilding: %d, Name: %s%n", b.getId(), b.getName());
  }
}
