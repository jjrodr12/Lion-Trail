package edu.psu.liontrail.converters;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time>{

  @Override
  public Time convertToDatabaseColumn(LocalTime v) {
    if (v == null) {
      return null;
    }
    return Time.valueOf(v);
  }

  @Override
  public LocalTime convertToEntityAttribute(Time v) {
    if (v == null) {
      return null;
    }
    return v.toLocalTime();
  }

}
