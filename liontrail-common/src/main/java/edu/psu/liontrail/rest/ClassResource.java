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
  
  @PUT
  @Path("id/{classId}/{studentId}")
  @ApiOperation(value = "Add Student to Class", code=200, response=CourseDTO.class)
  Response addStudentToClass(@PathParam("classId") int classId, @PathParam("studentId") int studentId);
  
  @DELETE
  @Path("id/{classId}/{studentId}")
  @ApiOperation(value = "Add Student to Class", code=200, response=CourseDTO.class)
  Response removeStudentFromClass(@PathParam("classId") int classId, @PathParam("studentId") int studentId);
  
  @GET
  @Path("student/{studentId}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Class for student", code=200, response=CourseDTO.class)
  Response getClassesForStudent(@PathParam("studentId") int studentId);
  
  @POST
  @Path("create")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Create a new Class", code=202, response=CourseDTO.class)
  Response createClass(CreateClassDTO dto);
  
  @PUT
  @Path("/id/{id}")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Create a new Class", code=202)
  Response updateClass(@PathParam("id") int classId, CreateClassDTO dto);
  
  @GET
  @Path("courses/{courseId}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @ApiOperation(value = "Get Classes for Course", code=200, response=CourseDTO.class, responseContainer="list")
  Response getClassesForCourse(@PathParam("courseId") int courseId, @QueryParam("semesterId") Integer semesterId);

}
