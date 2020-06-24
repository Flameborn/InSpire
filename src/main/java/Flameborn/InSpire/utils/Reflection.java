package Flameborn.InSpire.utils;

import basemod.ReflectionHacks;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {

  public static boolean isPrivate(Object obj, String fieldName) throws Exception {
    Field field = obj.getClass().getDeclaredField(fieldName);
    return Modifier.isPrivate(field.getModifiers());
  }

  public static boolean hasField(Object object, String fieldName) {
    return Arrays.stream(object.getClass().getFields())
        .anyMatch(f -> f.getName().equals(fieldName));
  }

  public static Object getPrivate(Object obj, Class<?> objClass, String fieldName) {
    return ReflectionHacks.getPrivate(obj, objClass, fieldName);
  }
}
