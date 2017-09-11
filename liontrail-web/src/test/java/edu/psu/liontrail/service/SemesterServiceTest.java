package edu.psu.liontrail.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.store.SemesterStore;


public class SemesterServiceTest {
  
  @Mock
  SemesterStore store;
  
  //Service to Test
  SemesterService service;
  
  @Before
  public void setup() throws Exception {
    service = new SemesterService();
    
    store = Mockito.mock(SemesterStore.class);
    service.store = store;
    
    Mockito.doNothing().when(store).createSemester(Mockito.any(Semester.class));
    Mockito.doNothing().when(store).updateSemester(Mockito.any(Semester.class));
    
  }
  
  @Test
  public void testAddSemesterValidation() {
    Semester semester = createDefaultSemester();
    semester.setId(5);
    boolean exceptionCaught = false;
    
    //Check that id cannot be null
    try {
      service.addSemester(semester);
      exceptionCaught = false;
    } catch (ValidationException e) {
      exceptionCaught = true;
      Assert.assertEquals(1, e.getMessages().size());
      Assert.assertEquals("Cannot specify semester id when creating new semester", e.getMessages().get(0));
    }
    Assert.assertTrue(exceptionCaught);
    
    //Check that semester already exists throws an error
    semester.setId(0);
    Mockito.when(store.getSemesterBySeasonAndYear(Mockito.any(SemesterSeason.class), Mockito.anyInt()))
      .thenReturn(createDefaultSemester());
    try {
      service.addSemester(semester);
      exceptionCaught = false;
    } catch (ValidationException e) {
      exceptionCaught = true;
      Assert.assertEquals(1, e.getMessages().size());
      Assert.assertEquals("Semester already exists for Season: SPRING and Year: 2017", e.getMessages().get(0));
    }
    Assert.assertTrue(exceptionCaught);
    
    //Test that no errors 
    Mockito.when(store.getSemesterBySeasonAndYear(Mockito.any(SemesterSeason.class), Mockito.anyInt()))
      .thenReturn(null);
    try {
      service.addSemester(semester);
    } catch (ValidationException e) {
      Assert.fail("Exception caught when not expected: "+e.getMessage());
    }
  }
  
  @Test
  public void testUpdateSemester() {
    Semester semester = createDefaultSemester();
    boolean exceptionCaught = false;
    int semesterId = semester.getId();
    
    //Verify update with invalid id throws an error
    semester.setId(0);
    try {
      service.updateSemester(semester);
      exceptionCaught = false;
    } catch (ValidationException e) {
      exceptionCaught = true;
      Assert.assertEquals(1, e.getMessages().size());
      Assert.assertEquals("Semester id must be set for update", e.getMessages().get(0));
    }
    Assert.assertTrue(exceptionCaught);
    
    //Verify that updating semester that does not exist throws exception
    Mockito.when(store.getSemesterById(semesterId)).thenReturn(null);
    semester.setId(semesterId);
    try {
      service.updateSemester(semester);
      exceptionCaught = false;
    } catch(ValidationException e) {
      exceptionCaught = true;
      Assert.assertEquals(1, e.getMessages().size());
      Assert.assertEquals("Cannot update semester since it does not already exist", e.getMessages().get(0));
    }
    Assert.assertTrue(exceptionCaught);
    
    //Verify that updating semester with existing season/year throws Exception
    Mockito.when(store.getSemesterById(semesterId))
      .thenReturn(createDefaultSemester());
    Semester otherSemester = createDefaultSemester();
    otherSemester.setId(semesterId+1);
    Mockito.when(store.getSemesterBySeasonAndYear(semester.getSeason(), semester.getYear()))
      .thenReturn(otherSemester);
    try {
      service.updateSemester(semester);
      exceptionCaught = false;
    } catch (ValidationException e) {
      exceptionCaught = true;
      Assert.assertEquals(1, e.getMessages().size());
      Assert.assertEquals("Semester already exists for Season: SPRING and Year: 2017", e.getMessages().get(0));
    }
    Assert.assertTrue(exceptionCaught);
  }
  
  private static Semester createDefaultSemester() {
    Semester semester = new Semester();
    semester.setId(1);
    semester.setClassRegistrationDate(LocalDate.of(2016, 10, 20));
    semester.setFirstClassDate(LocalDate.of(2017, 1, 9));
    semester.setDropAddDeadlineDate(LocalDate.of(2017, 1, 20));
    semester.setLastClassDate(LocalDate.of(2017, 5, 5));
    semester.setFirstExamDate(LocalDate.of(2017, 5, 8));
    semester.setLastExamDate(LocalDate.of(2017, 5, 12));
    semester.setSeason(SemesterSeason.SPRING);
    semester.setYear(2017);
    
    return semester;
  }

}
