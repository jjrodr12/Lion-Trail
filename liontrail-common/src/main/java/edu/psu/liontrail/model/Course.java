package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
  
  //@ManyToOne()
  //private Course target;
  
  //@OneToMany(mappedBy="parent")
  //private List<Course> prerequisites;
}
