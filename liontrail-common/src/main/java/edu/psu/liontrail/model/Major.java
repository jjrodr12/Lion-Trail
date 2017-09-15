package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.DegreeLevel;

@Entity
@Table(name="major", uniqueConstraints = {
    @UniqueConstraint(columnNames={"department_id","name"})
})
public class Major implements Serializable {
  
  private static final long serialVersionUID = -1693279106463770043L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "major_seq_gen")
  @SequenceGenerator(name = "major_seq_gen", sequenceName = "major_id_seq", allocationSize = 1)
  private int id;
  
  @Column(name="name", length=50)
  @NotNull
  private String name;
  
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="department_id")
  @NotNull
  private Department department;
  
  @Column(name="degree_level", length=5)
  @NotNull
  @Enumerated(EnumType.STRING)
  private DegreeLevel level;
  
  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="major_course",
  joinColumns=@JoinColumn(name="major_id", referencedColumnName="id"),
  inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id"))
  private List<Course> requiredCourses;
  
  @OneToMany(mappedBy="major")
  private Set<MajorGroup> group;

}
