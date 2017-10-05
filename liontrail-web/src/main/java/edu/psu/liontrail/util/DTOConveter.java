package edu.psu.liontrail.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.model.Course;

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

}
