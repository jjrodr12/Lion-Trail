package edu.psu.liontrail.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Role;
import edu.psu.liontrail.exception.UserNotFoundException;
import edu.psu.liontrail.model.AuthUser;
import edu.psu.liontrail.model.Name;

@Stateless
public class UserService {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public AuthUser registerUser(Name name, String password) throws NoSuchAlgorithmException {
    String userBase = getUserNameBase(name);
    List<String> likeUsers = findUserNamesWithBase(userBase);
    int userNumber = likeUsers.stream()
                    .map(u -> u.replaceAll("\\D", ""))
                    .mapToInt(u -> Integer.parseInt(u))
                    .max().orElse(0) + 1;
    String userName = userBase + userNumber;
    AuthUser user = new AuthUser(userName, hash(password));
    persistUser(user);
    return user;
  }
  
  private void persistUser(AuthUser user) {
    em.persist(user);
  }
  
  public void addRoles(String username, Collection<Role> roles) throws UserNotFoundException {
    if (roles != null) {
      AuthUser user = em.find(AuthUser.class, username);
      if (user == null) {
        throw new UserNotFoundException("Unable to find user with usernmae: "+username);
      }
      if (user.getRoles() != null) {
        user.getRoles().addAll(roles);
      } else {
        user.setRoles(new HashSet<>(roles));
      }
      em.merge(user);
    }
  }
  
  public void removeRoles(String username, Collection<Role> roles) throws UserNotFoundException {
    if (roles != null) {
      AuthUser user = em.find(AuthUser.class, username);
      if (user == null) {
        throw new UserNotFoundException("Unable to find user with usernmae: "+username);
      }
      if (user.getRoles() != null) {
        user.getRoles().removeIf(r -> roles.contains(r));
        em.merge(user);
      }
    }
  }
  
  public void updatePassword(String username, String password) throws UserNotFoundException, NoSuchAlgorithmException {
    AuthUser user = em.find(AuthUser.class, username);
    if (user == null) {
      throw new UserNotFoundException("Unable to find user with usernmae: "+username);
    }
    user.setPassword(hash(password));
    em.merge(user);
  }
  
  private String getUserNameBase(Name name) {
    String base = name.getFirstName().substring(0,1) + name.getMiddleName().substring(0,1) +
        name.getLastName().substring(0,1);
    
    Pattern p = Pattern.compile("[a-zA-Z]{3}");
    Matcher m = p.matcher(base);
    if (!m.find()) {
      throw new IllegalArgumentException("Names must begin with character symbols");
    }
    
    return base.toLowerCase();
  }
  
  private List<String> findUserNamesWithBase(String username) {
    String parameter = stripNonCharacter(username);
    TypedQuery<AuthUser> query = em.createNamedQuery(AuthUser.NAME_LIKE, AuthUser.class);
    query.setParameter("username", parameter + "%");
    
    List<AuthUser> users = query.getResultList();
    if (users == null) {
      users = new ArrayList<>();
    }
    
    return users.stream().map(u -> u.getUserName()).collect(Collectors.toList());
    
  }
  
 public static String stripNonCharacter(String input) {
    return input.replaceAll("[^a-zA-Z]*", "");
  }

  public static String hash(String input) throws NoSuchAlgorithmException {
    Base64.Encoder encoder = Base64.getEncoder();
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(input.getBytes());
    return encoder.encodeToString(digest.digest());
  }
  
  public static void main(String[] args) throws NoSuchAlgorithmException {
    String password = "admin";
    System.out.println("Password: "+UserService.hash(password));
  }
}
