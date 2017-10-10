package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.RoomType;

@Entity
@Table(name="room",
  uniqueConstraints = {
      @UniqueConstraint(columnNames={"building","number"})
  }
)
public class Room implements Serializable {

  private static final long serialVersionUID = 2453041004102765519L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "room_seq_gen")
  @SequenceGenerator(name = "room_seq_gen", sequenceName = "room_id_seq", allocationSize = 1)
  private int id;
  
  @ManyToOne
  @JoinColumn(name="building")
  @NotNull
  private Building building;
  
  @Column(name="number")
  @NotNull
  private int number;
  
  @Column(name="type", length=40)
  @NotNull
  @Enumerated(EnumType.STRING)
  private RoomType type;
  
  @Column(name="capacity")
  @Min(value=0)
  private int capacity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public RoomType getType() {
    return type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Room other = (Room) obj;
    if (id != other.id)
      return false;
    return true;
  }
  
  
}
