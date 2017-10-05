package edu.psu.liontrail.store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.model.Major;

@Stateless
public class MajorStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Major getMajorById(int id) {
    return em.find(Major.class, id);
  }
  
  public Major getMajorByAbbreviation(String abbreviation) {
    TypedQuery<Major> query = em.createNamedQuery(Major.BY_ABBREVIATION, Major.class);
    query.setParameter("abbreviation", abbreviation);
    
    return query.getSingleResult();
  }
  
  public void createMajor(Major major) {
    em.persist(major);
  }
  
  public void updateMajor(Major major) {
    em.merge(major);
  }
}
