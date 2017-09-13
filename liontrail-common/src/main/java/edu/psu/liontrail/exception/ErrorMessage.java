package edu.psu.liontrail.exception;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.psu.liontrail.adapter.XmlStatusAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ErrorMessage implements Serializable {

  private static final long serialVersionUID = -3259238191684300995L;

  @XmlElement(name = "status")
  @XmlJavaTypeAdapter(XmlStatusAdapter.class)
  private Status status;

  @XmlElementWrapper(name = "errorMessageList")
  @XmlElement(name = "errorMessage")
  List<String> errorMessages = new ArrayList<>();

  @XmlElementWrapper(name = "referenceList", nillable = true)
  @XmlElement(name = "link", nillable = true)
  List<String> externalLinks = null;

  public ErrorMessage() {
  }
  
  public ErrorMessage(Status status, String message) {
    this.status = status;
    errorMessages.add(message);
  }
  
  public ErrorMessage(Status status, Collection<String> messages) {
    this.status = status;
    errorMessages.addAll(messages);
  }

  public ErrorMessage(Status status) {
    this.status = status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public void setErrorMessageList(List<String> messageList) {
    if (messageList == null) {
      errorMessages.clear();
    } else {
      errorMessages = messageList;
    }
  }

  public void addErrorMessage(String message) {
    errorMessages.add(message);
  }

  public List<String> getErrorMessageList() {
    return Collections.unmodifiableList(errorMessages);
  }

  public void setExternalLinkList(List<String> linkList) {
    externalLinks = linkList;
  }

  public void addExtenalLink(URL link) {
    if (externalLinks == null) {
      externalLinks = new ArrayList<>();
    }

    externalLinks.add(link.toString());
  }

  public List<String> getExternalLinkList() {
    return externalLinks;
  }

  public Response toResponse() {
    return Response.status(status).entity(this).build();
  }

  public Response toResponse(String mediaType) {
    return Response.status(status).entity(this).type(mediaType).build();
  }

  public Response toResponse(MediaType mediaType) {
    return Response.status(status).entity(this).type(mediaType).build();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Status = ");
    sb.append(status.getStatusCode());
    sb.append("\n");

    if (errorMessages != null) {
      sb.append("Error Messages");
      sb.append("\n");
      for (String s : errorMessages) {
        sb.append(s);
        sb.append("\n");
      }
    }

    if (externalLinks != null) {
      sb.append("External Links");
      for (String s : externalLinks) {
        sb.append(s);
        sb.append("\n");
      }
    }
    return sb.toString();
  }

}
