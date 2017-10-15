package edu.psu.liontrail.service;

import javax.inject.Inject;

import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.model.Department;
import edu.psu.liontrail.store.DepartmentStore;

public class DepartmentService {
  
  @Inject
  DepartmentStore departmentStore;
  
  public Department getDepartmentById(Departments department) {
    return departmentStore.getDepartmentById(department);
  }

}
