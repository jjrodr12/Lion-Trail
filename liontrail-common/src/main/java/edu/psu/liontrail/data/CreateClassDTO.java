package edu.psu.liontrail.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.psu.liontrail.adapter.DayAdapter;
import edu.psu.liontrail.adapter.LocalTimeAdapter;
import edu.psu.liontrail.enumeration.ClassFrequency;
import edu.psu.liontrail.enumeration.Day;
import io.swagger.annotations.ApiModelProperty;

public class CreateClassDTO implements Serializable {

  private static final long serialVersionUID = 7716593715137205957L;

  @XmlElement
  private int courseId;
  
  @XmlElement
  private int semesterId;
  
  @XmlElement
  private int instructorId;
  
  @XmlElement
  private int roomId;
  
  @XmlElement
  @XmlJavaTypeAdapter(DayAdapter.class)
  //private ClassFrequency frequency;
  private List<Day> days;
  
  @XmlElement
  @XmlJavaTypeAdapter(LocalTimeAdapter.class)
  @ApiModelProperty(dataType="string", example="02:30")
  private LocalTime startTime;
  
  @XmlElement
  @XmlJavaTypeAdapter(LocalTimeAdapter.class)
  @ApiModelProperty(dataType="string", example="03:20")
  private LocalTime stopTime;
  
  @XmlElement
  private int size;
  
  @XmlElement
  private boolean online;

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getSemesterId() {
    return semesterId;
  }

  public void setSemesterId(int semesterId) {
    this.semesterId = semesterId;
  }

  public int getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(int instructorId) {
    this.instructorId = instructorId;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  /*public ClassFrequency getFrequency() {
    return frequency;
  }

  public void setFrequency(ClassFrequency frequency) {
    this.frequency = frequency;
  }*/

  
  
  public LocalTime getStartTime() {
    return startTime;
  }

  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getStopTime() {
    return stopTime;
  }

  public void setStopTime(LocalTime stopTime) {
    this.stopTime = stopTime;
  }

  public boolean isOnline() {
    return online;
  }

  public void setOnline(boolean online) {
    this.online = online;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + courseId;
    result = prime * result + ((days == null) ? 0 : days.hashCode());
    result = prime * result + instructorId;
    result = prime * result + (online ? 1231 : 1237);
    result = prime * result + roomId;
    result = prime * result + semesterId;
    result = prime * result + size;
    result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
    result = prime * result + ((stopTime == null) ? 0 : stopTime.hashCode());
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
    CreateClassDTO other = (CreateClassDTO) obj;
    if (courseId != other.courseId)
      return false;
    if (days != other.days)
      return false;
    if (instructorId != other.instructorId)
      return false;
    if (online != other.online)
      return false;
    if (roomId != other.roomId)
      return false;
    if (semesterId != other.semesterId)
      return false;
    if (size != other.size)
      return false;
    if (startTime == null) {
      if (other.startTime != null)
        return false;
    } else if (!startTime.equals(other.startTime))
      return false;
    if (stopTime == null) {
      if (other.stopTime != null)
        return false;
    } else if (!stopTime.equals(other.stopTime))
      return false;
    return true;
  }

}
