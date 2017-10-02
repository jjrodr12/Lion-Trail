package edu.psu.liontrail.data;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.model.LiontrailClass;

public class GradedClass {
  private LiontrailClass liontrailClass;
  private Grade grade;
  private Double creditHours;
  
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
  public Double getGradeVal() {
    return grade.getValue();
  }
  public Double getCreditHours() {
    return creditHours; 
  }
  public Double setCreditHours(Double hours) {
    this.creditHours = hours;
    return creditHours;
  }
}