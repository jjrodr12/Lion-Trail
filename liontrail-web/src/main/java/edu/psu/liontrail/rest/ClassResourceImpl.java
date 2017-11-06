package edu.psu.liontrail.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.service.BuildingService;
import edu.psu.liontrail.service.ClassService;
import edu.psu.liontrail.util.DTOConveter;

public class ClassResourceImpl implements ClassResource {
  
  @Inject
  ClassService classService;
  
  @Inject
  BuildingService buildingService;

  @Override
  public Response getClass(int id) {
    try {
      ClassDTO dto = classService.getClassDTOById(id);
      return Response.ok().entity(dto).build();
    } catch (BuildingNotFoundException | ClassNotFoundException e) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, e.getMessage());
      return em.toResponse();
    }
  }

  @Override
  public Response getClassesForStudent(int studentId) {
    List<ClassDTO> dtos = classService.getClassesForStudent(studentId);
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response createClass(CreateClassDTO dto) {
    try {
      ClassDTO responseDto = classService.createClass(dto);
      return Response.ok().entity(responseDto).build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response addStudentToClass(int classId, int studentId) {
    try {
      classService.addStudentToClass(classId, studentId);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response removeStudentFromClass(int classId, int studentId) {
    try {
      classService.removeStaudentFromClass(classId, studentId);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response updateClass(int classId, CreateClassDTO dto) {
    try {
      classService.updateClass(classId, dto);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response getClassesForCourse(int courseId) {
    List<LiontrailClass> classes = classService.getClassesForCourse(courseId);
    if (classes == null || classes.isEmpty()) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No classes found for courseId: "+courseId);
      return em.toResponse();
    }
    List<ClassDTO> dtos = classes.stream().map(c -> DTOConveter.toClassDTO(c, null)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
    
  }

}
