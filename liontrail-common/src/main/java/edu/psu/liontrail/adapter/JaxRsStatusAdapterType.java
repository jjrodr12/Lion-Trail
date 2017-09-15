package edu.psu.liontrail.adapter;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error-message")
@XmlAccessorType(XmlAccessType.NONE)
public class JaxRsStatusAdapterType
{
  @XmlElement(name="code")
  private int code;
  
  @XmlElement(name="message")
  private String message;
  
  public JaxRsStatusAdapterType() {
    // Required no-argument constructor for JAXB marshalling/unmarshalling
  }
  
  public JaxRsStatusAdapterType(Status status) {
    code = status.getStatusCode();
    message  = status.name();
  }
  
  public void setStatus(Status status) {
    code = status.getStatusCode();
    message = status.name();
  }
  
  public Status getStatus() {
    return Status.fromStatusCode(code);
  }
  
  public int getCode() {
    return code;
  }
  
  public String getMessage() {
    return message;
  }
}
