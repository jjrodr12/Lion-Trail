package edu.psu.liontrail.enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Role {
  
  ADMIN("admin"),
  ADMISSIONS("admissions"),
  DEAN("dean"),
  STUDENT("student"),
  INSTRUCTOR("instructor");
  
  private static Map<String, Role> lookup = new HashMap<>();
  
  static {
    for(Role r : Role.values()) {
      lookup.put(r.getValue().toLowerCase(), r);
    }
  }
  
  Role(String value) {
    this.value = value;
  }
  
  private final String value;
  
  public String getValue() {
    return value;
  }
  
  public static Optional<Role> lookup(String input) {
    if (input == null) {
      return Optional.empty();
    }
    
    return Optional.ofNullable(lookup.get(input.toLowerCase()));
  }

}
