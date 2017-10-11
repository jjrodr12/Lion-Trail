package edu.psu.liontrail.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(ClassResource.PATH)
@Api(ClassResource.PATH)
public interface ClassResource {
  
  public static final String PATH = "classes";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Class By Id", code=200, response=CourseDTO.class)
  Response getClass(@PathParam("id") int id);
  
  @GET
  //@Path("")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Class for student", code=200, response=CourseDTO.class)
  Response getClassesForStudent(@QueryParam("studentId") int studentId, @QueryParam("semesterId") int semesterId);
  
  @POST
  @Path("create")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Create a new Class", code=202, response=CourseDTO.class)
  Response createClass(CreateClassDTO dto);

}
