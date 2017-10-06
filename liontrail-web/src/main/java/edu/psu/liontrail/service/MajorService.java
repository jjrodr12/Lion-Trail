package edu.psu.liontrail.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.psu.liontrail.model.Major;
import edu.psu.liontrail.store.MajorStore;

@Stateless
public class MajorService {

  @Inject
  MajorStore majorStore;
  
  public Major getMajorById(int id) {
    return majorStore.getMajorById(id);
  }
  
  public Major getMajorByAbbreviation(String abbreviation) {
    return majorStore.getMajorByAbbreviation(abbreviation);
  }
}
