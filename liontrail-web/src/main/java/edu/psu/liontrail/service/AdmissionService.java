package edu.psu.liontrail.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.data.AdmissionDTO;
import edu.psu.liontrail.model.Admission;
import edu.psu.liontrail.store.AdmissionStore;

@Stateless
public class AdmissionService {

  @Inject
  AdmissionStore admissionStore;
  
  public Admission getById(int admissionId) {
    return admissionStore.getById(admissionId);
  }
  
  public List<Admission> getByStudent(int studentId) {
    return admissionStore.getByStudentId(studentId);
  }
  
  public List<Admission> getByMajorAndSemester(int majorId, int semesterId) {
    return admissionStore.getByMajorSemester(majorId, semesterId);
  }
  
  public AdmissionDTO convert(Admission admission) {
    AdmissionDTO dto = new AdmissionDTO();
    dto.setCohortId(admission.getCohortId());
    dto.setCohortSize(admission.getCohortSize());
    dto.setMajorId(admission.getMajor().getId());
    dto.setMajorAbbreviation(admission.getMajor().getAbbreviation());
    dto.setMajorName(admission.getMajor().getName());
    dto.setSemesterId(admission.getSemeser().getId());
    dto.setSemesterSeason(admission.getSemeser().getSeason());
    dto.setSemesterYear(admission.getSemeser().getYear());
    List<Integer> studentIds = new ArrayList<>();
    if (admission.getStudents() != null) {
      admission.getStudents().forEach(s -> studentIds.add(s.getId()));
    }
    dto.setStudentIds(studentIds);
    return dto;
  }
}
