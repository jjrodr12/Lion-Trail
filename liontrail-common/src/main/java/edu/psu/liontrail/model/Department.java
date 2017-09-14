package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.psu.liontrail.enumeration.Departments;

@Entity
@Table(name="department")
public class Department implements Serializable {

  private static final long serialVersionUID = 4097698328192634906L;
  
  @Id
  @Enumerated(EnumType.STRING)
  private Departments id;
  
  @Column(name="name")
  @NotNull
  @Size(max=60)
  private String name;
}
