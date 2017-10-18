package edu.psu.liontrail.enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Day {

  SUNDAY("SU","SUN"),
  MONDAY("MO","MON"),
  TUESDAY("TU","TUE"),
  WEDNESDAY("WE","WED"),
  THURSDAY("TH","THU"),
  FRIDAY("FR","FRI"),
  SATURDAY("SA","SAT");
  
  private static final Map<String, Day> lookup = new HashMap<>();
  
  static {
    for(Day d : Day.values()) {
      lookup.put(d.name().toUpperCase(), d);
      lookup.put(d.getTwoLetter().toUpperCase(), d);
      lookup.put(d.getThreeLetter().toUpperCase(), d);
    }
  }
  
  Day(String twoLetter, String threeLetter) {
    this.twoLetter = twoLetter;
    this.threeLetter = threeLetter;
  }
  
  private final String twoLetter;
  private final String threeLetter;
  public String getTwoLetter() {
    return twoLetter;
  }
  public String getThreeLetter() {
    return threeLetter;
  }
  
  public static Optional<Day> enumValue(String str) {
    if (str == null) {
      return Optional.empty();
    }
    return Optional.ofNullable(lookup.get(str.toUpperCase()));
  }
  
}
