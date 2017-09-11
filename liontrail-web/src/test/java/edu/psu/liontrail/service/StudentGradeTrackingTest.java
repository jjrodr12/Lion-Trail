package edu.psu.liontrail.service;

 import org.junit.Ignore;
 import org.junit.Test;
 import org.junit.Assert;
 import org.junit.Before;
 import org.junit.Test;
 import org.mockito.Mock;
 import org.mockito.Mockito;
 
 public class StudentGradeTrackingTest {
 
   @Test
   @Ignore
   public void testSetCourseGrade {
     //Setup application data
     //Set default instructorID
     //Verify instructorID exists in Instructor
     //Set default studentID
     //Verify studentID exists in Student
     //Set default courseID
     //Verify courseID exists in Course
     //Verify gradetracking attributes (gpa: float, credits: int)
     //Verify successful submission of grade for a student
   }
 
    public void testUpdateCourseGrade {
     //Setup application data
     //Set default instructorID
     //Verify instructorID exists in Instructor
     //Set default studentID
     //Verify studentID exists in Student
     //Set default courseID
     //Verify courseID exists in Course
     //Verify gradetracking attributes (gpa: float, credits: int)
     //Verify successful update submission of grade for a student
   }
   
   @Test
   @Ignore
   public void testViewCourseGrade {
     //Setup application data
     //Set default studentID
     //Verify studentID exists in Student
     //Set default courseID
     //Verify courseID exists in Course
     //Verify successful return from GradeTracking using courseID and studentID
     //Verify successful display of grade
   }
   
   @Test
   @Ignore
   public void testViewOverallGPA {
     //Setup application data
     //Set default studentID
     //Verify studentID exists in Student
     //Verify successful return of all course grades from GradeTracking using studentID
     //Verify calculation of GPA between 0.0 and 4.0 using gpa and credits for each course
     //Verify display of GPA to student
   }
   
   @Test
   @Ignore
   public void testViewAllStudentsGrades {
     //Setup application data
     //Set default instructorID
     //Verify instructorID exists in Instructor
     //Set default courseID
     //Verify courseID exists in Course
     //Verify return of studentIDs and gpa for courseID
     //Verify calculation of class GPA mean, median, standard deviation
     //Verify display of all student grade information
   } 
 }
