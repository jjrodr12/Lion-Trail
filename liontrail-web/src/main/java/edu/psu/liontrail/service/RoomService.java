package edu.psu.liontrail.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.store.RoomStore;

@Stateless
public class RoomService {

  @Inject
  RoomStore roomStore;
  
  public Room getRoomById(int id) {
    return roomStore.getRoomById(id);
  }
}
