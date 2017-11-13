package edu.psu.liontrail.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.ClassEnrollmentDTO;
import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(GradeResource.PATH)
@Api(GradeResource.PATH)

public interface GradeResource {
  
  public static final String PATH = "grades";
  
  @GET
  @Path("student/{studentId}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Grade for student", code=200, response=ClassEnrollmentDTO.class)
  Response getGradesForStudent(@PathParam("studentId") int studentId);
  
}