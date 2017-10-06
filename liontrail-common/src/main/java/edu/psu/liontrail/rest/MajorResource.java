package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.MajorDTO;
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
  @Path("abbreviation/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Major By Abbreviation", code=200, response=MajorDTO.class)
  Response getMajorByAbbreviation(@PathParam("abr") String abbreviation);
}
