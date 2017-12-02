package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.DegreeLevel;
import edu.psu.liontrail.enumeration.Grade;

@XmlRootElement(name="grade")
@XmlAccessorType(XmlAccessType.NONE)
public class GradeDTO implements Serializable {
  
  @XmlElement
  private double gpa;
  
  @XmlElement
  private List<ClassEnrollmentDTO> classes;

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public List<ClassEnrollmentDTO> getClasses() {
    return classes;
  }

  public void setClasses(List<ClassEnrollmentDTO> classes) {
    this.classes = classes;
  }
  
  
}