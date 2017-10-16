package edu.psu.liontrail.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.store.GradeStore;
import edu.psu.liontrail.util.ValidationUtil;

@Stateless
public class GradeService {
  
  @Inject
  GradeStore store;
  
  
  
  public Grade getGrade(int id) {
    return store.getGradeById(id);
  }
  
  public List<Grade> getAllGrades() {
    return store.getAllGrades();
  }
  
  public List<Grade> getGradesBySemester(SemesterSeason season, Integer year) throws ValidationException {
    ValidationException exception = new ValidationException();
    if (season == null) {
      exception.addMessage("season cannot be null");
    }
    if (year == null) {
      exception.addMessage("year cannot be null");
    }
    if (exception.hasErrors()) {
      throw exception;
    }
    return store.getGradeBySemester(season, year);
  }
  
  public void addGrade(Grade grade) throws ValidationException {
    validateGrade(grade);
    
    if (grade.getId() != 0) {
      throw new ValidationException("Cannot specify semester id when creating new semester");
    }
    Grade existing = store.getGradeBySemester(grade.getSeason(), grade.getYear());
    if (existing != null) {
      throw new ValidationException("Grade already exists for Semester: " + grade.getSeason() +
        " and Year: "+ grade.getYear());
    }
  }

  private void validateGrade(Grade grade) {
    // TODO Auto-generated method stub
    
  }
  
   

}
