package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.model.Semester;

@Stateless
public class SemesterStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;

  public void createSemester(Semester semester) {
    em.persist(semester);
  }
  
  public void updateSemester(Semester semester) {
    em.merge(semester);
  }
  
  public Semester getSemesterById(int id) {
    return em.find(Semester.class, id);
  }
  
  public List<Semester> getAllSemesters() {
    TypedQuery<Semester> query = em.createNamedQuery(Semester.ALL, Semester.class);
    return query.getResultList();
  }
  
  public Semester getSemesterBySeasonAndYear(SemesterSeason season, int year) {
    TypedQuery<Semester> query = em.createNamedQuery(Semester.BY_SEASON_AND_YEAR, Semester.class);
    query.setParameter("season", season);
    query.setParameter("year", year);
    return query.getSingleResult();
  }
}
