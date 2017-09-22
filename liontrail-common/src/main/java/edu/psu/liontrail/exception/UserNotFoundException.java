package edu.psu.liontrail.exception;

public class UserNotFoundException extends Exception {
  
  private static final long serialVersionUID = 6768091235336163710L;

  public UserNotFoundException(String msg) {
    super(msg);
  }
  
  public UserNotFoundException(Throwable t) {
    super(t);
  }
  
  public UserNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }

}
