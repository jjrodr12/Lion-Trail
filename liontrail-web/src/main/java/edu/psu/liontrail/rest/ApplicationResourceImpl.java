package edu.psu.liontrail.rest;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.exception.ErrorMessage;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Response getApplicationsByStudenta(Integer studentId, String userId) {
    // TODO Auto-generated method stub
    return null;
  }

}
