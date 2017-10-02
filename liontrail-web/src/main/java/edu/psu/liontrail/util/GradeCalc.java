package edu.psu.liontrail.util;

import edu.psu.liontrail.data.GradedClass;

public class GradeCalc {
  public Double CalculateGrade(GradedClass gClass) {
    Double calculatedGrade = (gClass.getCreditHours() * gClass.getGradeVal())/gClass.getCreditHours();
    return calculatedGrade;
  }
}
