package edu.psu.liontrail.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.exception.CourseNotFoundException;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.service.CourseService;
import edu.psu.liontrail.store.CourseStore;
import edu.psu.liontrail.util.DTOConveter;

public class CourseResourceImpl implements CourseResource {
  
  @Inject
  CourseService courseService;

  @Override
  public Response getCourse(int id) {
    Course course = courseService.getCourseById(id);
    if (course == null) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No course found with id: "+id);
      return em.toResponse();
    }
    CourseDTO dto = DTOConveter.toCourseDTO(course, true);
    return Response.ok().entity(dto).build();
  }

  @Override
  public Response getCoursesByMajor(int major) {
    List<Course> courses = courseService.getCourseByMajorId(major);
    if (courses == null || courses.isEmpty()) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No course found major id: "+major);
      return em.toResponse();
    }
    
    List<CourseDTO> dtos = courses.stream().map(c -> DTOConveter.toCourseDTO(c, true)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response getCoursesByMajorAbbreviation(String major) {
    List<Course> courses = courseService.getCourseByMajorAbbreviation(major);
    if (courses == null || courses.isEmpty()) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No course found major abbreviation: "+major);
      return em.toResponse();
    }
    List<CourseDTO> dtos = courses.stream().map(c -> DTOConveter.toCourseDTO(c, true)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response createCourse(CourseDTO dto) {
    if (dto == null) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "payload cannot be null");
      return em.toResponse();
    }
    if (dto.getId() != 0) {
      dto.setId(0);
    }
    
    Course course = courseService.createCourse(dto);
    CourseDTO respDto = DTOConveter.toCourseDTO(course, true); 
    return Response.ok().entity(respDto).build();
  }

  @Override
  public Response addPrerequisite(int courseId, int preReqId) {
    try {
      courseService.addPrerequisite(courseId, preReqId);
      return Response.accepted().build();
    } catch (CourseNotFoundException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessage());
      return em.toResponse();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response deletePrerequisite(int courseId, int preReqId) {
    try {
      courseService.removePrerequisite(courseId, preReqId);
      return Response.accepted().build();
    } catch (CourseNotFoundException e) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, e.getMessage());
      return em.toResponse();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response updateCourse(int id, CourseDTO dto) {
    if (id != dto.getId()) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "Id in path does not match course id");
      return em.toResponse();
    }
    
    
    courseService.updateCourse(dto);
    return null;
  }
  
  

}
