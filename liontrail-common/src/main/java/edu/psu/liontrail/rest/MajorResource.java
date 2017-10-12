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

import edu.psu.liontrail.data.BaseMajorDTO;
import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.CreateMajorGroupDTO;
import edu.psu.liontrail.data.MajorDTO;
import edu.psu.liontrail.enumeration.Departments;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(MajorResource.PATH)
@Api(MajorResource.PATH)
public interface MajorResource {
  
  public static final String PATH = "majors";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Major By Id", code=200, response=MajorDTO.class)
  Response getMajorById(@PathParam("id") int id);

  @GET
  @Path("abbreviation/{abr}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Major By Abbreviation", code=200, response=MajorDTO.class, responseContainer="list")
  Response getMajorByAbbreviation(@PathParam("abr") String abbreviation);
  
  @GET
  @Path("department/{department}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Majors forDepartment", code=200, response=MajorDTO.class, responseContainer="list")
  Response getMajorByDepartment(@PathParam("department") Departments department);
  
  @PUT
  @Path("id/{id}")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Update Major", code=202)
  Response updateMajorData(@PathParam("id") int id, BaseMajorDTO dto);
  
  @PUT
  @Path("id/{id}/requirement/{courseId}")
  @ApiOperation(value = "Add Requiremented Course to Major", code=202)
  Response addRequiredCourse(@PathParam("id") int majorId, @PathParam("courseId") int courseId);
  
  @DELETE
  @Path("id/{id}/requirement/{courseId}")
  @ApiOperation(value = "Add Requiremented Course to Major", code=202)
  Response removeRequiredCourse(@PathParam("id") int majorId, @PathParam("courseId") int courseId);
  
  @POST
  @Path("id/{id}/group")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Create Major Course Group", code=202, response=Integer.class)
  Response createGroup(@PathParam("id") int id, CreateMajorGroupDTO dto);
  
  @PUT
  @Path("id/{id}/group/{groupId}")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Update Major Course Group", code=202)
  Response updateMajorGroup(@PathParam("id") int majorId, @PathParam("groupId") int groupId, CreateMajorGroupDTO dto);
  
  @DELETE
  @Path("id/{id}/group/{groupId}")
  @ApiOperation(value = "Delete Major Course Group", code=202)
  Response deleteMajorGroup(@PathParam("id") int majorId, @PathParam("groupId") int groupId);
}
