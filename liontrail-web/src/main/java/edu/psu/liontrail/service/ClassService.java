package edu.psu.liontrail.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.swing.ViewportLayout;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.enumeration.ClassFrequency;
import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.exception.BuildingNotFoundException;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.ClassEnrollment;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Employee;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.model.Student;
import edu.psu.liontrail.model.User;
import edu.psu.liontrail.store.ClassStore;
import edu.psu.liontrail.util.DTOConveter;
import io.swagger.annotations.License;

public class ClassService {
  
  @Inject
  CourseService courseSerice;
  
  @Inject
  SemesterService semesterService;
  
  @Inject
  UserService userService;
  
  @Inject
  RoomService roomService;
  
  @Inject
  BuildingService buildingService;
  
  @Inject
  ClassStore classStore;
  
  @Inject
  StudentService studentService;
  
  public LiontrailClass getClass(int id) {
    return classStore.getClassById(id);
  }
  
  public ClassDTO getClassDTOById(int id) throws ClassNotFoundException, BuildingNotFoundException {
    LiontrailClass ltClass = classStore.getClassById(id);
    if (ltClass == null) {
      throw new ClassNotFoundException("No Class found with id: "+id);
    }
    Building building = buildingService.getBuildingByRoomId(ltClass.getRoom().getId());
    if (building == null) {
      throw new BuildingNotFoundException("No Building found with id: "+ltClass.getRoom().getId());
    }
    ClassDTO dto = DTOConveter.toClassDTO(ltClass, building);
    return dto;
  }
  
  private LiontrailClass fromDto(CreateClassDTO dto) throws ValidationException {
    ValidationException ex = new ValidationException();
    Course course = null;
    Semester semester = null;
    Employee emp = null;
    Room room = null;
    Building building = null;
    
    if (dto.getCourseId() == 0) {
      ex.addMessage("courseId is required");
    } else {
      course = courseSerice.getCourseById(dto.getCourseId());
      if (course == null) {
        ex.addMessage("No course found with id: "+dto.getCourseId());
      }
    }
    
    if (dto.getRoomId() == 0 && !dto.isOnline()) {
      ex.addMessage("roomId or online must be specified");
    } else {
      room = roomService.getRoomById(dto.getRoomId());
      if (room == null) {
        ex.addMessage("No room found with id: "+dto.getRoomId());
      } else {
        if (dto.getSize() > room.getCapacity()) {
          ex.addMessage("Class size exceeds room size");
        }
        building = buildingService.getBuildingByRoomId(dto.getRoomId());
        if (building == null) {
          ex.addMessage("No building associated with room: " + dto.getRoomId());
        }
      }
    }
    
    if (dto.getSemesterId() == 0) {
      ex.addMessage("semesterId is required");
    } else {
      semester = semesterService.getSemester(dto.getSemesterId());
      if (semester == null) {
        ex.addMessage("No semester found with id: "+dto.getSemesterId());
      }
    }
    
    if (dto.getInstructorId() == 0) {
      ex.addMessage("instructorId is required");
    } else {
      emp = userService.getEmployee(dto.getInstructorId()).orElse(null);
      if (emp == null) {
        ex.addMessage("No user found with id: "+dto.getInstructorId());
      }
      //TODO: verify that user has instructor role
    }
    
    if (dto.getDays() == null || dto.getDays().isEmpty()) {
      ex.addMessage("frequency is required and cannot be empty");
    }
    if (dto.getStartTime() == null) {
      ex.addMessage("startTime is required");
    }
    if (dto.getStopTime() == null) {
      ex.addMessage("stopTime is required");
    }
    if (dto.getStartTime() != null && dto.getStopTime() != null && !dto.getStartTime().isBefore(dto.getStopTime())) {
      ex.addMessage("startTime must be before stopTime");
    }
    
    if (!ex.getMessages().isEmpty() ) {
      throw ex;
    }
    
    LiontrailClass ltClass = new LiontrailClass();
    ltClass.setCourse(course);
    //ltClass.setFrequency(dto.getFrequency());
    ltClass.setDays(dto.getDays());
    ltClass.setInstructor(emp);
    ltClass.setOnline(dto.isOnline());
    ltClass.setRoom(room);
    ltClass.setSemester(semester);
    ltClass.setSize(dto.getSize());
    ltClass.setStartTime(dto.getStartTime());
    ltClass.setStopTime(dto.getStopTime());
    
    return ltClass;
  }

  public ClassDTO createClass(CreateClassDTO dto) throws ValidationException {
    
    LiontrailClass ltClass = fromDto(dto);
    Building building = buildingService.getBuildingByRoomId(dto.getRoomId());
    
    classStore.createClass(ltClass);
    ClassDTO responseDto = DTOConveter.toClassDTO(ltClass, building);
    
    return responseDto;
  }
  
public ClassDTO updateClass(int classId, CreateClassDTO dto) throws ValidationException {
    LiontrailClass existing = classStore.getClassById(classId);
    if (existing == null) {
      throw new ValidationException("No class found with id: "+classId);
    }
  
    LiontrailClass ltClass = fromDto(dto);
    ltClass.setId(classId);
    Building building = buildingService.getBuildingByRoomId(dto.getRoomId());
    
    classStore.updateClass(ltClass);
    ClassDTO responseDto = DTOConveter.toClassDTO(ltClass, building);
    
    return responseDto;
  }
  
  public void addStudentToClass(int classId, int studentId) throws ValidationException {
    ValidationException ex = new ValidationException();
    LiontrailClass ltClass = getClass(classId);
    if (ltClass == null) {
      ex.addMessage("No class found with id: "+classId);
    }
    
    Student student = studentService.getStudent(studentId);
    if (student == null) {
      ex.addMessage("No student found with id: "+studentId);
    }
    
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    
    if (ltClass.getEnrollments() == null) {
      ltClass.setEnrollments(new ArrayList<>());
    }
    if (ltClass.getEnrollments().size() >= ltClass.getSize()) {
      throw new ValidationException("Class is full");
    }
    if (ltClass.getEnrollments().stream().anyMatch(r -> studentId == r.getStudent().getId())) {
      throw new ValidationException("Student is already enrolled in class");
    }
    
    classStore.addEnrollment(ltClass, student);
  }
  
  public void removeStaudentFromClass(int classId, int studentId) throws ValidationException {
    ValidationException ex = new ValidationException();
    LiontrailClass ltClass = getClass(classId);
    if (ltClass == null) {
      ex.addMessage("No class found with id: "+classId);
    }
    
    Student student = studentService.getStudent(studentId);
    if (student == null) {
      ex.addMessage("No student found with id: "+studentId);
    }
    
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    if (ltClass.getEnrollments() == null) {
      ltClass.setEnrollments(new ArrayList<>());
    }
    
    ClassEnrollment enrollment = ltClass.getEnrollments().stream()
        .filter(r -> studentId == r.getStudent().getId()).findFirst()
        .orElseThrow(() -> new ValidationException("Student not enrolled in class"));
    if (!ltClass.getEnrollments().stream().anyMatch(r -> studentId == r.getStudent().getId())) {
      throw new ValidationException("Student is not enrolled in class");
    }
    
    classStore.deleteEnrollment(ltClass, enrollment.getId());
  }
  
  public List<ClassDTO> getClassesForStudent(int studentId) {
    List<LiontrailClass> classes = classStore.getClassByStudent(studentId);
    List<ClassDTO> dtos = classes.stream()
                            .map(c -> DTOConveter.toClassDTO(c, null))
                            .collect(Collectors.toList());
    return dtos;
  }
}
