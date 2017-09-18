package edu.psu.lionltrail.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import edu.psu.liontrail.model.SemesterEntity;
import edu.psu.liontrail.rest.SemesterResource;
import edu.psu.liontrail.store.SemesterStore;

public class SemesterResourceImpl implements SemesterResource{
  
  @Inject 
  SemesterStore semesterStore;

  @Override
  public Response getSemesterById(int id) {
    SemesterEntity semester = semesterStore.getSemesterById(id);
    return Response.ok().entity(semester).build();
  }
  

  @Override
  public Response getAllSemesters() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
