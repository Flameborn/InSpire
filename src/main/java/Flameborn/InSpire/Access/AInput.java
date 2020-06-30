package Flameborn.InSpire.Access;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.helpers.input.InputAction;

public class AInput {
  public static InputAction home = new InputAction(3);
  public static InputAction end = new InputAction(132);
  private static final int[] shift = new int[] {59, 60};

  public static boolean isShiftPressed() {
    for (final int c : AInput.shift) {
      if (Gdx.input.isKeyPressed(c)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isSwitchActionJustPressed() {
    return AInput.isShiftPressed() && Gdx.input.isKeyJustPressed(66);
  }
}
