package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends User implements Serializable {

  
  private static final long serialVersionUID = 4812421700688572509L;
  
  /*@Id
  @Column(name="student_id")
  private int userId;
  
  @OneToOne
  @PrimaryKeyJoinColumn(name="student_id", referencedColumnName="user_id")
  private User user;*/
}
