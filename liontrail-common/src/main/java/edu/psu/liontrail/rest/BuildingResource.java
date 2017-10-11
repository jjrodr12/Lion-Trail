package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.BuildingDTO;
import edu.psu.liontrail.data.CourseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(BuildingResource.PATH)
@Api(BuildingResource.PATH)
public interface BuildingResource {
  
  public static final String PATH = "buildings";
  
  @GET
  @Path("id/{id}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Building By Id", code=200, response=BuildingDTO.class)
  Response getBuildingById(@PathParam("id") int id);
  
  @GET
  @Path("name/{name}")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @ApiOperation(value = "Get Building By Name", code=200, response=BuildingDTO.class)
  Response getBuildingByName(@PathParam("name") String name);

}
