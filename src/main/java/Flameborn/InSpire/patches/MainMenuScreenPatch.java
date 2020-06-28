package Flameborn.InSpire.patches;

import Flameborn.InSpire.Access.AObject;
import Flameborn.InSpire.utils.AUtil;
import Flameborn.InSpire.utils.Reflection;
import Flameborn.InSpire.utils.Speech;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.Hitbox;
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
        AObject obj = new AObject();
        obj.label = CardCrawlGame.playerName;
        obj.type = AObject.Types.menuButton;
        obj.hint = _instance.TEXT[3];
        obj.hb = (Hitbox) Reflection.getPrivate(_instance, MainMenuScreen.class, "nameEditHb");
        AUtil.addAObject(obj);
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
