package edu.psu.liontrail.adapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
  
  private static final DateTimeFormatter DTF = DateTimeFormatter.ISO_TIME;

  @Override
  public String marshal(LocalTime v) throws Exception {
    if (v == null) {
      return null;
    }
    return DTF.format(v);
  }

  @Override
  public LocalTime unmarshal(String v) throws Exception {
    if (v == null) {
      return null;
    }
    return LocalTime.parse(v, DTF);
  }

}
