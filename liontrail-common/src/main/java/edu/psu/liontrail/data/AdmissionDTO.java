package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.SemesterSeason;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class AdmissionDTO implements Serializable {

  private static final long serialVersionUID = -7698220979871194374L;

  @XmlElement
  private int cohortId;
  
  @XmlElement
  private int majorId;
  
  @XmlElement
  private String majorName;
  
  @XmlElement
  private String majorAbbreviation;
  
  @XmlElement
  private int semesterId;
  
  @XmlElement
  private SemesterSeason semesterSeason;
  
  @XmlElement
  private int semesterYear;
  
  @XmlElement
  private int cohortSize;
  
  @XmlElement
  private List<Integer> studentIds;

  public int getCohortId() {
    return cohortId;
  }

  public void setCohortId(int cohortId) {
    this.cohortId = cohortId;
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

  public int getSemesterYear() {
    return semesterYear;
  }

  public void setSemesterYear(int semesterYear) {
    this.semesterYear = semesterYear;
  }

  public int getCohortSize() {
    return cohortSize;
  }

  public void setCohortSize(int cohortSize) {
    this.cohortSize = cohortSize;
  }

  public List<Integer> getStudentIds() {
    return studentIds;
  }

  public void setStudentIds(List<Integer> studentIds) {
    this.studentIds = studentIds;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cohortId;
    result = prime * result + cohortSize;
    result = prime * result + ((majorAbbreviation == null) ? 0 : majorAbbreviation.hashCode());
    result = prime * result + majorId;
    result = prime * result + ((majorName == null) ? 0 : majorName.hashCode());
    result = prime * result + semesterId;
    result = prime * result + ((semesterSeason == null) ? 0 : semesterSeason.hashCode());
    result = prime * result + semesterYear;
    result = prime * result + ((studentIds == null) ? 0 : studentIds.hashCode());
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
    AdmissionDTO other = (AdmissionDTO) obj;
    if (cohortId != other.cohortId)
      return false;
    if (cohortSize != other.cohortSize)
      return false;
    if (majorAbbreviation == null) {
      if (other.majorAbbreviation != null)
        return false;
    } else if (!majorAbbreviation.equals(other.majorAbbreviation))
      return false;
    if (majorId != other.majorId)
      return false;
    if (majorName == null) {
      if (other.majorName != null)
        return false;
    } else if (!majorName.equals(other.majorName))
      return false;
    if (semesterId != other.semesterId)
      return false;
    if (semesterSeason != other.semesterSeason)
      return false;
    if (semesterYear != other.semesterYear)
      return false;
    if (studentIds == null) {
      if (other.studentIds != null)
        return false;
    } else if (!studentIds.equals(other.studentIds))
      return false;
    return true;
  }
}
