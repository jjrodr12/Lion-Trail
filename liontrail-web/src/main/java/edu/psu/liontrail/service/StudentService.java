package edu.psu.liontrail.service;

import javax.inject.Inject;

import edu.psu.liontrail.model.Student;
import edu.psu.liontrail.store.StudentStore;

public class StudentService {
  
  @Inject
  StudentStore studentStore;

  public Student getStudent(int studentId) {
    return studentStore.getStudent(studentId);
  }
}
