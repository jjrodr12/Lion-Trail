package edu.psu.liontrail.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.enumeration.SemesterSeason;
import edu.psu.liontrail.model.Semester;
import edu.psu.liontrail.rest.SemesterResource;
import edu.psu.liontrail.store.SemesterStore;

public class SemesterResourceImpl implements SemesterResource {
  
  @Inject
  SemesterStore semesterStore;

  @Override
  public Response getSemesterById(int id) {
    Semester semester = semesterStore.getSemesterById(id);
    
    return Response.ok().entity(semester).build();
  }

  @Override
  public Response getAllSemesters() {
    List<Semester> semesters = semesterStore.getAllSemesters();
    GenericEntity<List<Semester>> list = new GenericEntity<List<Semester>>(semesters){};
    return Response.ok().entity(list).build();
  }

  @Override
  public Response getSemesterByYearAndSeason(int year, SemesterSeason season) {
    Semester semester = semesterStore.getSemesterBySeasonAndYear(season, year);
    return Response.ok().entity(semester).build();
  }

}
