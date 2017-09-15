package edu.psu.liontrail.converters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDate, Date> {

  @Override
  public Date convertToDatabaseColumn(LocalDate v) {
    if (v == null) {
      return null;
    }
    return Date.from(v.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  @Override
  public LocalDate convertToEntityAttribute(Date v) {
    if (v == null) {
      return null;
    }
    return v.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

}
