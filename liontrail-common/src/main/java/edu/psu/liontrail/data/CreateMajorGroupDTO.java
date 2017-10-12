package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class CreateMajorGroupDTO implements Serializable {
  
  private static final long serialVersionUID = 3562545358599595678L;

  @XmlElement
  private int id;
  
  @XmlElement
  private int size;
  
  @XmlElement
  private List<Integer> courseIds;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<Integer> getCourseIds() {
    return courseIds;
  }

  public void setCourseIds(List<Integer> courseIds) {
    this.courseIds = courseIds;
  }

}
