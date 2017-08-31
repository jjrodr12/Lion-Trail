package edu.psu.liontrail.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.liontrail.enumeration.SomeEnum;

@XmlRootElement(name="someDto")
@XmlAccessorType(XmlAccessType.NONE)
public class SomeDTO implements Serializable {
  
  private static final long serialVersionUID = -8497944572323376494L;

  @XmlElement(name="stringVal")
  private String string;
  
  @XmlElement(name="numberVal")
  private int number;
  
  @XmlElement(name="enumVal")
  private SomeEnum enumeration;

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public SomeEnum getEnumeration() {
    return enumeration;
  }

  public void setEnumeration(SomeEnum enumeration) {
    this.enumeration = enumeration;
  }

}
