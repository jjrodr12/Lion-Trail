package edu.psu.liontrail.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.psu.liontrail.data.ClassDTO;
import edu.psu.liontrail.data.CourseDTO;
import edu.psu.liontrail.data.MajorDTO;
import edu.psu.liontrail.data.RequiredCourseDTO;
import edu.psu.liontrail.data.RequiredCourseGroupDTO;
import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.model.Building;
import edu.psu.liontrail.model.Course;
import edu.psu.liontrail.model.Employee;
import edu.psu.liontrail.model.LiontrailClass;
import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.model.MajorGroup;
import edu.psu.liontrail.model.Room;
import edu.psu.liontrail.model.Semester;

public class DTOConveter {
  
  public static CourseDTO toCourseDTO(Course course, boolean includePrereq) {
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
    if (includePrereq && course.getPrerequisites() != null) {
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
        .map(c -> DTOConveter.toCourseDTO(c, false))
        .sorted((a,b) -> ((Integer)a.getNumber()).compareTo(b.getNumber()))
        .collect(Collectors.toList()));
    }
    if (major.getGroups() != null) {
      //System.out.println("Major Groups size: "+major.getGroups().size());
      if (requirements == null) {
        requirements = new RequiredCourseDTO();
      }
      List<RequiredCourseGroupDTO> groups = new ArrayList<>();
      for(MajorGroup g : major.getGroups()) {
        RequiredCourseGroupDTO group = new RequiredCourseGroupDTO();
        group.setNumberOfClasses(g.getSize());
        List<CourseDTO> courses = g.getCourses().stream()
            .map(c -> DTOConveter.toCourseDTO(c, false))
            .sorted((a,b) -> ((Integer)a.getNumber()).compareTo(b.getNumber()))
            .collect(Collectors.toList());
        group.setCourses(courses);
        groups.add(group);
      }
      requirements.setGroup(groups);
    } else {
      System.out.println("Major Groups is NULLs");
    }
    
    dto.setRequirements(requirements);
    return dto;
  }
  
  public static ClassDTO toClassDTO(LiontrailClass ltClass, Building building) {
    ClassDTO dto = new ClassDTO();
    
    dto.setClassId(ltClass.getId());
    
    if (building != null) {
      dto.setBuildingId(building.getId());
      dto.setBuildingName(building.getName());
    }
    
    dto.setClassFrequency(ltClass.getFrequency());
    
    Course course = ltClass.getCourse();
    if (course != null) {
      Major major = course.getMajor();
      dto.setCourseAbbreviation(major == null ? null : major.getAbbreviation());
      dto.setCourseId(course.getId());
      dto.setCourseName(course.getName());
    }
    
    Employee emp = ltClass.getInstructor();
    if (emp != null) {
      dto.setInstructorFirstName(emp.getName().getFirstName());
      dto.setInstructorId(emp.getId());
      dto.setInstructorLastName(emp.getName().getLastName());
    }
    
    dto.setOnline(ltClass.isOnline());
    
    Room room = ltClass.getRoom();
    if (room != null) {
      dto.setRoomId(room.getId());
      dto.setRoomNumber(room.getNumber());
    }
    
    Semester semester = ltClass.getSemester();
    if (semester != null) {
      dto.setSemesterSeason(semester.getSeason());
      dto.setSemesterYear(semester.getYear());
    }
    
    dto.setStartTime(ltClass.getStartTime());
    dto.setStopTime(ltClass.getStopTime());
    
    return dto;
  }

}
