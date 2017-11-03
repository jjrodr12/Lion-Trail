package edu.psu.liontrail.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.ApplicationStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class CreateApplicationDTO implements Serializable {

  private static final long serialVersionUID = -343850018974279000L;

  @XmlElement
  private Integer applicationId;
  
  @XmlElement
  @NotNull
  private Integer majorId;
  
  @XmlElement
  @NotNull
  private Integer semesterId;
  
  @XmlElement
  @NotNull
  private ApplicationStatus status;
  
  @XmlElement
  @NotNull
  private Integer studentId;
  
  @XmlElement
  @NotNull
  private Double gpa;
  
  @XmlElement
  @NotNull
  private String essay;
  
  @XmlElement
  @NotNull
  private String highschool;

  public Integer getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Integer applicationId) {
    this.applicationId = applicationId;
  }

  public Integer getMajorId() {
    return majorId;
  }

  public void setMajorId(Integer majorId) {
    this.majorId = majorId;
  }

  public Integer getSemesterId() {
    return semesterId;
  }

  public void setSemesterId(Integer semesterId) {
    this.semesterId = semesterId;
  }

  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Double getGpa() {
    return gpa;
  }

  public void setGpa(Double gpa) {
    this.gpa = gpa;
  }

  public String getEssay() {
    return essay;
  }

  public void setEssay(String essay) {
    this.essay = essay;
  }

  public String getHighschool() {
    return highschool;
  }

  public void setHighschool(String highschool) {
    this.highschool = highschool;
  }

}
