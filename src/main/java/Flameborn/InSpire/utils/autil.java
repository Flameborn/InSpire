package Flameborn.InSpire.utils;

import Flameborn.InSpire.Access.AContainer;
import Flameborn.InSpire.Access.AInput;
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

  public static void checkKeys() {
    if (InputActionSet.up.isJustPressed()) {
      curContainer().prevItem();
    }

    if (InputActionSet.down.isJustPressed()) {
      curContainer().nextItem();
    }

    if (!AInput.isShiftPressed() && InputActionSet.confirm.isJustPressed()) {
      curContainer().activateItem();
    }

    if (AInput.home.isJustPressed()) {
      curContainer().firstItem();
    }

    if (AInput.end.isJustPressed()) {
      curContainer().lastItem();
    }

    if (AInput.isSwitchActionJustPressed()) {
      curContainer().curItem().nextAction();
    }
  }

  public static void reverseItems() {
    curContainer().reverseitems();
  }

  public enum Screens {
    none,
    mainMenu;
  }
}
