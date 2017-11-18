package edu.psu.liontrail.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.ClassEnrollmentDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.data.GradeDTO;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.ClassEnrollment;
import edu.psu.liontrail.service.BuildingService;
import edu.psu.liontrail.service.ClassService;
import edu.psu.liontrail.service.EnrollmentService;
import edu.psu.liontrail.util.DTOConveter;

public class GradeResourceImpl implements GradeResource {
  @Inject
  EnrollmentService enrollService;
  
  
  @Override
  public Response getGradesForStudent(int studentId) {
    List<ClassEnrollment> enrollment = enrollService.getGradesById(studentId);
    if (enrollment == null) {
      enrollment = new ArrayList<>();
    }
    List<ClassEnrollmentDTO> dtos = new ArrayList<>();
    GradeDTO grades = new GradeDTO();
    //double gpas = CalculateGpa(dtos);
   
    for(ClassEnrollment e : enrollment ) {
      ClassEnrollmentDTO dto = DTOConveter.toClassEnrollmentDTO(e);
      dtos.add(dto);
    }
    grades.setClasses(dtos);
    grades.setGpa(3.0);
    //get the gpa via method and 
    // set the grade.gpa to grades that we get.
    return Response.ok().entity(grades).build();
    
  }
}
