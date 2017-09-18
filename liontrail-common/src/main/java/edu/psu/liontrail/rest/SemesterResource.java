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

@Path(SemesterResource.PATH)
public interface SemesterResource {
  
  public static final String PATH = "semesters";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  Response getSemesterById(@PathParam("id") int id);
  
  @GET
  @Path("all")
  @Produces({ MediaType.APPLICATION_JSON })
  Response getAllSemesters();
  
  @GET
  @Path("year/{year}/season/{season}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  Response getSemesterByYearAndSeason(@PathParam("year") int year, @PathParam("season") SemesterSeason season);
  
  @PUT
  @Path("id/{id}")
  Response updateSemester(@PathParam("id") int id, Semester semester);
  
  @POST
  @Path("id/{id}")
  Response createSemester(@PathParam("id") int id, Semester semester);

}
