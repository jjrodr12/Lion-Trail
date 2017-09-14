package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.ApplicationStatus;

@Entity
@Table(name="application")
public class Application implements Serializable {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "application_seq_gen")
  @SequenceGenerator(name = "application_seq_gen", sequenceName = "application_id_seq", allocationSize = 1)
  private int id;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="student_id")
  @NotNull
  private Student student;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="major_id")
  @NotNull
  private Major major;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="semester_id")
  @NotNull
  private Semester semester;
  
  @Column(name="status", length=25)
  @NotNull
  private ApplicationStatus status;
}
