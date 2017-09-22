package edu.psu.liontrail.converters;

import javax.persistence.AttributeConverter;

import edu.psu.liontrail.enumeration.Grade;
import edu.psu.liontrail.enumeration.Role;

public class RoleConverter implements AttributeConverter<Role, String> {

  @Override
  public String convertToDatabaseColumn(Role v) {
    if (v == null) {
      return null;
    }
    return v.getValue();
  }

  @Override
  public Role convertToEntityAttribute(String v) {
    if (v == null) {
      return null;
    }
    return Role.lookup(v).orElse(null);
  }

}
