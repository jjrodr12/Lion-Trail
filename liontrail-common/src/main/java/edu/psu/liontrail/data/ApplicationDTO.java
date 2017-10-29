package edu.psu.liontrail.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.SemesterSeason;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ApplicationDTO implements Serializable {

  private static final long serialVersionUID = -1908863392232694734L;

  @XmlElement(name="applicationId")
  private int applicationId;
  
  @XmlElement(name="studentId")
  private int studentId;
  
  @XmlElement(name="majorId")
  private int majorId;
  
  @XmlElement
  private String majorName;
  
  @XmlElement(name="majorAbbreviation")
  private String majorAbbreviation;
  
  @XmlElement(name="semesterId")
  private int semesterId;
  
  @XmlElement(name="season")
  private SemesterSeason semesterSeason;
  
  @XmlElement(name="year")
  private int year;
  
  @XmlElement(name="gpa")
  private double gpa;
  
  @XmlElement(name="highschool")
  private String highschool;
  
  @XmlElement(name="essay")
  private String essay;

  public int getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(int applicationId) {
    this.applicationId = applicationId;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getMajorId() {
    return majorId;
  }

  public void setMajorId(int majorId) {
    this.majorId = majorId;
  }

  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }

  public String getMajorAbbreviation() {
    return majorAbbreviation;
  }

  public void setMajorAbbreviation(String majorAbbreviation) {
    this.majorAbbreviation = majorAbbreviation;
  }

  public int getSemesterId() {
    return semesterId;
  }

  public void setSemesterId(int semesterId) {
    this.semesterId = semesterId;
  }

  public SemesterSeason getSemesterSeason() {
    return semesterSeason;
  }

  public void setSemesterSeason(SemesterSeason semesterSeason) {
    this.semesterSeason = semesterSeason;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public String getHighschool() {
    return highschool;
  }

  public void setHighschool(String highschool) {
    this.highschool = highschool;
  }

  public String getEssay() {
    return essay;
  }

  public void setEssay(String essay) {
    this.essay = essay;
  }
}
