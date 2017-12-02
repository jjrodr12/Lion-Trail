package edu.psu.liontrail.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import edu.psu.liontrail.enumeration.ApplicationStatus;
import edu.psu.liontrail.enumeration.DegreeLevel;
import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Admission;
import edu.psu.liontrail.model.Application;
import edu.psu.liontrail.model.Department;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.Name;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.model.Student;
import edu.psu.liontrail.store.ApplicationStore;

public class ApplicationServiceTest {
  
  private static final int APP_ID = 40;
  
  private static final int MAJOR_ID = 20;
  
  private static final int SEMESTER_ID = 15;
  
  @Mock
  ApplicationStore store;
  
  @Mock
  AdmissionService admissionService;
  
  //service to test
  ApplicationService service;
  
  @Before
  public void init() {
    service = new ApplicationService();
    
    store = Mockito.mock(ApplicationStore.class);
    service.applicationStore = store;
    
    admissionService = Mockito.mock(AdmissionService.class);
    service.admissionService = admissionService;
    
    Mockito.when(store.getApplicationById(APP_ID)).thenReturn(createDefaultApplication()); 
  }
  
  @Test
  public void testAcceptApplication() {
    Mockito.when(admissionService.getByMajorAndSemester(MAJOR_ID, SEMESTER_ID)).thenReturn(getDefaultAdmissions());
    boolean exceptionCaught = false;
    try {
      service.acceptApplication(APP_ID);
    } catch (Exception e) {
      e.printStackTrace();
      exceptionCaught = true;
    }
    
    Assert.assertTrue("Caught Exception when accepting application", !exceptionCaught);
  }
  
  @Test
  public void testRejectApplication() {
    Mockito.when(admissionService.getByMajorAndSemester(MAJOR_ID, SEMESTER_ID)).thenReturn(getDefaultAdmissions());
    boolean exceptionCaught = false;
    try {
      service.rejectApplication(APP_ID);
    } catch (Exception e) {
      e.printStackTrace();
      exceptionCaught = true;
    }
    
    Assert.assertTrue("Caught Exception when accepting application", !exceptionCaught);
  }
  
  @Test
  public void testFullCohort() {
    List<Admission> admissions = getDefaultAdmissions();
    Admission adm = admissions.get(0);
    adm.setCohortSize(5);
    
    List<Student> students = new ArrayList<>();
    students.add(new Student());
    students.add(new Student());
    students.add(new Student());
    students.add(new Student());
    students.add(new Student());
    adm.setStudents(students);
    admissions.add(adm);
    Mockito.when(admissionService.getByMajorAndSemester(MAJOR_ID, SEMESTER_ID)).thenReturn(admissions);
    
    try {
      service.acceptApplication(APP_ID);
      Assert.fail("Did not receive validation exception for full cohort");
    } catch (ValidationException e) {
      Assert.assertEquals(1, e.getMessages().size());
    }
  }
  
  private Application createDefaultApplication() {
    Application app = new Application();
    app.setEssay("Some boring essay");
    app.setGpa(3.4);
    app.setHighSchoolName("Some High School");
    app.setId(APP_ID);
    app.setMajor(createDefaultMajor());
    app.setSemester(createDefaultSemster());
    app.setStatus(ApplicationStatus.SUBMITTED);
    app.setStudent(createDefaultStudent());
    
    return app;
  }
  
  private Major createDefaultMajor() {
    Major major = new Major();
    major.setAbbreviation("TST");
    major.setId(MAJOR_ID);
    major.setLevel(DegreeLevel.BS);
    major.setName("Test Major");
    
    Department dept = new Department();
    dept.setId(Departments.BUSINESS);
    dept.setName("Test Department");
    major.setDepartment(dept);
    return major;
  }
  
  private Semester createDefaultSemster() {
    Semester semester = new Semester();
    semester.setId(SEMESTER_ID);
    semester.setSeason(SemesterSeason.FALL);
    semester.setYear(2017);
    
    return semester;
  }
  
  private Student createDefaultStudent() {
    Student student = new Student();
    student.setId(1);
    student.setUsername("jas1");
    
    Name name = new Name();
    name.setFirstName("John");
    name.setMiddleName("Alex");
    name.setLastName("Smith");
    student.setName(name);
    
    return student;
  }
  
  private List<Admission> getDefaultAdmissions() {
    List<Admission> admissions = new ArrayList<>();
    
    Admission adm = new Admission();
    adm.setCohortId(5);
    adm.setCohortSize(15);
    adm.setMajor(createDefaultMajor());
    adm.setSemeser(createDefaultSemster());
    adm.setStudents(new ArrayList<>());
    admissions.add(adm);
    
    return admissions;
  }

}
