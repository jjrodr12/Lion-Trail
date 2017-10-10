package edu.psu.liontrail.store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.model.LiontrailClass;

@Stateless
public class ClassStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public void createClass(LiontrailClass ltClass) {
    em.persist(ltClass);
  }
  
  public void updateClass(LiontrailClass ltClass) {
    em.merge(ltClass);
  }
}
