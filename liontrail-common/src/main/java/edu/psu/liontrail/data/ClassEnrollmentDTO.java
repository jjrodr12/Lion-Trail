package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.DegreeLevel;
import edu.psu.liontrail.enumeration.Grade;

@XmlRootElement(name="classenrollment")
@XmlAccessorType(XmlAccessType.NONE)
public class ClassEnrollmentDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1273048090813187043L;
  
  @XmlElement
  private int id;
  
  @XmlElement
  private Grade grade;
  
  @XmlElement
  private int class_id;
  
  @XmlElement
  private int student_id;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getclass_id() {
    return class_id;
  }

  public void setClass_id(int number) {
    this.class_id = number;
  }

  public int getstudent_id() {
    return student_id;
  }

  public void setstudent_id(int number) {
    this.student_id = number;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade2) {
    this.grade = grade2;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
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
    ClassEnrollmentDTO other = (ClassEnrollmentDTO) obj;
    if (id != other.id)
      return false;
    return true;
  }
}