package edu.psu.liontrail.store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.model.Room;

@Stateless
public class RoomStore {
  
  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Room getRoomById(int id) {
    return em.find(Room.class, id);
  }

}
