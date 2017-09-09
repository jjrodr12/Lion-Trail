package edu.psu.lionltrail.rest;

import javax.ws.rs.core.Response;

import edu.psu.liontrail.data.SomeDTO;
import edu.psu.liontrail.enumeration.SomeEnum;
import edu.psu.liontrail.rest.TestResource;

public class TestResourceImpl implements TestResource {

  @Override
  public Response helloWorld(String name) {
    
    return Response.ok().entity(name).build();
  }

  @Override
  public Response someDto() {
    SomeDTO dto = new SomeDTO();
    dto.setString("This is a String");
    dto.setNumber(15);
    dto.setEnumeration(SomeEnum.THIRD);
    
    return Response.ok().entity(dto).build();
  }

}
