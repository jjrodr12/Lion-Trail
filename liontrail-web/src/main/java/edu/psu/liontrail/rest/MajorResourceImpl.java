package edu.psu.liontrail.rest;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.MajorDTO;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.service.MajorService;
import edu.psu.liontrail.util.DTOConveter;

public class MajorResourceImpl implements MajorResource {
  
  @Inject
  MajorService majorService;

  @Override
  public Response getMajorById(int id) {
    Major major = majorService.getMajorById(id);
    if (major == null) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No major found with id: "+id);
      return em.toResponse();
    }
    MajorDTO dto = DTOConveter.toMajorDTO(major);
    return Response.ok().entity(dto).build();
  }

  @Override
  public Response getMajorByAbbreviation(String abbreviation) {
    // TODO Auto-generated method stub
    return null;
  }

}
