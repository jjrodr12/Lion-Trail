package edu.psu.liontrail.converters;

import javax.persistence.AttributeConverter;

import edu.psu.liontrail.enumeration.Grade;

public class GradeConverter implements AttributeConverter<Grade, String> {

  @Override
  public String convertToDatabaseColumn(Grade v) {
    if (v == null) {
      return null;
    }
    return v.getAbbreviation();
  }

  @Override
  public Grade convertToEntityAttribute(String v) {
    if (v == null) {
      return null;
    }
    return Grade.lookup(v).orElse(null);
  }

  
}
