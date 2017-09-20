package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.converters.GradeConverter;
import edu.psu.liontrail.enumeration.Grade;

@Entity
@Table(name="class_enrollment", uniqueConstraints= {
    @UniqueConstraint(columnNames= {"class_id","student_id"})
})
public class ClassEnrollment implements Serializable {

  private static final long serialVersionUID = 4501491151912021524L;
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "class_enrollment_seq_gen")
  @SequenceGenerator(name = "class_enrollment_seq_gen", sequenceName = "class_enrollment_id_seq", allocationSize = 1)
  private int id;

  //@Id
  //@Column(name="class_id")
  //private int classId;
  
  //@Id
  //@Column(name="student_id")
  //private int studentId;
  
  //@Column(name="class_id")
  @OneToOne
  @JoinColumn(name="class_id")
  @NotNull
  private LiontrailClass enrolledClass;

  //@Column(name="student_id")
  @OneToOne
  @JoinColumn(name="student_id")
  @NotNull
  private Student student;
  
  @Column(name="grade", length=5)
  @NotNull
  @Convert(converter=GradeConverter.class)
  private Grade grade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LiontrailClass getEnrolledClass() {
    return enrolledClass;
  }

  public void setEnrolledClass(LiontrailClass enrolledClass) {
    this.enrolledClass = enrolledClass;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((enrolledClass == null) ? 0 : enrolledClass.hashCode());
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
    ClassEnrollment other = (ClassEnrollment) obj;
    if (enrolledClass == null) {
      if (other.enrolledClass != null)
        return false;
    } else if (!enrolledClass.equals(other.enrolledClass))
      return false;
    if (student == null) {
      if (other.student != null)
        return false;
    } else if (!student.equals(other.student))
      return false;
    return true;
  }

  
  
  
}
