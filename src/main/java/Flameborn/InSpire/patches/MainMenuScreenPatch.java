package Flameborn.InSpire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import Flameborn.InSpire.utils.Speech;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;
import com.megacrit.cardcrawl.core.CardCrawlGame;

@SpirePatch(
    clz = MainMenuScreen.class,
    method = SpirePatch.CONSTRUCTOR,
    paramtypez = {boolean.class})
public class MainMenuScreenPatch {

  @SpirePostfixPatch()
  public static void postfix(MainMenuScreen _instance) {
    Speech.speak(CardCrawlGame.languagePack.getUIString("RichPresence").TEXT[3]);
  }
}
