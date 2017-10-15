package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.MajorGroup;

@Stateless
public class MajorStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Major getMajorById(int id) {
    return em.find(Major.class, id);
  }
  
  public List<Major> getMajorByAbbreviation(String abbreviation) {
    TypedQuery<Major> query = em.createNamedQuery(Major.BY_ABBREVIATION, Major.class);
    query.setParameter("abbreviation", abbreviation);
    
    return query.getResultList();
  }
  
  public List<Major> getMajorByDepartment(Departments department) {
    TypedQuery<Major> query = em.createNamedQuery(Major.BY_DEPARTMENT, Major.class);
    query.setParameter("department", department);
    return query.getResultList();
  }
  
  public void createMajor(Major major) {
    em.persist(major);
  }
  
  public void updateMajor(Major major) {
    em.merge(major);
  }
  
  public void deleteMajorGroup(MajorGroup group) {
    em.remove(group);
  }
}
