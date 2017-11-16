package edu.psu.liontrail.service;

import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;

import edu.psu.liontrail.data.ApplicationDTO;
import edu.psu.liontrail.data.CreateApplicationDTO;
import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Admission;
import edu.psu.liontrail.model.Application;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.model.Student;
import edu.psu.liontrail.store.ApplicationStore;

public class ApplicationService {
  
  @Inject
  ApplicationStore applicationStore;
  
  @Inject
  MajorService majorService;
  
  @Inject
  SemesterService semesterService;
  
  @Inject
  StudentService studentService;
  
  @Inject
  AdmissionService admissionService;
  
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
  
  private Application convert(CreateApplicationDTO dto) throws ValidationException {
    Application application = new Application();
    ValidationException ex = new ValidationException();
    
    if (dto.getMajorId() != null) {
      Major major = majorService.getMajorById(dto.getMajorId());
      if (major == null) {
        ex.addMessage("No major found with id: "+dto.getMajorId());
      }
      application.setMajor(major);
    } else {
      ex.addMessage("Major Id not set");
    }
    
    if (dto.getSemesterId() != null) {
      Semester semester = semesterService.getSemester(dto.getSemesterId());
      if (semester == null) {
        ex.addMessage("No semester found with id: "+dto.getSemesterId());
      }
      application.setSemester(semester);
    } else {
      ex.addMessage("Semester Id not set");
    }
    
    if (dto.getEssay() != null && !dto.getEssay().trim().isEmpty()) {
      application.setEssay(dto.getEssay());
    } else {
      ex.addMessage("Essay cannot be null or blank");
    }
    
    if (dto.getGpa() != null) {
      application.setGpa(dto.getGpa());
    } else {
      ex.addMessage("GPA cannot be null");
    }
    
    if (dto.getHighschool() != null && !dto.getHighschool().isEmpty()) {
      application.setHighSchoolName(dto.getHighschool());
    } else {
      ex.addMessage("Highschool cannot be null or blank");
    }
    
    if (dto.getStudentId() != null) {
      Student student = studentService.getStudent(dto.getStudentId());
      if (student == null) {
        ex.addMessage("No student found with id: "+dto.getStudentId());
      }
      application.setStudent(student);
    } else {
      ex.addMessage("Student Id not set");
    }
    
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    return application;
  }
  
  public Application createApplication(CreateApplicationDTO dto) throws ValidationException {
    Application app = convert(dto);
    
    List<Application> existing = applicationStore.getApplicationForStudent(dto.getStudentId());
    if (existing != null && !existing.isEmpty()) {
      throw new ValidationException("Application already exists for student: "+dto.getStudentId());
    }
    
    app.setStatus(ApplicationStatus.SUBMITTED);
    Application application = applicationStore.createApplication(app);
    return application;
  }
  
  public Application updateApplication(int applicationId, CreateApplicationDTO dto) throws ValidationException {
    Application app = convert(dto);
    if (dto.getApplicationId() != null) {
      app.setId(applicationId);
    } else {
      throw new ValidationException("Application Id not set");
    }
    
    if (dto.getStatus() != null) {
      app.setStatus(dto.getStatus());
    } else {
      throw new ValidationException("Status not set");
    }
    Application application = applicationStore.updateApplication(app);
    return application;
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
    dto.setStatus(application.getStatus());
    
    return dto;
  }
  
  public void acceptApplication(int applicationId) throws ValidationException {
    Application application = applicationStore.getApplicationById(applicationId);
    if (application == null) {
      throw new ValidationException("No application found with id: " + applicationId);
    }
    if (ApplicationStatus.SUBMITTED != application.getStatus()) {
      throw new ValidationException("Application is already "+application.getStatus());
    }
    Student student = application.getStudent();
    Semester semester = application.getSemester();
    Major major = application.getMajor();
    
    List<Admission> admissions = admissionService.getByMajorAndSemester(major.getId(), semester.getId());
    if (admissions == null || admissions.isEmpty()) {
      throw new ValidationException("Admission Cohort not found");
    }
    Admission admission = admissions.get(0);
    admissionService.addStudent(admission.getCohortId(), student);
    application.setStatus(ApplicationStatus.ACCEPTED);
    applicationStore.updateApplication(application);
  }
  
  public void rejectApplication(int applicationId) throws ValidationException {
    Application application = applicationStore.getApplicationById(applicationId);
    if (application == null) {
      throw new ValidationException("No application found with id: " + applicationId);
    }
    if (ApplicationStatus.SUBMITTED != application.getStatus()) {
      throw new ValidationException("Application is already "+application.getStatus());
    }
    application.setStatus(ApplicationStatus.REJECTED);
    applicationStore.updateApplication(application);
  }
    

}
