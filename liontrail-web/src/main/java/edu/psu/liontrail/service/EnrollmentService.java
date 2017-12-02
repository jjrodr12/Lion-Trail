package edu.psu.liontrail.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.swing.ViewportLayout;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.enumeration.ClassFrequency;
import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.ClassEnrollment;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Employee;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.model.Student;
import edu.psu.liontrail.model.User;
import edu.psu.liontrail.store.ClassStore;
import edu.psu.liontrail.store.EnrollmentStore;
import edu.psu.liontrail.util.DTOConveter;
import io.swagger.annotations.License;



public class EnrollmentService {
  
  @Inject
  EnrollmentStore enrollmentStore;
  
  public List<ClassEnrollment> getGradesById(int id) {
    return enrollmentStore.getGradeById(id);
  }
}