package edu.psu.liontrail.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class FacilityManagementTest {

  @Test
  @Ignore
  public void testAddRoomWithValidID {
    //Setup application data
    //Set default facilitymanagerID
    //Verify facilitymanagerID exists in FacilityManager
    //Set roomID
    //Verify roomID cannot be null
    //Verify roomID does not already exist in Room
    //Verify Room attribute data types (roomID: int, buildingID: int, capacity: int, type: string)
    //Verify successful addition of new room
  }

  public void testUpdateRoomWithValidID {
    //Setup application data
    //Set default facilitymanagerID
    //Verify facilitymanagerID exists in FacilityManager
    //Set roomID
    //Verify roomID exists in Room
    //Verify Room attribute data types entered for update (roomID: int, buildingID: int, capacity: int, type: string)
    //Verify successful addition of room
  }
 
  public void testRemoveRoomWithValidID {
    //Setup application data
    //Set default facilitymanagerID
    //Verify facilitymanagerID exists in FacilityManager
    //Set roomID
    //Verify roomID exists in Room
    //Verify successful removal of room
  }

  @Test
  @Ignore
  public void testCheckRoomSchedule {
    //Setup application data
    //Set default roomID
    //Set default facilitymanagerID
    //Set default date time
    //Verify facilitymanagerID exists in FacilityManager
    //Verify roomID exists in Room
    //Verify roomID found in Schedule
    //Verify the return of a Room's Schedule
  }  
}
