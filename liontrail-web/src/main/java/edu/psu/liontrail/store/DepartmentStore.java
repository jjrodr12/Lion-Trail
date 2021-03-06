package edu.psu.liontrail.store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.psu.liontrail.enumeration.Departments;
import edu.psu.liontrail.model.Department;

@Stateless
public class DepartmentStore {

  @PersistenceContext(unitName = "liontrail-ds")
  EntityManager em;
  
  public Department getDepartmentById(Departments id) {
    return em.find(Department.class, id);
  }
}
