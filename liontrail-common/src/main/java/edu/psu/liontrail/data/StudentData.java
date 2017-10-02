package edu.psu.liontrail.data;

import edu.psu.liontrail.model.Student;

public class StudentData {
  private Student student;
  private Double cumeGpa;
  
  public Student getStudent() {
    return student;
  }
  
  public Student setStudent(Student stu) {
    this.student = stu;
    return student;
  }
  
  public Double getCumeGpa() {
    return cumeGpa;
  }
  
  public Double setCumeGpa(double cumulativeGpa) {
    this.cumeGpa = cumulativeGpa;
    return cumeGpa;
  }
  
  
}
