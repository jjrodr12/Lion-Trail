package edu.psu.liontrail.store;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.model.ParentEntity;

@Stateless
public class ParentEntityStore {
  
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  /**
   * Get ParentEntity by the specified value
   * @param otherVal
   * @return
   */
  public ParentEntity getByOtherValue(String otherVal) {
    //Use entity manager to create a named query specified on the annotations on ParentEntity class
    TypedQuery<ParentEntity> query = em.createNamedQuery(ParentEntity.BY_SOME_VALUE, ParentEntity.class);
    //Set the named parameter value
    query.setParameter("value", otherVal);
    
    return query.getSingleResult();
  }
  
  public List<ParentEntity> getByOtherValueList(Collection<String> values) {
    TypedQuery<ParentEntity> query = em.createNamedQuery(ParentEntity.BY_VALUE_LIST, ParentEntity.class);
    //the value of the parameter is a collection instead of a single value
    query.setParameter("values", values);
    
    return query.getResultList();
  }

}
