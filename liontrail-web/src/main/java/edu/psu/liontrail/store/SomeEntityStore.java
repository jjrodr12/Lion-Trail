package edu.psu.liontrail.store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.model.SomeEntity;

@Stateless
public class SomeEntityStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;

  /**
   * Get Entity by Primary Key
   * @param id Primary Key
   * @return Entity from database or null if not found
   */
  public SomeEntity getById(String id) {
    SomeEntity se = em.find(SomeEntity.class, id);
    return se;
  }
  
  /**
   * Save an entity to the database. This will throw a runtime exception if entity already exists.
   * @param entity Entity to save
   */
  public void addEntity(SomeEntity entity) {
    em.persist(entity);
  }
  
  /**
   * Update an existing entity.
   * @param entity
   */
  public void updateEntity(SomeEntity entity) {
    em.merge(entity);
  }
  
  /**
   * Delete an entity from the database.
   * @param entity
   */
  public void deleteEntity(SomeEntity entity) {
    em.remove(entity);
  }
}
