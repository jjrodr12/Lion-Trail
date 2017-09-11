package edu.psu.liontrail.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="room_table")
public class RoomEntity implements Serializable{
 
  private static final long serialVersionUID = -2981346371602081870L;

  @Id
  @Column(name="id")
  private int id;
  
  @Column(name="room_name")
  private String roomName;
  
  @Column(name="building_number")
  private int buildingNumber;
  
  @Column(name="room_capacity")
  private int roomCapacity;
  
  @Column(name="custodian_id")
  private int custodianId;
  
  @Column(name="iscomputerlab")
  private boolean isComputerLab;
    
}
