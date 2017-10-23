package edu.psu.liontrail.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.service.SemesterService;

public class GradeResourceImpl implements GradeResource {
  
  //@Inject
  //GradeService service;

  @Override
  public Response getGradesById(int id) {
    return null;
  };
  
  /*@Override
  public Response getSemesterById(int id) {
    Semester semester = service.getSemester(id);
    return Response.ok().entity(semester).build();
  }

  @Override
  public Response getAllSemesters() {
    List<Semester> semesters = service.getAllSemesters();
    GenericEntity<List<Semester>> list = new GenericEntity<List<Semester>>(semesters){};
    return Response.ok().entity(list).build();
  }

  @Override
  public Response getSemesterByYearAndSeason(int year, SemesterSeason season) {
    try {
      Semester semester = service.getSemester(season, year);
      return Response.ok().entity(semester).build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response updateSemester(int id, Semester semester) {
    if (semester == null) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "smester payload was null");
      return em.toResponse();
    }
    if (semester.getId() != id) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "id of semester does not path value");
      return em.toResponse();
    }
    
    try {
      service.updateSemester(semester);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response createSemester(int id, Semester semester) {
    if (semester == null) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "smester payload was null");
      return em.toResponse();
    }
    if (semester.getId() != id) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "id of semester does not path value");
      return em.toResponse();
    }
    
    try {
      service.addSemester(semester);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response getGrades(int studentId) {
    // TODO Auto-generated method stub
    return null;
  }*/

}
