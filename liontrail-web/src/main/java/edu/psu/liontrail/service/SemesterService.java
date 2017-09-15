package edu.psu.liontrail.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.store.SemesterStore;
import edu.psu.liontrail.util.ValidationUtil;

@Stateless
public class SemesterService {
  
  @Inject
  SemesterStore store;
  
  
  
  public Semester getSemester(int id) {
    return store.getSemesterById(id);
  }
  
  public List<Semester> getAllSemesters() {
    return store.getAllSemesters();
  }
  
  public Semester getSemester(SemesterSeason season, Integer year) throws ValidationException {
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
    return store.getSemesterBySeasonAndYear(season, year);
  }
  
  public void addSemester(Semester semester) throws ValidationException {
    validateSemester(semester);
    
    if (semester.getId() != 0) {
      throw new ValidationException("Cannot specify semester id when creating new semester");
    }
    Semester existing = store.getSemesterBySeasonAndYear(semester.getSeason(), semester.getYear());
    if (existing != null) {
      throw new ValidationException("Semester already exists for Season: "+semester.getSeason() +
        " and Year: "+semester.getYear());
    }
  }
  
  public void updateSemester(Semester semester) throws ValidationException {
    validateSemester(semester);
    
    if (semester.getId() == 0) {
      throw new ValidationException("Semester id must be set for update");
    }
    Semester existing = store.getSemesterById(semester.getId());
    if (existing == null) {
      throw new ValidationException("Cannot update semester since it does not already exist");
    }
    Semester seasonYear = store.getSemesterBySeasonAndYear(semester.getSeason(), semester.getYear());
    if (existing.getId() != seasonYear.getId()) {
      throw new ValidationException("Semester already exists for Season: "+semester.getSeason() +
          " and Year: "+semester.getYear());
    }
  }
  
  private static void validateSemester(Semester semester) throws ValidationException {
    ValidationException exception = new ValidationException();
    
    if (semester == null) {
      throw new ValidationException("Semester cannot be null");
    }
    
    //Null Checks
    if (semester.getClassRegistrationDate() == null) {
      exception.addMessage("Class Registration Date cannot be null");
    }
    if (semester.getDropAddDeadlineDate() == null) {
      exception.addMessage("Drop Add Date cannot be null");
    }
    if (semester.getFirstClassDate() == null) {
      exception.addMessage("First Class Date cannot be null");
    }
    if (semester.getFirstExamDate() == null) {
      exception.addMessage("First Exam Date cannot be null");
    }
    if (semester.getLastClassDate() == null) {
      exception.addMessage("Last Class Date cannot be null");
    }
    if (semester.getLastExamDate() == null) {
      exception.addMessage("Last Exam Date cannot be null");
    }
    if (semester.getSeason() == null) {
      exception.addMessage("Season cannot be null");
    }
    if (semester.getYear() < Semester.FIRST_YEAR) {
      exception.addMessage("Year must be before "+Semester.FIRST_YEAR);
    }
    
    //Date Order Checks
    if (ValidationUtil.allNotNull(semester.getClassRegistrationDate(), semester.getFirstClassDate()) &&
        semester.getFirstClassDate().isBefore(semester.getClassRegistrationDate())) {
      exception.addMessage("Class Registration Date must be before First Class Date");
    }
    if (ValidationUtil.allNotNull(semester.getFirstClassDate(), semester.getDropAddDeadlineDate()) &&
        semester.getDropAddDeadlineDate().isBefore(semester.getDropAddDeadlineDate())) {
      exception.addMessage("First Class Date must be before Drop Add Date");
    }
    if (ValidationUtil.allNotNull(semester.getDropAddDeadlineDate(), semester.getLastClassDate()) && 
        semester.getLastClassDate().isBefore(semester.getDropAddDeadlineDate())) {
      exception.addMessage("Drop Add Date must be before Last Class Date");
    }
    if (ValidationUtil.allNotNull(semester.getLastClassDate(), semester.getFirstExamDate()) && 
        semester.getLastExamDate().isBefore(semester.getLastClassDate())) {
      exception.addMessage("Last Class Date must be before First Exam Date");
    }
    if (ValidationUtil.allNotNull(semester.getFirstExamDate(), semester.getLastClassDate()) && 
        semester.getLastExamDate().isBefore(semester.getFirstExamDate())) {
      exception.addMessage("First Exam Date must be before Last Exam Date");
    }
    
    if (exception.hasErrors()) {
      throw exception;
    }
  }

}
