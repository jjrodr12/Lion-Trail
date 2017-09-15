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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.ApplicationStatus;

@Entity
@Table(name="application", uniqueConstraints= {
    @UniqueConstraint(columnNames={"student_id","major_id","semester_id"})
})
public class Application implements Serializable {

  private static final long serialVersionUID = -5251459086910748198L;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Major getMajor() {
    return major;
  }

  public void setMajor(Major major) {
    this.major = major;
  }

  public Semester getSemester() {
    return semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((major == null) ? 0 : major.hashCode());
    result = prime * result + ((semester == null) ? 0 : semester.hashCode());
    result = prime * result + ((student == null) ? 0 : student.hashCode());
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
    Application other = (Application) obj;
    if (major == null) {
      if (other.major != null)
        return false;
    } else if (!major.equals(other.major))
      return false;
    if (semester == null) {
      if (other.semester != null)
        return false;
    } else if (!semester.equals(other.semester))
      return false;
    if (student == null) {
      if (other.student != null)
        return false;
    } else if (!student.equals(other.student))
      return false;
    return true;
  }
  
  
}
