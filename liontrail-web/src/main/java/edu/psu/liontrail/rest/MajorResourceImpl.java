package edu.psu.liontrail.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.BaseMajorDTO;
import edu.psu.liontrail.data.CreateMajorGroupDTO;
import edu.psu.liontrail.data.MajorDTO;
import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.MajorGroup;
import edu.psu.liontrail.service.MajorService;
import edu.psu.liontrail.util.DTOConveter;

public class MajorResourceImpl implements MajorResource {
  
  @Inject
  MajorService majorService;

  @Override
  public Response getMajorById(int id) {
    Major major = majorService.getMajorById(id);
    if (major == null) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No major found with id: "+id);
      return em.toResponse();
    }
    MajorDTO dto = DTOConveter.toMajorDTO(major);
    return Response.ok().entity(dto).build();
  }

  @Override
  public Response getMajorByAbbreviation(String abbreviation) {
    List<Major> majors = majorService.getMajorByAbbreviation(abbreviation);
    if (majors == null || majors.isEmpty()) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No majors found with abbreviation: "+abbreviation);
      return em.toResponse();
    }
    List<MajorDTO> dtos = majors.stream().map(m -> DTOConveter.toMajorDTO(m)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }
  
  @Override
  public Response getMajorByDepartment(Departments department) {
    List<Major> majors = majorService.getMajorByDepartment(department);
    if (majors == null || majors.isEmpty()) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No majors associated with department: "+department);
      return em.toResponse();
    }
    List<MajorDTO> dtos = majors.stream().map(m -> DTOConveter.toMajorDTO(m)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response updateMajorData(int id, BaseMajorDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Response addRequiredCourse(int majorId, int courseId) {
    try {
      majorService.addRequiredCourse(majorId, courseId);
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
    return Response.accepted().build();
  }

  @Override
  public Response removeRequiredCourse(int majorId, int courseId) {
    try {
      majorService.removeRequiredCourse(majorId, courseId);
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
    return Response.accepted().build();
  }

  @Override
  public Response createGroup(int id, CreateMajorGroupDTO dto) {
    System.out.println("Creating Group majorId: "+id);
    try {
      MajorGroup group = majorService.createMajorGroup(id, dto);
      return Response.ok().entity(group.getId()).build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response updateMajorGroup(int majorId, int groupId, CreateMajorGroupDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Response deleteMajorGroup(int majorId, int groupId) {
    // TODO Auto-generated method stub
    return null;
  }

  

}
