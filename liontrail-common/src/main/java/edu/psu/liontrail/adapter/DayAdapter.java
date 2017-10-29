package edu.psu.liontrail.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import edu.psu.liontrail.enumeration.Day;

public class DayAdapter extends XmlAdapter<String, Day> {

  @Override
  public String marshal(Day v) throws Exception {
    if (v == null) {
      return null;
    }
    return v.getTwoLetter();
  }

  @Override
  public Day unmarshal(String v) throws Exception {
    if (v == null) {
      return null;
    }
    return Day.enumValue(v).orElse(null);
  }

}
