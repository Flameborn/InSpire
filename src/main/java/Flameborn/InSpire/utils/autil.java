package Flameborn.InSpire.utils;

import Flameborn.InSpire.Access.AContainer;
import Flameborn.InSpire.Access.AObject;
import com.megacrit.cardcrawl.helpers.input.InputActionSet;
import java.util.HashMap;

public class AUtil {
  private static HashMap<Screens, AContainer> containers = new HashMap<>();
  public static Screens screen = Screens.none;

  public static void newScreen(Screens type) {
    newScreen(type, true);
  }

  public static void newScreen(Screens type, boolean shouldChange) {
    containers.put(type, new AContainer());
    if (shouldChange) {
      screen = type;
    }
  }

  public static AContainer curContainer() {
    return containers.get(screen);
  }

  public static void addToCurContainer(Object obj, AObject.Types type) {
    curContainer().add(obj, type);
  }

  public static void checkKeys() {
    if (InputActionSet.up.isJustPressed()) {
      curContainer().prevItem();
    }

    if (InputActionSet.down.isJustPressed()) {
      curContainer().nextItem();
    }
  }

  public enum Screens {
    none,
    mainMenu;
  }
}
