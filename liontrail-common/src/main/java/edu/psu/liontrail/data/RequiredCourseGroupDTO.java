package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RequiredCourseGroupDTO implements Serializable {

  @XmlElement
  private int numberOfClasses;
  
  @XmlElement
  private List<CourseDTO> courses;

  public int getNumberOfClasses() {
    return numberOfClasses;
  }

  public void setNumberOfClasses(int numberOfClasses) {
    this.numberOfClasses = numberOfClasses;
  }

  public List<CourseDTO> getCourses() {
    return courses;
  }

  public void setCourses(List<CourseDTO> courses) {
    this.courses = courses;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((courses == null) ? 0 : courses.hashCode());
    result = prime * result + numberOfClasses;
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
    RequiredCourseGroupDTO other = (RequiredCourseGroupDTO) obj;
    if (courses == null) {
      if (other.courses != null)
        return false;
    } else if (!courses.equals(other.courses))
      return false;
    if (numberOfClasses != other.numberOfClasses)
      return false;
    return true;
  }
}
