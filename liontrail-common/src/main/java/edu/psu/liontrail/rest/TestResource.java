package edu.psu.liontrail.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(TestResource.PATH)
public interface TestResource {
	
	public static final String PATH = "test";
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	Response helloWorld(@QueryParam("name") String name);
	
	@GET
	@Path("someDto")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Response someDto();

}
