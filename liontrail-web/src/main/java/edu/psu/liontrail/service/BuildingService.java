package edu.psu.liontrail.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.store.BuildingStore;

@Stateless
public class BuildingService {

  @Inject
  BuildingStore buildingStore;
  
  public Building getBuildingById(int id) {
    return buildingStore.getBuildingById(id);
  }
  
  public void addRoom(int buildingId, Room room) throws BuildingNotFoundException {
    Building building = buildingStore.getBuildingById(buildingId);
    if (building == null) {
      throw new BuildingNotFoundException("No building found with id: "+buildingId);
    }
  }
  
  public Building getBuildingByRoomId(int roomId) {
    return buildingStore.getBuildingByRoomId(roomId);
  }
  
  public List<Building> getAllBuildings() {
    return buildingStore.getAllBuildings();
  }
  
  public List<Building> getBuildingsByDepartment(Departments department) {
    return buildingStore.getBuildingsByDepartment(department);
  }
}
