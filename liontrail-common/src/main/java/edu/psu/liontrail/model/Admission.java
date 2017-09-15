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

  private static final long serialVersionUID = 7876124618829632052L;

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

  public int getCohortId() {
    return cohortId;
  }

  public void setCohortId(int cohortId) {
    this.cohortId = cohortId;
  }

  public Major getMajor() {
    return major;
  }

  public void setMajor(Major major) {
    this.major = major;
  }

  public Semester getSemeser() {
    return semeser;
  }

  public void setSemeser(Semester semeser) {
    this.semeser = semeser;
  }

  public int getCohortSize() {
    return cohortSize;
  }

  public void setCohortSize(int cohortSize) {
    this.cohortSize = cohortSize;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((major == null) ? 0 : major.hashCode());
    result = prime * result + ((semeser == null) ? 0 : semeser.hashCode());
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
    Admission other = (Admission) obj;
    if (major == null) {
      if (other.major != null)
        return false;
    } else if (!major.equals(other.major))
      return false;
    if (semeser == null) {
      if (other.semeser != null)
        return false;
    } else if (!semeser.equals(other.semeser))
      return false;
    return true;
  }
  
  
}
