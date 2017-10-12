package edu.psu.liontrail.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.data.CreateMajorGroupDTO;
import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.MajorGroup;
import edu.psu.liontrail.store.CourseStore;
import edu.psu.liontrail.store.MajorStore;

@Stateless
public class MajorService {

  @Inject
  MajorStore majorStore;
  
  @Inject
  CourseService courseService;
  
  public Major getMajorById(int id) {
    return majorStore.getMajorById(id);
  }
  
  public List<Major> getMajorByAbbreviation(String abbreviation) {
    return majorStore.getMajorByAbbreviation(abbreviation);
  }
  
  public List<Major> getMajorByDepartment(Departments department) {
    return majorStore.getMajorByDepartment(department);
  }
  
  public void addRequiredCourse(int majorId, int courseId) throws ValidationException {
    ValidationException ex = new ValidationException();
    Major major = majorStore.getMajorById(majorId);
    Course course = courseService.getCourseById(courseId);
    
    if (major == null) {
      ex.addMessage("No major found with id: "+majorId);
    }
    if (course == null) {
      ex.addMessage("No course found with id: "+courseId);
    }
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    if (major.getRequiredCourses() == null) {
      major.setRequiredCourses(new ArrayList<>());
    }
    if (major.getRequiredCourses().stream().anyMatch(c -> c.getId() == courseId)) {
      ex.addMessage("Course: "+courseId +" is already a requirement for Major: "+majorId);
    }
    if (major.getGroups() != null) {
      for(MajorGroup g : major.getGroups()) {
        if (g != null && g.getCourses() != null && g.getCourses().stream().anyMatch(c -> c.getId() == courseId)) {
          ex.addMessage("Course: "+courseId+" is part of MajorGroup: "+g.getId());
        }
      }
    }
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    
    course.setMajor(major);
    major.getRequiredCourses().add(course);
    majorStore.updateMajor(major);
  }
  
  public void removeRequiredCourse(int majorId, int courseId) throws ValidationException {
    ValidationException ex = new ValidationException();
    Major major = majorStore.getMajorById(majorId);
    Course course = courseService.getCourseById(courseId);
    
    if (major == null) {
      ex.addMessage("No major found with id: "+majorId);
    }
    if (course == null) {
      ex.addMessage("No course found with id: "+courseId);
    }
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    if (major.getRequiredCourses() == null) {
      major.setRequiredCourses(new ArrayList<>());
    }
    if (!major.getRequiredCourses().stream().anyMatch(c -> c.getId() == courseId)) {
      ex.addMessage("Course: "+courseId +" is already not a requirement for Major: "+majorId);
      throw ex;
    }
    major.getRequiredCourses().removeIf(c -> c.getId() == courseId);
    majorStore.updateMajor(major);
  }
  
  public MajorGroup createMajorGroup(int majorId, CreateMajorGroupDTO dto) throws ValidationException {
    ValidationException ex = new ValidationException();
    Major major = majorStore.getMajorById(majorId);
    if (major == null) {
      ex.addMessage("No major found with id: "+majorId);
      throw ex;
    }
    
    dto.setId(0);
    if (dto.getSize() < 1) {
      ex.addMessage("Group Size must be greater than one");
    }
    if (dto.getCourseIds() == null) {
      ex.addMessage("Course list cannot be null");
    } else if (dto.getCourseIds().size() < dto.getSize()) {
      ex.addMessage("Course list size must exceed group size");
    }
    if (!ex.getMessages().isEmpty()) {
      throw ex;
    }
    
    List<Course> courses = new ArrayList<>();
    for(int courseId : dto.getCourseIds()) {
      Course c = courseService.getCourseById(courseId);
      if (c != null) {
        courses.add(c);
      } else {
        ex.addMessage("No course found with id: "+courseId);
      }
    }
    
    MajorGroup group = new MajorGroup();
    group.setMajor(major);
    group.setSize(dto.getSize());
    group.setCourses(courses);
    
    if (major.getGroups() == null) {
      major.setGroups(new ArrayList<>());
    }
    major.getGroups().add(group);
    majorStore.updateMajor(major);
    
    return group;
  }
}
