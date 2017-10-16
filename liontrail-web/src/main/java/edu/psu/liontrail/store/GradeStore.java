package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.model.Semester;

@Stateless
public class GradeStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;

  public void createGrade(Grade grade) {
    em.persist(grade);
  }
  
  public void updateGrade(Grade grade) {
    em.merge(grade);
  }
  
  public Grade getGradeById(int id) {
    return em.find(Grade.class, id);
  }
  
  public List<Grade> getGradeBySemester(SemesterSeason season, Integer year) {
    // Under Construction
    // TypedQuery<Grade> query = em.createNamedQuery();
    // return query.getResultList();
    return null;
  }
  
  public Grade getGradeByProjection(int id, List<Grade> gradeList) {
    /*TypedQuery<Grade> query = em.createNamedQuery(Semester.BY_SEASON_AND_YEAR, Semester.class);
    query.setParameter("season", season);
    query.setParameter("year", year);
    return query.getSingleResult();*/
    return null;
  }

  public Semester getSemesterById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Semester> getAllSemesters() {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Grade> getAllGrades() {
    // TODO Auto-generated method stub
    return null;
  }

  public Grade getGradeBySemester(Object season, Object year) {
    // TODO Auto-generated method stub
    return null;
  }
}
