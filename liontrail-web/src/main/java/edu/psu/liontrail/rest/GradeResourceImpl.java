package edu.psu.liontrail.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.ClassEnrollmentDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.ClassEnrollment;
import edu.psu.liontrail.service.BuildingService;
import edu.psu.liontrail.service.ClassService;
import edu.psu.liontrail.service.EnrollmentService;

public class GradeResourceImpl implements GradeResource {
  @Inject
  EnrollmentService enrollService;
  
  
  @Override
  public Response getGradesForStudent(int studentId) {
    ClassEnrollment dto = enrollService.getGradesById(studentId);
    return Response.ok().entity(dto).build();
  }
}