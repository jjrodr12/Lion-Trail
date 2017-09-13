package edu.psu.liontrail.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class LiontrailApp extends Application {

  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    //classes.add(TestResourceImpl.class);
    classes.add(SemesterResourceImpl.class);
    
    return classes;
  }
}
