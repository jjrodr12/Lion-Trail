package edu.psu.liontrail.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="building_table")
public class BuildingEntity implements Serializable{
 
  

  /**
   * 
   */
  private static final long serialVersionUID = 9151793060264812098L;

  @Id
  @Column(name="id")
  private int id;
  
  @Column(name="building_name")
  private String buildingName;
  
  @Column(name="building_number")
  private int buildingNumber;
  
  @Column(name="building_capacity")
  private int buildingCapacity;
  
  @Column(name="custodian_id")
  private int custodianId;
  
  @Column(name="college_id")
  private int collegeId;
    
}
