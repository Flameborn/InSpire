package Flameborn.InSpire.utils;

import Flameborn.InSpire.InSpire;
import basemod.ReflectionHacks;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {

  public static boolean isPrivate(Object obj, String fieldName) {
    boolean ret = false;

    try {
      Field field = obj.getClass().getDeclaredField(fieldName);
      ret = Modifier.isPrivate(field.getModifiers());
    } catch (Exception e) {
      InSpire.logger.error("Unable to determine whether field is private: " + e.getMessage());
    }
    return ret;
  }

  public static Object getField(Object obj, String fieldName) {
    Object field = null;

    try {
      field = obj.getClass().getField(fieldName).get(obj);
    } catch (Exception e) {
      InSpire.logger.error("Unable to get field: " + e);
    }
    return field;
  }

  public static boolean hasField(Object object, String fieldName) {
    return Arrays.stream(object.getClass().getFields())
        .anyMatch(f -> f.getName().equals(fieldName));
  }

  public static Object getPrivate(Object obj, Class<?> objClass, String fieldName) {
    return ReflectionHacks.getPrivate(obj, objClass, fieldName);
  }
}
