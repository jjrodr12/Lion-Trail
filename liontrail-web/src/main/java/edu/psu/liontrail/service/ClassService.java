package edu.psu.liontrail.service;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.swing.ViewportLayout;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.CreateClassDTO;
import edu.psu.liontrail.enumeration.ClassFrequency;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Employee;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.model.User;
import edu.psu.liontrail.store.ClassStore;
import io.swagger.annotations.License;

public class ScheduleService {
  
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

  public ClassDTO createClass(CreateClassDTO dto) throws ValidationException {
    
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
    
    if (dto.getFrequency() == null) {
      ex.addMessage("frequency is required");
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
    ltClass.setFrequency(dto.getFrequency());
    ltClass.setInstructor(emp);
    ltClass.setOnline(dto.isOnline());
    ltClass.setRoom(room);
    ltClass.setSemester(semester);
    ltClass.setSize(dto.getSize());
    ltClass.setStartTime(dto.getStartTime());
    ltClass.setStopTime(dto.getStopTime());
    
    
    
    classStore.createClass(ltClass);
    
    return null;
  }
}
