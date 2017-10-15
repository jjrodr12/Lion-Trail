package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import edu.psu.liontrail.enumeration.DegreeLevel;

@Entity
@Table(name="major", uniqueConstraints = {
    @UniqueConstraint(columnNames={"name","degree_level"})
})
@NamedQueries({
  @NamedQuery(name=Major.BY_ABBREVIATION, query="SELECT m FROM Major m where m.abbreviation = :abbreviation"),
  @NamedQuery(name=Major.BY_DEPARTMENT, query="SELECT m FROM Major m where m.department.id = :department")
})
public class Major implements Serializable {
  
  private static final long serialVersionUID = -1693279106463770043L;
  
  public static final String BY_ABBREVIATION = "Major.findByAbbreivation";
  public static final String BY_DEPARTMENT = "Major.findByDepartment";

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "major_seq_gen")
  @SequenceGenerator(name = "major_seq_gen", sequenceName = "major_id_seq", allocationSize = 1)
  private int id;
  
  @Column(name="name", length=50)
  @NotNull
  private String name;
  
  @Column(name="abbreviation", length=10)
  @NotNull
  private String abbreviation;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="department_id")
  @NotNull
  @Enumerated(EnumType.STRING)
  private Department department;
  
  @Column(name="degree_level", length=5)
  @NotNull
  @Enumerated(EnumType.STRING)
  private DegreeLevel level;
  
  @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
  @Fetch(FetchMode.SELECT)
  @JoinTable(name="major_course",
  joinColumns=@JoinColumn(name="major_id", referencedColumnName="id"),
  inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id"))
  private List<Course> requiredCourses;
  
  @OneToMany(mappedBy="major", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
  @Fetch(FetchMode.SELECT)
  private List<MajorGroup> groups;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public DegreeLevel getLevel() {
    return level;
  }

  public void setLevel(DegreeLevel level) {
    this.level = level;
  }

  public List<Course> getRequiredCourses() {
    return requiredCourses;
  }

  public void setRequiredCourses(List<Course> requiredCourses) {
    this.requiredCourses = requiredCourses;
  }

  public List<MajorGroup> getGroups() {
    return groups;
  }

  public void setGroups(List<MajorGroup> groups) {
    this.groups = groups;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    Major other = (Major) obj;
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
