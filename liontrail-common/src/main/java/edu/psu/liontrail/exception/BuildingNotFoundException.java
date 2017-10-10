package edu.psu.liontrail.exception;

public class BuildingNotFoundException extends Exception {

  private static final long serialVersionUID = -8733720205198021597L;

  public BuildingNotFoundException(String msg) {
    super(msg);
  }
  
  public BuildingNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }
  
  public BuildingNotFoundException(Throwable t) {
    super(t);
  }

}
