package edu.psu.liontrail.data;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.model.LiontrailClass;

public class GradedClass {
  private LiontrailClass liontrailClass;
  private Grade grade;
  public LiontrailClass getLiontrailClass() {
    return liontrailClass;
  }
  public void setLiontrailClass(LiontrailClass liontrailClass) {
    this.liontrailClass = liontrailClass;
  }
  public Grade getGrade() {
    return grade;
  }
  public void setGrade(Grade grade) {
    this.grade = grade;
  }
  
  
}
