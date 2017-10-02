package edu.psu.liontrail.util;

import edu.psu.liontrail.data.StudentData;

public class GradeViewer {
private StudentData studentData;
  
  public double getGpa(StudentData stuDat) {
    return stuDat.getCumeGpa();
  }
}
