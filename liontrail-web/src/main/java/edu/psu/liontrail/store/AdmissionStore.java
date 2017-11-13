package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.model.Admission;

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
    TypedQuery<Admission> query = em.createNamedQuery(Admission.BY_STUDENT, Admission.class);
    query.setParameter("majorId", majorId);
    return query.getResultList();
  }

}
