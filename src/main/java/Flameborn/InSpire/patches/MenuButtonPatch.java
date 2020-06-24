package Flameborn.InSpire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import Flameborn.InSpire.Access.*;
import com.megacrit.cardcrawl.screens.mainMenu.MenuButton;

@SpirePatch(clz = MenuButton.class, method = SpirePatch.CONSTRUCTOR)
public class MenuButtonPatch {

  @SpirePostfixPatch()
  public static void postfix(MenuButton _instance) {
    // AContainer.add(_instance, AObject.Types.menuButton);
  }
}
