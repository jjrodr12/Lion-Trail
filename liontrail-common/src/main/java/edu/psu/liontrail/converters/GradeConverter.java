package edu.psu.liontrail.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import edu.psu.liontrail.enumeration.Grade;

@Converter(autoApply=true)
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
