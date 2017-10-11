package edu.psu.liontrail.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("resources")
public class LiontrailApp extends Application {
  
  public LiontrailApp() {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setTitle("LionTrail Swagger");
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/liontrail/resources");
    beanConfig.setResourcePackage("edu.psu.liontrail.rest");
    beanConfig.setScan(true);
  }

  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    
    classes.add(CourseResourceImpl.class);
    classes.add(SemesterResourceImpl.class);
    classes.add(UserResourceImpl.class);
    classes.add(MajorResourceImpl.class);
    classes.add(ClassResourceImpl.class);
    
    classes.add(ApiListingResource.class);
    classes.add(SwaggerSerializers.class);
    
    return classes;
  }
}
