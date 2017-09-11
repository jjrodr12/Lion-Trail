package edu.psu.liontrail.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CourseAdministrationTest {
  
  @Test
  @Ignore
  public void testAddCourseWithIDValidation() {
    //Setup application data.
    //Set course id
    //Check that id cannot be null
    //Check that course id does not already exist
    //Check that course name does not already exist
    //Check attribute data types (id: int, name: string, instructor: string, isExpired: bool)
    //Verify course add works with required information
  }
  
  @Test
  @Ignore
  public void testRemoveCourseWithIDValidation() {
    //Setup application data.
    //Set course id to id that does not exist
    //Check you cannot remove course that does not exit. Give error message
    //Set course id to id that does exist
    //Find course id and check removal of valid course occurs
  }
  
  @Test
  @Ignore
  public void testAddCoursePrerequisiteWithIDValidation() {
    //Setup application data.
    //Set course id
    //Check that course id exists
    //Set prerequisite course id
    //Check prerequisite course id is a valid course
    //Verify adding prerequisite course works
  }
  
  @Test
  @Ignore
  public void testRemoveCoursePrerequisiteWithIDValidation() {
    //Setup application data.
    //Set course id
    //Check that course id exists
    //Set prerequisite course id
    //Check prerequisite course id is a valid course
    //Check prerequsitie course id exists as prerequisite course for course id
    //Verify removing prerequisite course works
  }
}
