package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.model.Course;

@Stateless
public class CourseStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Course getCourseById(int id) {
    return em.find(Course.class, id);
  }
  
  public List<Course> getCourseByMajorId(int id) {
    TypedQuery<Course> query = em.createNamedQuery(Course.BY_MAJOR_ID, Course.class);
    query.setParameter("majorId", id);
    return query.getResultList();
  }
  
  public List<Course> getCourseByMajorAbbreviation(String abbreviation) {
    TypedQuery<Course> query = em.createNamedQuery(Course.BY_MAJOR_ABRV, Course.class);
    query.setParameter("abbreviation", abbreviation);
    return query.getResultList();
  }
  
  public void createCourse(Course course) {
    em.persist(course);
  }
  
  public void updateCourse(Course course) {
    em.merge(course);
  }
  
}
