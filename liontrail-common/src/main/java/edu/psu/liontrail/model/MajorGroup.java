package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="major_group")
public class MajorGroup implements Serializable {
  
  private static final long serialVersionUID = 9074234260193140364L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "major_group_seq_gen")
  @SequenceGenerator(name = "major_group_seq_gen", sequenceName = "major_group_id_seq", allocationSize = 1)
  private int id;
  
  @ManyToOne
  @JoinColumn(name="major")
  private Major major;
  
  @Column(name="size")
  @NotNull
  @Min(value=0)
  private int size;
  
  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="major_group_course",
  joinColumns=@JoinColumn(name="group_id", referencedColumnName="id"),
  inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id"))
  private Set<Course> courses;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Major getMajor() {
    return major;
  }

  public void setMajor(Major major) {
    this.major = major;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((major == null) ? 0 : major.hashCode());
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
    MajorGroup other = (MajorGroup) obj;
    if (id != other.id)
      return false;
    if (major == null) {
      if (other.major != null)
        return false;
    } else if (!major.equals(other.major))
      return false;
    return true;
  }

}
