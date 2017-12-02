package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.ClassEnrollment;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.model.Student;

@Stateless
public class EnrollmentStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  /*
  public ClassEnrollment getGradeById(int id) {
    return em.find(ClassEnrollment.class, id);
  }
  */
  
  public List<ClassEnrollment> getGradeById(int studentId) {
    TypedQuery<ClassEnrollment> query = em.createNamedQuery(ClassEnrollment.BY_STUDENT, ClassEnrollment.class);
    query.setParameter("studentId", studentId);
    
    return query.getResultList();
  }
}