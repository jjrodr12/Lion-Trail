package edu.psu.liontrail.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class EnrollmentDTO implements Serializable {

  private static final long serialVersionUID = 7591884547347682403L;

  @XmlElement
  private int classId;
  
  @XmlElement
  private int courseId;
  @XmlElement
  private String courseName;
  @XmlElement
  private String courseAbbreviation;
  @XmlElement
  private int courseNumber;
  
  @XmlElement
  private List<Integer> studentIds;
}
