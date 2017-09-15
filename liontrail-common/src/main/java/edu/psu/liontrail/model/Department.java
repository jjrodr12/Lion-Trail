package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.psu.liontrail.enumeration.Departments;

@Entity
@Table(name="department", uniqueConstraints= {
    @UniqueConstraint(columnNames= {"name"})
})
public class Department implements Serializable {

  private static final long serialVersionUID = 4097698328192634906L;
  
  @Id
  @Column(name="id", length=60)
  @Enumerated(EnumType.STRING)
  private Departments id;
  
  @Column(name="name")
  @NotNull
  @Size(max=60)
  private String name;
  
  @OneToOne
  @JoinColumn(name="dean")
  @NotNull
  private Instructor dean;

  public Departments getId() {
    return id;
  }

  public void setId(Departments id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instructor getDean() {
    return dean;
  }

  public void setDean(Instructor dean) {
    this.dean = dean;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Department other = (Department) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}
