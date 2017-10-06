package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RequiredCourseDTO implements Serializable {

  private static final long serialVersionUID = 2930375437091939214L;

  @XmlElement
  private List<CourseDTO> requiredClasses;
  
  @XmlElement
  private List<RequiredCourseGroupDTO> groups;

  public List<CourseDTO> getRequiredClasses() {
    return requiredClasses;
  }

  public void setRequiredClasses(List<CourseDTO> requiredClasses) {
    this.requiredClasses = requiredClasses;
  }

  public List<RequiredCourseGroupDTO> getGroups() {
    return groups;
  }

  public void setGroup(List<RequiredCourseGroupDTO> groups) {
    this.groups = groups;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((groups == null) ? 0 : groups.hashCode());
    result = prime * result + ((requiredClasses == null) ? 0 : requiredClasses.hashCode());
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
    RequiredCourseDTO other = (RequiredCourseDTO) obj;
    if (groups == null) {
      if (other.groups != null)
        return false;
    } else if (!groups.equals(other.groups))
      return false;
    if (requiredClasses == null) {
      if (other.requiredClasses != null)
        return false;
    } else if (!requiredClasses.equals(other.requiredClasses))
      return false;
    return true;
  }
  
  
}
