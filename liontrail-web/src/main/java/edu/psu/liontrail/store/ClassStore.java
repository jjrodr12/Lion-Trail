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
public class ClassStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public LiontrailClass getClassById(int id) {
    return em.find(LiontrailClass.class, id);
  }
  
  public void createClass(LiontrailClass ltClass) {
    em.persist(ltClass);
  }
  
  public void updateClass(LiontrailClass ltClass) {
    em.merge(ltClass);
  }
  
  public void addEnrollment(LiontrailClass ltClass, Student student) {
    ClassEnrollment enrollment = new ClassEnrollment();
    enrollment.setEnrolledClass(ltClass);
    enrollment.setGrade(Grade.IN_PROGRESS);
    enrollment.setStudent(student);
    ltClass.getEnrollments().add(enrollment);
    em.persist(enrollment);
    em.merge(ltClass);
  }
  
  public void deleteEnrollment(LiontrailClass ltClass, int enrollmentId) throws ValidationException {
    if (ltClass.getEnrollments() == null || ltClass.getEnrollments().isEmpty()) {
      throw new ValidationException("Class does not contain enrollments");
    }
    ClassEnrollment enrollment = em.find(ClassEnrollment.class, enrollmentId);
    if (enrollment == null) {
      throw new ValidationException("Could not find enrollment");
    }
    ltClass.getEnrollments().remove(enrollment);
    em.remove(enrollment);
    em.merge(ltClass);
  }
  
  public List<LiontrailClass> getClassByStudent(int studentId) {
    TypedQuery<LiontrailClass> query = em.createNamedQuery(LiontrailClass.BY_STUDENT, LiontrailClass.class);
    query.setParameter("studentId", studentId);
    
    return query.getResultList();
  }
  
  public List<LiontrailClass> getClassesByCourse(int courseId) {
    TypedQuery<LiontrailClass> query = em.createNamedQuery(LiontrailClass.BY_COURSE, LiontrailClass.class);
    query.setParameter("courseId", courseId);
    return query.getResultList();
  }
  
  public List<LiontrailClass> getClassesByCourse(int courseId, int semesterId) {
    TypedQuery<LiontrailClass> query = em.createNamedQuery(LiontrailClass.BY_COURSE_SEMESTER, LiontrailClass.class);
    query.setParameter("courseId", courseId);
    query.setParameter("semesterId", semesterId);
    return query.getResultList();
  }
}
