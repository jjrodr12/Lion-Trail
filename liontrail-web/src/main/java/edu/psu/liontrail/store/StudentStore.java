package edu.psu.liontrail.store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.model.Student;

public class StudentStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Student getStudent(int studentId) {
    return em.find(Student.class, studentId);
  }
}
