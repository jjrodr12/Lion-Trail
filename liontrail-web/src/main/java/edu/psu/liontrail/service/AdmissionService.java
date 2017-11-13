package edu.psu.liontrail.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
}
