package edu.psu.liontrail.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import edu.psu.liontrail.model.AuthUser;
import edu.psu.liontrail.model.Name;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {
  
  @Mock
  EntityManager em;
  
  //Entity to Test
  UserService userService;
  
  private static final String FIRST_NAME = "Albert";
  private static final String MIDDLE_NAME = "Brian";
  private static final String LAST_NAME = "Charles";
  private static final Name NAME = new Name(FIRST_NAME, MIDDLE_NAME, LAST_NAME);
  
  private static final String BASE = "abc";
  private static final String USER1 = BASE+"1";
  private static final String USER2 = BASE+"100";
  private static final String USER3 = BASE+"777";
  private static final String USER4 = BASE+"9";
  private static List<String> testUserNames = new ArrayList<>();
  
  private static final String PASSWORD = "P@ssword1";
  private static final String HASH = "APzd4m3XeveFilLjkT5vMzCjKzEhphvOkVzGFF/ERFM=";
  
  static {
    testUserNames.add(USER1);
    testUserNames.add(USER2);
    testUserNames.add(USER3);
    testUserNames.add(USER4);
  }
  
  @Before
  public void init() {
    userService = new UserService();
    
    em = Mockito.mock(EntityManager.class);
    userService.em = em;
  }
  
  @Test
  public void testHash() throws NoSuchAlgorithmException {
    final String password = PASSWORD;
    final String expected = HASH;
    String hash = UserService.hash(password);
    Assert.assertEquals(expected, hash);
  }
  
  @Test
  public void testfindUserNamesWithBase() throws Exception {
    @SuppressWarnings("unchecked")
    TypedQuery<AuthUser> mockedQuery = (TypedQuery<AuthUser>)Mockito.mock(TypedQuery.class);
    List<AuthUser> mockUsers = testUserNames.stream().map(u -> new AuthUser(u, "password")).collect(Collectors.toList());
    Mockito.when(mockedQuery.getResultList()).thenReturn(mockUsers);
    
    Mockito.when(em.createNamedQuery(AuthUser.NAME_LIKE, AuthUser.class)).thenReturn(mockedQuery);
    
    List<String> userNames =  Whitebox.invokeMethod(userService, "findUserNamesWithBase", USER2);
    Assert.assertEquals(testUserNames, userNames);
  }
  
  @Test
  public void testGetUserNameBase() throws Exception {
    String base = Whitebox.invokeMethod(userService, "getUserNameBase", NAME);
    Assert.assertEquals(BASE, base);
    
    Name badName = new Name("1First", "!Middle", "last");
    boolean exceptionCaught = false;
    try {
      Whitebox.invokeMethod(userService, "getUserNameBase", badName);
    } catch (IllegalArgumentException e) {
      exceptionCaught = true;
      Assert.assertEquals("Names must begin with character symbols", e.getMessage());
    }
    Assert.assertTrue(exceptionCaught);
  }
  
  @Test
  public void testStripNonCharacter() {
    String input = "!@#abc123ABC123!@#";
    String expected = "abcABC";
    
    String result = UserService.stripNonCharacter(input);
    Assert.assertEquals(expected, result);
  }
  
  @Test
  public void testRegisterUser() throws Exception {
    final String expectedUserName = "abc778";
    AuthUser expected = new AuthUser(expectedUserName, HASH);
    
    UserService spy = PowerMockito.spy(new UserService());
    PowerMockito.doReturn(BASE).when(spy, "getUserNameBase", NAME);
    PowerMockito.doReturn(testUserNames).when(spy, "findUserNamesWithBase", BASE);
    PowerMockito.doNothing().when(spy, "persistUser", Mockito.any(AuthUser.class));
    
    
    AuthUser result = spy.registerUser(NAME, PASSWORD);
    Assert.assertEquals(expected, result);
  }

}
