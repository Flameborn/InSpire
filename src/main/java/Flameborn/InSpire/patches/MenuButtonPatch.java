package Flameborn.InSpire.patches;

import Flameborn.InSpire.utils.AUtil;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.mainMenu.MenuButton;

@SpirePatch(clz = MenuButton.class, method = SpirePatch.CONSTRUCTOR)
public class MenuButtonPatch {

  @SpirePostfixPatch()
  public static void postfix(MenuButton _instance) {
    AUtil.curContainer().addButton(_instance);
  }
}
