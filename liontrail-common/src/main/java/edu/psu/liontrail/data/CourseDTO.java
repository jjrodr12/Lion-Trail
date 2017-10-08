package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.DegreeLevel;

@XmlRootElement(name="course")
@XmlAccessorType(XmlAccessType.NONE)
public class CourseDTO implements Serializable {

  private static final long serialVersionUID = -7942148193681137991L;

  @XmlElement
  private int id;
  
  @XmlElement
  private int number;
  
  @XmlElement
  private String name;
  
  @XmlElement
  private String description;
  
  @XmlElement
  private int credits;
  
  @XmlElement
  private int majorId;
  
  @XmlElement
  private String majorAbr;
  
  @XmlElement
  private String majorName;
  
  @XmlElement
  private DegreeLevel majorLevel;
  
  @XmlElement
  private List<CourseDTO> prerequisites; 

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public int getMajorId() {
    return majorId;
  }

  public void setMajorId(int majorId) {
    this.majorId = majorId;
  }

  public String getMajorAbr() {
    return majorAbr;
  }

  public void setMajorAbr(String majorAbr) {
    this.majorAbr = majorAbr;
  }

  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }

  public DegreeLevel getMajorLevel() {
    return majorLevel;
  }

  public void setMajorLevel(DegreeLevel majorLevel) {
    this.majorLevel = majorLevel;
  }

  public List<CourseDTO> getPrerequisites() {
    return prerequisites;
  }

  public void setPrerequisites(List<CourseDTO> prerequisites) {
    this.prerequisites = prerequisites;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + number;
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
    CourseDTO other = (CourseDTO) obj;
    if (number != other.number)
      return false;
    return true;
  }
  
  

}
