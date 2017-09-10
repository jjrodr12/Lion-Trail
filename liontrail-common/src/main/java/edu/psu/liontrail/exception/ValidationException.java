package edu.psu.liontrail.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

public class ValidationException extends Exception {
  
  private static final long serialVersionUID = 9172091113325733394L;
  
  private List<String> messages = new ArrayList<>();
  
  public ValidationException() {}
  
  public ValidationException(String msg) {
    messages.add(msg);
  }
  
  public ValidationException(Collection<String> msg) {
    messages.addAll(msg);
  }
  
  public void addMessage(String message) {
    messages.add(message);
  }
  
  public List<String> getMessages() {
    return messages;
  }
  
  public boolean hasErrors() {
    return !messages.isEmpty();
  }
  
  @Override
  public String getMessage() {
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    messages.forEach(e -> joiner.add(e));
    return "Validation Exceptions: "+joiner.toString();
  }
}
