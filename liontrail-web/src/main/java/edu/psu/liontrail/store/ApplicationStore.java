package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.model.Application;

@Stateless
public class ApplicationStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Application getApplicationById(int applicationId) {
    return em.find(Application.class, applicationId);
  }
  
  public List<Application> getApplicationForSemester(int semesterId) {
    TypedQuery<Application> query = em.createNamedQuery(Application.BY_SEMESTER, Application.class);
    query.setParameter("semesterId", semesterId);
    return query.getResultList();
  }
  
  public List<Application> getApplicationForSemesterWithStatus(int semesterId, ApplicationStatus status) {
    TypedQuery<Application> query = em.createNamedQuery(Application.BY_SEMESTER_AND_STATUS, Application.class);
    query.setParameter("semesterId", semesterId);
    query.setParameter("status", status);
    return query.getResultList();
  }
  
  public List<Application> getApplicationForStudent(int studentId) {
    TypedQuery<Application> query = em.createNamedQuery(Application.BY_STUDENT_ID, Application.class);
    query.setParameter("studentId", studentId);
    return query.getResultList();
  }
  
  public List<Application> getApplicationForStudent(String username) {
    TypedQuery<Application> query = em.createNamedQuery(Application.BY_STUDENT_USER_ID, Application.class);
    query.setParameter("userName", username);
    return query.getResultList();
  }
  
  public Application createApplication(Application app) {
    em.persist(app);
    return app;
  }
  
  public Application updateApplication(Application app) {
    return em.merge(app);
  }
}
