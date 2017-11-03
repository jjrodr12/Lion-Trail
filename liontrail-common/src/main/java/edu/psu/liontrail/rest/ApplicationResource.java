package edu.psu.liontrail.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.CreateApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(ApplicationResource.PATH)
@Api(ApplicationResource.PATH)
public interface ApplicationResource {
  
  public static final String PATH = "applications";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Application By Id", code=200, response=ApplicationDTO.class)
  Response getApplication(@PathParam("id") @NotNull int applicationId);
  
  @GET
  @Path("semesters/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Application By Semester", code=200, response=ApplicationDTO.class)
  Response getApplicationsBySemesterWithStatus(@PathParam("id") @NotNull int semesterId, @QueryParam("status") ApplicationStatus status);
  
  @GET
  @Path("students")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Application By Student", code=200, response=ApplicationDTO.class)
  Response getApplicationsByStudent(@QueryParam("studentId") Integer studentId, @QueryParam("userId") String userId);
  
  @POST
  @Path("create")
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Create Application", code=200, response=ApplicationDTO.class)
  Response createApplication(CreateApplicationDTO dto);
  
  @PUT
  @Path("id/{id}")
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Create Application", code=200, response=ApplicationDTO.class)
  Response updateApplication(@PathParam("id") int applicationId, CreateApplicationDTO dto);

}
