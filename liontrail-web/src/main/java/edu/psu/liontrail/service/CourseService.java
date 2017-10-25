package edu.psu.liontrail.service;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.exception.CourseNotFoundException;
import edu.psu.liontrail.exception.ValidationException;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.store.CourseStore;

public class CourseService {

  @Inject
  CourseStore courseStore;
  
  @Inject
  MajorService majorService;
  
  public Course getCourseById(int id) {
    return courseStore.getCourseById(id);
  }
  
  public List<Course> getAllCourses() {
    return courseStore.getAllCourses();
  }
  
  public List<Course> getCourseByMajorId(int id) {
    return courseStore.getCourseByMajorId(id);
  }
  
  public List<Course> getCourseByMajorAbbreviation(String abbreviation) {
    return courseStore.getCourseByMajorAbbreviation(abbreviation);
  }
  
  public Course createCourse(CourseDTO dto) {
    Course course = new Course();
    
    Major major = majorService.getMajorById(dto.getMajorId());
    
    course.setCredits(dto.getCredits());
    course.setDescription(dto.getDescription());
    course.setMajor(major);
    course.setName(dto.getName());
    course.setNumber(dto.getNumber());
    
    courseStore.createCourse(course);
    
    return course;
  }
  
  public void addPrerequisite(int courseId, int preReqId) throws CourseNotFoundException, ValidationException {
    Course course = courseStore.getCourseById(courseId);
    if (course == null) {
      throw new CourseNotFoundException("No course found with id: "+courseId);
    }
    
    Course preReq = courseStore.getCourseById(preReqId);
    if (preReq == null) {
      throw new CourseNotFoundException("No course found with id: "+preReqId);
    }
    
    if (course.getPrerequisites() == null) {
      course.setPrerequisites(new HashSet<>());
    }
    if (preReq.getPrerequisites() != null && preReq.getPrerequisites().stream().anyMatch(c -> c.getId() == courseId)) {
      throw new ValidationException("Unallowed circular dependency. "+courseId + " is a prerequisite of " + preReqId);
    }
    
    if (!course.getPrerequisites().stream().anyMatch(c -> c.getId() == preReqId)) {
      course.getPrerequisites().add(preReq);
      courseStore.updateCourse(course);
    } else {
      throw new ValidationException(preReqId + " is already a prerequisite of course "+courseId);
    }
  }
  
  public void removePrerequisite(int courseId, int preReqId) throws CourseNotFoundException, ValidationException {
    Course course = courseStore.getCourseById(courseId);
    if (course == null) {
      throw new CourseNotFoundException("No course found with id: "+courseId);
    }
    
    Course preReq = courseStore.getCourseById(preReqId);
    if (preReq == null) {
      throw new CourseNotFoundException("No course found with id: "+preReqId);
    }
    
    if (course.getPrerequisites() == null) {
      course.setPrerequisites(new HashSet<>());
    }
    
    if (course.getPrerequisites().stream().anyMatch(c -> c.getId() == preReqId)) {
      course.getPrerequisites().removeIf(c -> c.getId() == preReqId);
      courseStore.updateCourse(course);
    } else {
      throw new ValidationException(preReqId + " is not a prerequisite of course "+courseId);
    }
  }
  
  public void updateCourse(Course course) {
    courseStore.updateCourse(course);
  }
  
  public void updateCourse(CourseDTO dto) {
      Major major = majorService.getMajorById(dto.getMajorId());
        
      Course course = courseStore.getCourseById(dto.getId());
      course.setCredits(dto.getCredits());
      course.setDescription(dto.getDescription());
      course.setMajor(major);
      course.setName(dto.getName());
      course.setNumber(dto.getNumber());
      
      courseStore.updateCourse(course);
  }
  
}
