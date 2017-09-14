package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admission")
public class Admission implements Serializable {

  @Id
  @Column(name="cohort_id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "cohort_seq_gen")
  @SequenceGenerator(name = "cohort_seq_gen", sequenceName = "cohort_id_seq", allocationSize = 1)
  private int cohortId;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="major_id")
  @NotNull
  private Major major;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="semetser_id")
  @NotNull
  private Semester semeser;
  
  @Column(name="cohort_size")
  private int cohortSize;
  
  @ManyToMany
  @JoinTable(name="admission_student",
  joinColumns=@JoinColumn(name="cohort", referencedColumnName="cohort_id"),
  inverseJoinColumns=@JoinColumn(name="student", referencedColumnName="user_id"))
  private List<Student> students;
}
