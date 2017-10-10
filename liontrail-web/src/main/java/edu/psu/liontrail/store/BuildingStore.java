package edu.psu.liontrail.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.model.Building;

@Stateless
public class BuildingStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Building getBuildingById(int id) {
    return em.find(Building.class, id);
  }
  
  public List<Building> getBuildingByDepartment(Departments department) {
    TypedQuery<Building> query = em.createNamedQuery(Building.BY_DEPARTMENT, Building.class);
    query.setParameter("department", department);
    
    return query.getResultList();
  }
  
  public Building getBuildingByName(String name) {
    TypedQuery<Building> query = em.createNamedQuery(Building.BY_DEPARTMENT, Building.class);
    query.setParameter("name", name);
    
    return query.getSingleResult();
  }
  
  public Building getBuildingByRoomId(int roomId) {
    TypedQuery<Building> query = em.createNamedQuery(Building.BY_ROOM_ID, Building.class);
    query.setParameter("roomId", roomId);
    
    return query.getSingleResult();
  }

}
