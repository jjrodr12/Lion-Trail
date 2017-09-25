package edu.psu.liontrail.util;

import java.util.Collection;
import java.util.Iterator;
import edu.psu.liontrail.data.GradedClass;

public class GpaCalculator {
  public static double CalculateGpa(Collection<GradedClass> classes) {
    if (classes != null && classes.size() > 0) {
      Iterator<GradedClass> itr = classes.iterator();
      Double gradeOfClass;
      Double sumOfGrade = 0.0;
      int counter = 0;
      ;

      while (itr.hasNext()) {
        gradeOfClass = itr.next().getGradeVal();
        if (gradeOfClass != null && gradeOfClass > 0.0) {
          sumOfGrade = sumOfGrade + gradeOfClass;
          counter++;
        }
      }
      Double average = sumOfGrade / counter;
      return average;
    }

    return 0;
  }
}
