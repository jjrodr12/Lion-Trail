package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor extends User implements Serializable {

  private static final long serialVersionUID = -8116317226465534690L;

  
  
}
