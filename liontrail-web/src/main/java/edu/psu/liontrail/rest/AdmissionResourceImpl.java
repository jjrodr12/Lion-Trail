package edu.psu.liontrail.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.liontrail.data.AdmissionDTO;
import edu.psu.liontrail.exception.ErrorMessage;
import edu.psu.liontrail.model.Admission;
import edu.psu.liontrail.service.AdmissionService;

public class AdmissionResourceImpl implements AdmissionResource {
  
  @Inject
  AdmissionService admissionService;

  @Override
  public Response getById(int id) {
    Admission admission = admissionService.getById(id);
    if (admission == null) {
      ErrorMessage em = new ErrorMessage(Status.NOT_FOUND, "No admission found with id: "+id);
      return em.toResponse();
    }
    AdmissionDTO dto = admissionService.convert(admission);
    return Response.ok().entity(dto).build();
  }

  @Override
  public Response getByStudentId(int studentId) {
    List<Admission> admissions = admissionService.getByStudent(studentId);
    if (admissions == null) {
      admissions = new ArrayList<>();
    }
    List<AdmissionDTO> dtos = admissions.stream().map(a -> admissionService.convert(a)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

  @Override
  public Response getByMajorSemester(int semesterId, int majorId) {
    List<Admission> admissions = admissionService.getByMajorAndSemester(majorId, semesterId);
    if (admissions == null) {
      admissions = new ArrayList<>();
    }
    List<AdmissionDTO> dtos = admissions.stream().map(a -> admissionService.convert(a)).collect(Collectors.toList());
    return Response.ok().entity(dtos).build();
  }

}
