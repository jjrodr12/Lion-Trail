package edu.psu.liontrail.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(LocalDateTime v) {
    if (v == null) {
      return null;
    }
    return Timestamp.valueOf(v);
  }

  @Override
  public LocalDateTime convertToEntityAttribute(Timestamp v) {
    if (v == null) {
      return null;
    }
    return v.toLocalDateTime();
  }

}
