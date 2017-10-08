package edu.psu.liontrail.rest;

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
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Semester;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(CourseResource.PATH)
@Api(CourseResource.PATH)
public interface CourseResource {
  
  public static final String PATH = "courses";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Course By Id", code=200, response=CourseDTO.class)
  Response getCourse(@PathParam("id") int id);
  
  @GET
  @Path("major/{major}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Courses By Major Id", code=200, response=CourseDTO.class, responseContainer="list")
  Response getCoursesByMajor(@PathParam("major") int major);
  
  @GET
  @Path("major/abbreviation/{major}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Courses By Major Abbreviation", code=200, response=CourseDTO.class, responseContainer="list")
  Response getCoursesByMajorAbbreviation(@PathParam("major") String major);
  
  @POST
  @Path("create")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Create a new Course", code=200, response=CourseDTO.class, responseContainer="list")
  Response createCourse(CourseDTO dto);
  
  @PUT
  @Path("id/{id}/prerequisites/{preReq}")
  @ApiOperation(value = "Add a Prerequisite Course", code=202)
  Response addPrerequisite(@PathParam("id") int courseId, @PathParam("preReq") int preReqId);

  @DELETE
  @Path("id/{id}/prerequisites/{preReq}")
  @ApiOperation(value = "Add a Prerequisite Course", code=202)
  Response deletePrerequisite(@PathParam("id") int courseId, @PathParam("preReq") int preReqId);
  
  @PUT
  @Path("id/{id}")
  @ApiOperation(value = "Update Course details", code=202)
  Response updateCourse(@PathParam("id") int id, CourseDTO course);
}
