package edu.psu.liontrail.service;

import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.model.Application;
import edu.psu.liontrail.store.ApplicationStore;

public class ApplicationService {
  
  @Inject
  ApplicationStore applicationStore;
  
  public void createApplication(ApplicationDTO dto) {
    
  }
  
  public Application getApplication(int applicationId) {
    return applicationStore.getApplicationById(applicationId);
  }
  
  public List<Application> getApplicationsBySemester(int semesterId) {
    return applicationStore.getApplicationForSemester(semesterId);
  }
  
  public List<Application> getApplicationsySemesterWithStatus(int semesterId, ApplicationStatus status) {
    return applicationStore.getApplicationForSemesterWithStatus(semesterId, status);
  }
  
  public List<Application> getApplicationForStudent(int studentId) {
    return applicationStore.getApplicationForStudent(studentId);
  }
  
  public List<Application> getApplicationForStudent(String userId) {
    return applicationStore.getApplicationForStudent(userId);
  }
  
  public ApplicationDTO convert(Application application) {
    ApplicationDTO dto = new ApplicationDTO();
    
    dto.setApplicationId(application.getId());
    dto.setEssay(application.getEssay());
    dto.setGpa(application.getGpa());
    dto.setHighschool(application.getHighSchoolName());
    dto.setMajorId(application.getMajor().getId());
    dto.setMajorAbbreviation(application.getMajor().getAbbreviation());
    dto.setMajorName(application.getMajor().getName());
    dto.setSemesterId(application.getSemester().getId());
    dto.setSemesterSeason(application.getSemester().getSeason());
    dto.setYear(application.getSemester().getYear());
    dto.setStudentId(application.getStudent().getId());
    
    return dto;
  }
    

}
