package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.AdmissionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(AdmissionResource.PATH)
@Api(AdmissionResource.PATH)
public interface AdmissionResource {
  
  public static final String PATH = "admissions";
  
  @GET
  @Path("id/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Get Admission by ID", code=200, response=AdmissionDTO.class)
  Response getById(@PathParam("id") int id);
  
  @GET
  @Path("studentId/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Get Admission by ID", code=200, response=AdmissionDTO.class)
  Response getByStudentId(@PathParam("id") int studentId);
  
  @GET
  @Path("semester/{semesterId}/major/{majorId}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Get Admission by ID", code=200, response=AdmissionDTO.class, responseContainer="list")
  Response getByMajorSemester(@PathParam("semesterId") int semesterId, @PathParam("majorId") int majorId);

}
