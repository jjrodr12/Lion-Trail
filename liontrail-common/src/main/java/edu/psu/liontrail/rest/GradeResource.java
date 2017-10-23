package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(SemesterResource.PATH)
public interface GradeResource {

  public static final String PATH = "grades";

  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  Response getGradesById(@PathParam("id") int id);

}
