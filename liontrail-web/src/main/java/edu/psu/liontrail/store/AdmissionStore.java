package edu.psu.liontrail.store;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Admission;
import edu.psu.liontrail.model.Student;

@Stateless
public class AdmissionStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Admission getById(int admissionId) {
    return em.find(Admission.class, admissionId);
  }
  
  public List<Admission> getByStudentId(int studentId) {
    TypedQuery<Admission> query = em.createNamedQuery(Admission.BY_STUDENT, Admission.class);
    query.setParameter("studentId", studentId);
    return query.getResultList();
  }
  
  public List<Admission> getByMajorSemester(int majorId, int semesterId) {
    TypedQuery<Admission> query = em.createNamedQuery(Admission.BY_MAJOR_SEMESTER, Admission.class);
    query.setParameter("majorId", majorId);
    query.setParameter("semesterId", semesterId);
    return query.getResultList();
  }
  
  public void addStudent(int admissionId, Student student) throws ValidationException {
    if (student == null) {
      throw new ValidationException("Student cannot be null");
    }
    Admission admission = getById(admissionId);
    if (admission == null) {
      throw new ValidationException("No admission found with id: "+admissionId);
    }
    if (admission.getStudents() == null) {
      admission.setStudents(new ArrayList<>());
    }
    if (admission.getStudents().size() >= admission.getCohortSize()) {
      throw new ValidationException("Major is currently full");
    }
    boolean hasExistingStudent = admission.getStudents().stream()
                                .anyMatch(s -> s.getId() == student.getId());
    if (hasExistingStudent) {
      throw new ValidationException("Student is already in accepted to major");
    }
    admission.getStudents().add(student);
    em.merge(admission);
  }

}
