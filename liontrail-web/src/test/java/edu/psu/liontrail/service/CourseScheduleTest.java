package edu.psu.liontrail.service;

 import org.junit.Ignore;
 import org.junit.Test;
 import org.junit.Assert;
 import org.junit.Before;
 import org.junit.Test;
 import org.mockito.Mock;
 import org.mockito.Mockito;
 
 public class CourseScheduleTest {
 
   @Test
   @Ignore
   public void testSetExamDate {
     //Setup application data
     //Set default instructorID
     //Verify instructorID exists in Instructor
     //Verify courseID exists in Course (class instance of Course)
     //Verify date entry from Instructor is correct format
     //Verify date entry from Instructor is after start date and before end date of course
     //Verify exam date updated in Schedule
   }
   
   @Test
   @Ignore
   public void testViewClassRoster {
     //Setup application data
     //Set default instructorID
     //Set default courseID (class instance of Course)
     //Verify instructorID exists in Instructor
     //Verify courseID exists in Course
     //Verify successful return of studentID associated with Course
     //Verify successful return of list of student information using studentID
     //Verify the display roster of students
   }
   
   @Test
   @Ignore
   public void testShowStudentClassSchedule() {
     //Setup application data
     //Get current date time for default calendar setup
     //Set default student id
     //Check student id is valid id against Student table
     //Check student is associated with current classes (Course)
     //Merge studentid with classes (course instances) associated
     //Return exam dates from classes
     //Return add/drop periods from classes
     //Generate and verify student calendar
   }
   
   @Test
   @Ignore
   public void testShowInstructorClassSchedule() {
     //Setup application data
     //Get current date time for default calendar setup
     //Set default instructor id
     //Check instructor id is valid id against Instructor table
     //Check instructor is associated with current classes (Course)
     //Merge instructorid with classes (course instances) associated
     //Return exam dates from classes
     //Return add/drop periods from classes
     //Generate and verify student calendar  
   }  
 }