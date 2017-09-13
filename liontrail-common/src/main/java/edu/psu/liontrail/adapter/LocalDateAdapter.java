package edu.psu.liontrail.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
  
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;

  @Override
  public String marshal(LocalDate v) throws Exception {
    if (v == null) {
      return null;
    }
    return FORMATTER.format(v);
  }

  @Override
  public LocalDate unmarshal(String v) throws Exception {
    if (v == null || v.trim().isEmpty()) {
      return null;
    }
    return LocalDate.parse(v, FORMATTER);
  }

}
