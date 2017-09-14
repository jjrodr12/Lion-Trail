package edu.psu.liontrail.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.ClassFrequency;

@Entity
@Table(name="class")
public class Class implements Serializable {
  
  private static final long serialVersionUID = 3642657966915293123L;
  
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "class_seq_gen")
  @SequenceGenerator(name = "class_seq_gen", sequenceName = "class_id_seq", allocationSize = 1)
  private int id;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="semester_id")
  @NotNull
  private Semester semester;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="course_id")
  @NotNull
  private Course course;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="instructor_id")
  @NotNull
  private Instructor instructor;
  
  @Column(name="frequency", length=50)
  @Enumerated(EnumType.STRING)
  @NotNull
  private ClassFrequency frequency;
  
  @Column(name="start_time")
  @NotNull
  private LocalTime startTime;
  
  @Column(name="stop_time")
  @NotNull
  private LocalTime stopTime;
  
  //TODO: link to Umar's building entity
  
  @Column(name="online")
  @NotNull
  private boolean online;
  
  @Column(name="size")
  @NotNull
  private int size;

}
