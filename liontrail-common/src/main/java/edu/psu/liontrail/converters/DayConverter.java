package edu.psu.liontrail.converters;

import javax.persistence.AttributeConverter;

import edu.psu.liontrail.enumeration.Day;
import edu.psu.liontrail.enumeration.Grade;

public class DayConverter implements AttributeConverter<Day, String> {

  @Override
  public String convertToDatabaseColumn(Day v) {
    if (v == null) {
      return null;
    }
    return v.getTwoLetter();
  }

  @Override
  public Day convertToEntityAttribute(String v) {
    if (v == null) {
      return null;
    }
    return Day.enumValue(v).orElse(null);
  }

}
