package Flameborn.InSpire.utils;

import Flameborn.InSpire.Access.AContainer;
import Flameborn.InSpire.utils.Speech;
import java.util.HashMap;

public class AUtil {
  private static HashMap<Screens, AContainer> containers = new HashMap<Screens, AContainer>();
  public static Screens screen = Screens.none;

  public static void newScreen(Screens type) {
    newScreen(type, true);
  }

  public static void newScreen(Screens type, Boolean change) {
    containers.put(screen, new AContainer());
    if (change) {
      screen = type;
    }
  }

  public static AContainer curContainer() {
    return containers.get(screen);
  }

  public enum Screens {
    none,
    mainMenu;
  }
}
