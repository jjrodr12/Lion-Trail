package edu.psu.liontrail.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.DegreeLevel;
import edu.psu.liontrail.enumeration.Departments;

@XmlRootElement(name="major")
@XmlAccessorType(XmlAccessType.NONE)
public class BaseMajorDTO implements Serializable {

  private static final long serialVersionUID = 4212027861648974624L;

  @XmlElement
  protected int id;
  
  @XmlElement
  protected String abbreviation;
  
  @XmlElement
  protected String name;
  
  @XmlElement
  protected DegreeLevel level;
  
  @XmlElement
  protected Departments departmentId;
  
  @XmlElement
  protected String departmentName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DegreeLevel getLevel() {
    return level;
  }

  public void setLevel(DegreeLevel level) {
    this.level = level;
  }

  public Departments getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Departments departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
    result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
    result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
    result = prime * result + id;
    result = prime * result + ((level == null) ? 0 : level.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    BaseMajorDTO other = (BaseMajorDTO) obj;
    if (abbreviation == null) {
      if (other.abbreviation != null)
        return false;
    } else if (!abbreviation.equals(other.abbreviation))
      return false;
    if (departmentId != other.departmentId)
      return false;
    if (departmentName == null) {
      if (other.departmentName != null)
        return false;
    } else if (!departmentName.equals(other.departmentName))
      return false;
    if (id != other.id)
      return false;
    if (level != other.level)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
