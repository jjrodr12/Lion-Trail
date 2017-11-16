package edu.psu.liontrail.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.data.CreateApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Application;
import edu.psu.liontrail.service.ApplicationService;

public class ApplicationResourceImpl implements ApplicationResource {
  
  @Inject
  ApplicationService applicationService;

  @Override
  public Response getApplication(int applicationId) {
    Application app = applicationService.getApplication(applicationId);
    if (app == null) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No application found with id: "+applicationId);
      return em.toResponse();
    }
    ApplicationDTO dto = applicationService.convert(app);
    return Response.ok().entity(dto).build();
  }

  @Override
  public Response getApplicationsBySemesterWithStatus(int semesterId, ApplicationStatus status) {
    List<Application> applications = null;
    if (status != null) {
      applications = applicationService.getApplicationsySemesterWithStatus(semesterId, status);
    } else {
      applications = applicationService.getApplicationsBySemester(semesterId);
    }
    if (applications == null) {
      applications = new ArrayList<>();
    }
    List<ApplicationDTO> dtos = applications.stream().map(a -> applicationService.convert(a)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response getApplicationsByStudent(Integer studentId, String userId) {
    List<Application> applications = null;
    if (studentId != null) {
      applications = applicationService.getApplicationForStudent(studentId);
    } else if (userId != null && !userId.trim().isEmpty()) {
      applications = applicationService.getApplicationForStudent(userId);
    } else {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, "No student identifer provided");
      return em.toResponse();
    }
    List<ApplicationDTO> dtos = applications.stream().map(a -> applicationService.convert(a)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response createApplication(CreateApplicationDTO dto) {
    try {
      Application app = applicationService.createApplication(dto);
      ApplicationDTO appDto = applicationService.convert(app);
      return Response.ok().entity(appDto).build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response updateApplication(int applicationId, CreateApplicationDTO dto) {
    try {
      Application app = applicationService.updateApplication(applicationId, dto);
      ApplicationDTO appDto = applicationService.convert(app);
      return Response.ok().entity(appDto).build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessages());
      return em.toResponse();
    }
  }

  @Override
  public Response acceptApplication(int applicationId) {
    try {
      applicationService.acceptApplication(applicationId);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessage());
      return em.toResponse();
    }
  }

  @Override
  public Response rejectApplication(int applicationId) {
    try {
      applicationService.rejectApplication(applicationId);
      return Response.accepted().build();
    } catch (ValidationException e) {
      ErrorMessage em = new ErrorMessage(Status.BAD_REQUEST, e.getMessage());
      return em.toResponse();
    }
  }

}
