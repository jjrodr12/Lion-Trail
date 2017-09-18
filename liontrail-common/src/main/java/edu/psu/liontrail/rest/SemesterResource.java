package edu.psu.liontrail.rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(SemesterResource.PATH)
public interface SemesterResource {
  public static final String PATH = "semesters";
  
  @GET
  @Path("id/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  Response getSemesterById(@PathParam("id") int id);
  
  @GET
  @Path("all")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  Response getAllSemesters();
}
