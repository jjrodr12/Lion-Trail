package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.psu.liontrail.enumeration.Departments;

@Entity
@Table(name="course", uniqueConstraints = {
    @UniqueConstraint(columnNames={"department","number"})
})
public class Course implements Serializable {

  private static final long serialVersionUID = -6327916335774347403L;
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "course_seq_gen")
  @SequenceGenerator(name = "course_seq_gen", sequenceName = "course_id_seq", allocationSize = 1)
  private int id;
  
  @Column(name="department", length=15)
  @NotNull
  @Enumerated(EnumType.STRING)
  private Departments department;
  
  @Column(name="number")
  @NotNull
  private int number;
  
  @Column(name="name")
  @Size(max=60)
  @NotNull
  private String name;
  
  @Column(name="description")
  @Size(max=255)
  @NotNull
  private String description;
  
  @Column(name="credits")
  @NotNull
  @Min(value=1)
  private int credits;
  
  @ManyToMany
  @JoinTable(name="course_prerequisites",
      joinColumns = { @JoinColumn(name = "parent_course",referencedColumnName="id" ) },
      inverseJoinColumns = { @JoinColumn(name = "required_course", referencedColumnName="id")} )
  private Set<Course> prerequisites;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Departments getDepartment() {
    return department;
  }

  public void setDepartment(Departments department) {
    this.department = department;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public Set<Course> getPrerequisites() {
    return prerequisites;
  }

  public void setPrerequisites(Set<Course> prerequisites) {
    this.prerequisites = prerequisites;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((department == null) ? 0 : department.hashCode());
    result = prime * result + number;
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
    Course other = (Course) obj;
    if (department != other.department)
      return false;
    if (number != other.number)
      return false;
    return true;
  }
}
