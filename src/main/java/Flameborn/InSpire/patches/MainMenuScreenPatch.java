package Flameborn.InSpire.patches;

import Flameborn.InSpire.utils.AUtil;
import Flameborn.InSpire.utils.Speech;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;

public class MainMenuScreenPatch {

  @SpirePatch(
      clz = MainMenuScreen.class,
      method = SpirePatch.CONSTRUCTOR,
      paramtypez = {boolean.class})
  public static class MainMenuScreenInitPatch {

    @SpirePostfixPatch()
    public static void postfix(MainMenuScreen _instance) {
      if (CardCrawlGame.playerName != null) {
        AUtil.curContainer().addSaveSlotsButton(_instance);
      }
      AUtil.reverseItems();
      Speech.speak(CardCrawlGame.languagePack.getUIString("RichPresence").TEXT[3]);
      AUtil.curContainer().firstItem(false);
    }

    @SpirePrefixPatch()
    public static void prefix(MainMenuScreen _instance) {
      AUtil.newScreen(AUtil.Screens.mainMenu);
    }
  }

  @SpirePatch(clz = MainMenuScreen.class, method = "update")
  public static class MainMenuScreenUpdatePatch {

    @SpirePrefixPatch()
    public static void prefix(MainMenuScreen _instance) {
      AUtil.checkKeys();
    }
  }
}
