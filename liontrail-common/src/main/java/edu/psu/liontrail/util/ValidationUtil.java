package edu.psu.liontrail.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import edu.psu.liontrail.exception.ValidationException;

public class ValidationUtil {

  public static boolean allNotNull(Object... objects) {
    if (objects != null) {
      List<Object> list = Arrays.asList(objects);
      return !list.stream().anyMatch(o -> o == null);
    }
    return true;
  }
  
  public static void nullCheckValidation(Object... objects) throws ValidationException {
    if (objects != null) {
      List<Object> list = Arrays.asList(objects);
    }
  }
}
