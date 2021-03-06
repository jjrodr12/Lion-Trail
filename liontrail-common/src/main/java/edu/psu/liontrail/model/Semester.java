package edu.psu.liontrail.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.psu.liontrail.adapter.LocalDateAdapter;
import edu.psu.liontrail.enumeration.SemesterSeason;

@Entity
@Table(name = "semester", uniqueConstraints = {
    @UniqueConstraint(columnNames={"season","year"})
})
@NamedQueries({
  @NamedQuery(name=Semester.ALL, query="SELECT s FROM Semester S"),
  @NamedQuery(name=Semester.BY_YEAR, query="SELECT s FROM Semester S where s.year = :year"),
  @NamedQuery(name=Semester.BY_SEASON_AND_YEAR, query="SELECT s FROM Semester S where s.season = :season AND s.year = :year")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Semester implements Serializable {

  private static final long serialVersionUID = -8635779935193646929L;
  
  public static final String ALL = "Semester.findAll";
  public static final String BY_YEAR = "Semester.findByYear";
  public static final String BY_SEASON_AND_YEAR = "Semester.findBySeasonAndYear";
  
  public static final int FIRST_YEAR= 1855;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "semester_seq_gen")
  @SequenceGenerator(name = "semester_seq_gen", sequenceName = "semester_id_seq", allocationSize = 1)
  @XmlElement
  private int id;

  @Column(name = "season")
  @Enumerated(EnumType.STRING)
  @NotNull
  @XmlElement
  private SemesterSeason season;

  @Column(name = "year")
  @NotNull
  @XmlElement
  private int year;
  
  @Column(name="admission_start")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate admissionStart;
  
  @Column(name="admission_stop")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate admissionStop;

  @Column(name = "first_class_date")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate firstClassDate;

  @Column(name = "last_class_date")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate lastClassDate;
  
  @Column(name="first_exam_date")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate firstExamDate;
  
  @Column(name="last_exam_date")
  @NotNull
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate lastExamDate;

  @Column(name = "class_registration_date")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate classRegistrationDate;

  @Column(name = "drop_add_deadline_date")
  @NotNull
  @XmlElement
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate dropAddDeadlineDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SemesterSeason getSeason() {
    return season;
  }

  public void setSeason(SemesterSeason season) {
    this.season = season;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public LocalDate getFirstClassDate() {
    return firstClassDate;
  }

  public void setFirstClassDate(LocalDate firstClassDate) {
    this.firstClassDate = firstClassDate;
  }

  public LocalDate getLastClassDate() {
    return lastClassDate;
  }

  public void setLastClassDate(LocalDate lastClassDate) {
    this.lastClassDate = lastClassDate;
  }

  public LocalDate getFirstExamDate() {
    return firstExamDate;
  }

  public void setFirstExamDate(LocalDate firstExamDate) {
    this.firstExamDate = firstExamDate;
  }

  public LocalDate getLastExamDate() {
    return lastExamDate;
  }

  public void setLastExamDate(LocalDate lastExamDate) {
    this.lastExamDate = lastExamDate;
  }

  public LocalDate getClassRegistrationDate() {
    return classRegistrationDate;
  }

  public void setClassRegistrationDate(LocalDate classRegistrationDate) {
    this.classRegistrationDate = classRegistrationDate;
  }

  public LocalDate getDropAddDeadlineDate() {
    return dropAddDeadlineDate;
  }

  public void setDropAddDeadlineDate(LocalDate dropAddDeadlineDate) {
    this.dropAddDeadlineDate = dropAddDeadlineDate;
  }

  public LocalDate getAdmissionStart() {
    return admissionStart;
  }

  public void setAdmissionStart(LocalDate admissionStart) {
    this.admissionStart = admissionStart;
  }

  public LocalDate getAdmissionStop() {
    return admissionStop;
  }

  public void setAdmissionStop(LocalDate admissionStop) {
    this.admissionStop = admissionStop;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((season == null) ? 0 : season.hashCode());
    result = prime * result + year;
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
    Semester other = (Semester) obj;
    if (season != other.season)
      return false;
    if (year != other.year)
      return false;
    return true;
  }

}
