package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import edu.psu.liontrail.enumeration.Departments;

@Entity
@Table(name="building", uniqueConstraints= {
    @UniqueConstraint(columnNames= {"name"})
})
@NamedQueries({
  @NamedQuery(name=Building.BY_DEPARTMENT, query="SELECT b FROM Building b where b.department = :department"),
  @NamedQuery(name=Building.BY_NAME, query="SELECT b FROM Building b where b.name = :name"),
  @NamedQuery(name=Building.BY_ROOM_ID, query="SELECT b FROM Building b INNER JOIN b.rooms r where r.id = :roomId "),
  @NamedQuery(name=Building.ALL, query="SELECT b FROM Building b")
})
public class Building implements Serializable {

  private static final long serialVersionUID = 4758332368706588625L;
  
  public static final String BY_DEPARTMENT = "Building.findByDepartment";
  public static final String BY_NAME = "Building.findByName";
  public static final String BY_ROOM_ID = "Building.findByRoomId";
  public static final String ALL = "Building.findAll";
  
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "building_seq_gen")
  @SequenceGenerator(name = "building_seq_gen", sequenceName = "building_id_seq", allocationSize = 1)
  private int id;
  
  @Column(name="name")
  @NotNull
  @Size(max=70)
  private String name;
  
  @Column(name="occupancy_limit")
  @NotNull
  @Min(value=1)
  private int occupancyLimit;
  
  @Column(name="department", length=60)
  @NotNull
  @Enumerated(EnumType.STRING)
  private Departments department;
  
  @OneToMany(mappedBy="building", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
  @Fetch(FetchMode.SELECT)
  private List<Room> rooms;
  
  public void addRoom(Room room) {
    if (rooms == null) {
      rooms = new ArrayList<>();
    }
    room.setBuilding(this);
    rooms.add(room);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOccupancyLimit() {
    return occupancyLimit;
  }

  public void setOccupancyLimit(int occupancyLimit) {
    this.occupancyLimit = occupancyLimit;
  }

  public Departments getDepartment() {
    return department;
  }

  public void setDepartment(Departments department) {
    this.department = department;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }
  
  
}
