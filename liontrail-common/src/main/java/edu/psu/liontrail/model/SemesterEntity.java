package edu.psu.liontrail.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="semester_table")
public class SemesterEntity implements Serializable{
 
  

  /**
   * 
   */
  private static final long serialVersionUID = 5819403870035861868L;

  public static final String ALL = null;

  @Id
  @Column(name="id")
  private int id;
  
  @Column(name="semester_name")
  private String semesterName;
  
  @Column(name="season")
  private String season;
  
  @Column(name="year")
  private int year;
  
}
