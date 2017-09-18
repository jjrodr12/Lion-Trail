package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.model.SemesterEntity;

@Stateless
public class SemesterStore {
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public void createSemester(SemesterEntity semester) {
    em.persist(semester);
  }
  
  public void updateSemester(SemesterEntity semester) {
    em.merge(semester);
  }
  
  public SemesterEntity getSemesterById(int id) {
    return em.find(SemesterEntity.class, id);
  }
  
  public List<SemesterEntity> getAllSemesters(){
    TypedQuery<SemesterEntity> query = em.createNamedQuery(SemesterEntity.ALL,SemesterEntity.class);
    return query.getResultList();
  }
  
  
}
