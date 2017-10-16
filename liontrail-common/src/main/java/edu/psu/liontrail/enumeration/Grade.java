package edu.psu.liontrail.enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Grade {
  
  A("A", 4.0),
  A_MINUS("A-", 3.7),
  B_PLUS("B+", 3.3),
  B("B", 3.0),
  B_MINUS("B-", 2.7),
  C_PLUS("C+", 2.3),
  C("C", 2.0),
  C_MINUS("C-", 1.7),
  D_PLUS("D+", 1.3),
  D("D", 1.0),
  D_MINUS("D-", 0.7),
  F("F", 0.0),
  INCOMPLETE("IN", null),
  IN_PROGRESS("IP",null);
  
  private static Map<String, Grade> lookup = new HashMap<>();
  
  static {
    for(Grade g : Grade.values()) {
      lookup.put(g.getAbbreviation().toUpperCase(), g);
    }
  }
  
  Grade(String abbreviation, Double value) {
    this.abbreviation = abbreviation;
    this.value = value;
  }
  
  final private String abbreviation;
  
  final private Double value;

  public String getAbbreviation() {
    return abbreviation;
  }

  public Double getValue() {
    return value;
  }
  
  public static Optional<Grade> lookup(String str) {
    if (str == null) {
      return Optional.empty();
    }
    
    return Optional.ofNullable(lookup.get(str.toUpperCase()));
  }

  public int getId() {
    // TODO Auto-generated method stub
    return 0;
  }

  public Object getSeason() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getYear() {
    // TODO Auto-generated method stub
    return null;
  }

}
