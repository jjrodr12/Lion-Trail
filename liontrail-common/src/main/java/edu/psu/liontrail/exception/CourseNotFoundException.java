package edu.psu.liontrail.exception;

public class CourseNotFoundException extends Exception {

  private static final long serialVersionUID = 7939724048540582729L;

  public CourseNotFoundException(String msg) {
    super(msg);
  }
  
  public CourseNotFoundException(Throwable t) {
    super(t);
  }
  
  public CourseNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }

}
