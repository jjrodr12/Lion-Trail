package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.model.Semester;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(SemesterResource.PATH)
@Api(SemesterResource.PATH)
public interface SemesterResource {
  
  public static final String PATH = "semesters";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Semester By Id", response=Semester.class)
  Response getSemesterById(@PathParam("id") int id);
  
  @GET
  @Path("all")
  @Produces({ MediaType.APPLICATION_JSON })
  @ApiOperation(value = "Get All Semesters", response=Semester.class, responseContainer="list")
  Response getAllSemesters();
  
  @GET
  @Path("year/{year}/season/{season}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Semester By Year and Season", response=Semester.class)
  Response getSemesterByYearAndSeason(@PathParam("year") int year, @PathParam("season") SemesterSeason season);
  
  @PUT
  @Path("id/{id}")
  @ApiOperation(value = "Semester", code=204)
  Response updateSemester(@PathParam("id") int id, Semester semester);
  
  @POST
  @Path("create")
  Response createSemester(Semester semester);

}
