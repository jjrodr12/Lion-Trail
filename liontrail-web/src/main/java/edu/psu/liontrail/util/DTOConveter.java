package edu.psu.liontrail.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.MajorDTO;
import edu.psu.liontrail.data.RequiredCourseDTO;
import edu.psu.liontrail.data.RequiredCourseGroupDTO;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.MajorGroup;

public class DTOConveter {
  
  public static CourseDTO toCourseDTO(Course course) {
    CourseDTO dto = new CourseDTO();
    dto.setId(course.getId());
    dto.setCredits(course.getCredits());
    dto.setDescription(course.getDescription());
    dto.setName(course.getName());
    dto.setNumber(course.getNumber());
    if (course.getMajor() != null) {
      dto.setMajorId(course.getMajor().getId());
      dto.setMajorName(course.getName());
      dto.setMajorAbr(course.getMajor().getAbbreviation());
      dto.setMajorLevel(course.getMajor().getLevel());
    }
    if (course.getPrerequisites() != null) {
      List<CourseDTO> preReqs = new ArrayList<>();
      for(Course c : course.getPrerequisites()) {
        CourseDTO preReq = new CourseDTO();
        preReq.setId(c.getId());
        preReq.setMajorAbr(c.getMajor().getAbbreviation());
        preReq.setName(c.getName());
        preReq.setNumber(c.getNumber());
        preReqs.add(preReq);
      }
      dto.setPrerequisites(preReqs);
      //dto.setPrerequisites(course.getPrerequisites().stream().map(c -> c.getId()).collect(Collectors.toList()));
    }
    
    return dto;
  }
  
  public static MajorDTO toMajorDTO(Major major) {
    MajorDTO dto = new MajorDTO();
    
    dto.setId(major.getId());
    dto.setAbbreviation(major.getAbbreviation());
    dto.setName(major.getName());
    dto.setLevel(major.getLevel());
    
    if (major.getDepartment() != null) {
      dto.setDepartmentId(major.getDepartment().getId());
      dto.setDepartmentName(major.getDepartment().getName());
    }
    
    RequiredCourseDTO requirements = null;
    if (major.getRequiredCourses() != null) {
      System.out.println("Number of RequiredClasses: "+major.getRequiredCourses().size());
      requirements = new RequiredCourseDTO();
      
      requirements.setRequiredClasses(major.getRequiredCourses().stream()
        .map(c -> DTOConveter.toCourseDTO(c))
        .sorted((a,b) -> ((Integer)a.getNumber()).compareTo(b.getNumber()))
        .collect(Collectors.toList()));
    }
    if (major.getGroups() != null) {
      if (requirements == null) {
        requirements = new RequiredCourseDTO();
      }
      List<RequiredCourseGroupDTO> groups = new ArrayList<>();
      for(MajorGroup g : major.getGroups()) {
        RequiredCourseGroupDTO group = new RequiredCourseGroupDTO();
        group.setNumberOfClasses(g.getSize());
        List<CourseDTO> courses = g.getCourses().stream()
            .map(c -> DTOConveter.toCourseDTO(c))
            .sorted((a,b) -> ((Integer)a.getNumber()).compareTo(b.getNumber()))
            .collect(Collectors.toList());
        group.setCourses(courses);
        groups.add(group);
      }
      requirements.setGroup(groups);
     
      
    }
    
    dto.setRequirements(requirements);
    return dto;
  }

}
