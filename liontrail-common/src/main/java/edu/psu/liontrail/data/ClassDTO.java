package edu.psu.liontrail.data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.psu.liontrail.adapter.DayAdapter;
import edu.psu.liontrail.adapter.LocalTimeAdapter;
import edu.psu.liontrail.enumeration.ClassFrequency;
import edu.psu.liontrail.enumeration.Day;
import edu.psu.liontrail.enumeration.SemesterSeason;

public class ClassDTO implements Serializable {

  private static final long serialVersionUID = 3922457969375479203L;
  
  @XmlElement
  private int classId;
  
  @XmlElement
  private int enrollmentCount;
  
  @XmlElement
  private int size;
  
  @XmlElement
  private int courseId;
  @XmlElement
  private String courseName;
  @XmlElement
  private String courseAbbreviation;
  @XmlElement
  private int courseNumber;
  
  @XmlElement
  private SemesterSeason semesterSeason;
  @XmlElement
  private int semesterYear;
  
  @XmlElement
  private int instructorId;
  @XmlElement
  private String instructorFirstName;
  @XmlElement
  private String instructorLastName;
  
  /*@XmlElement
  private ClassFrequency classFrequency;*/
  
  @XmlElement
  @XmlJavaTypeAdapter(DayAdapter.class)
  private List<Day> days;
  
  @XmlElement
  @XmlJavaTypeAdapter(LocalTimeAdapter.class)
  private LocalTime startTime;
  
  @XmlElement
  @XmlJavaTypeAdapter(LocalTimeAdapter.class)
  private LocalTime stopTime;
  
  @XmlElement
  private int buildingId;
  @XmlElement
  private String buildingName;
  
  @XmlElement
  private int roomId;
  @XmlElement
  private int roomNumber;
  
  @XmlElement
  private boolean online;

  public int getClassId() {
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  
  public int getEnrollmentCount() {
    return enrollmentCount;
  }

  public void setEnrollmentCount(int enrollmentCount) {
    this.enrollmentCount = enrollmentCount;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseAbbreviation() {
    return courseAbbreviation;
  }

  public void setCourseAbbreviation(String courseAbbreviation) {
    this.courseAbbreviation = courseAbbreviation;
  }

  public int getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(int courseNumber) {
    this.courseNumber = courseNumber;
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

  public void setSemesterYear(int year) {
    this.semesterYear = year;
  }

  public int getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(int instructorId) {
    this.instructorId = instructorId;
  }

  public String getInstructorFirstName() {
    return instructorFirstName;
  }

  public void setInstructorFirstName(String instructorFirstName) {
    this.instructorFirstName = instructorFirstName;
  }

  public String getInstructorLastName() {
    return instructorLastName;
  }

  public void setInstructorLastName(String instructorLastName) {
    this.instructorLastName = instructorLastName;
  }

  /*public ClassFrequency getClassFrequency() {
    return classFrequency;
  }

  public void setClassFrequency(ClassFrequency classFrequency) {
    this.classFrequency = classFrequency;
  }*/
  
  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }

  public LocalTime getStartTime() {
    return startTime;
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

  public int getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(int buildingId) {
    this.buildingId = buildingId;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public boolean isOnline() {
    return online;
  }

  public void setOnline(boolean online) {
    this.online = online;
  }

}
