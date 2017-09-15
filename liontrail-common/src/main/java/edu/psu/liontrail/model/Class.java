package edu.psu.liontrail.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.ClassFrequency;

@Entity
@Table(name="class")
public class Class implements Serializable {
  
  private static final long serialVersionUID = 3642657966915293123L;
  
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "class_seq_gen")
  @SequenceGenerator(name = "class_seq_gen", sequenceName = "class_id_seq", allocationSize = 1)
  private int id;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="semester_id")
  @NotNull
  private Semester semester;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="course_id")
  @NotNull
  private Course course;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="instructor_id")
  @NotNull
  private Instructor instructor;
  
  @Column(name="frequency", length=50)
  @Enumerated(EnumType.STRING)
  @NotNull
  private ClassFrequency frequency;
  
  @Column(name="start_time")
  @NotNull
  private LocalTime startTime;
  
  @Column(name="stop_time")
  @NotNull
  private LocalTime stopTime;
  
  @OneToOne
  @JoinColumn(name="room")
  @NotNull
  private Room room;
  
  @Column(name="online")
  @NotNull
  private boolean online;
  
  @Column(name="size")
  @NotNull
  private int size;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Semester getSemester() {
    return semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public ClassFrequency getFrequency() {
    return frequency;
  }

  public void setFrequency(ClassFrequency frequency) {
    this.frequency = frequency;
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

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
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
    result = prime * result + ((course == null) ? 0 : course.hashCode());
    result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
    result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
    result = prime * result + (online ? 1231 : 1237);
    result = prime * result + ((room == null) ? 0 : room.hashCode());
    result = prime * result + ((semester == null) ? 0 : semester.hashCode());
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
    Class other = (Class) obj;
    if (course == null) {
      if (other.course != null)
        return false;
    } else if (!course.equals(other.course))
      return false;
    if (frequency != other.frequency)
      return false;
    if (instructor == null) {
      if (other.instructor != null)
        return false;
    } else if (!instructor.equals(other.instructor))
      return false;
    if (online != other.online)
      return false;
    if (room == null) {
      if (other.room != null)
        return false;
    } else if (!room.equals(other.room))
      return false;
    if (semester == null) {
      if (other.semester != null)
        return false;
    } else if (!semester.equals(other.semester))
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
