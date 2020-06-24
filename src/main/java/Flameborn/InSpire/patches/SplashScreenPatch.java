package Flameborn.InSpire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import Flameborn.InSpire.utils.Speech;
import java.util.ArrayList;
import com.megacrit.cardcrawl.screens.splash.SplashScreen;
import com.badlogic.gdx.Graphics;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.helpers.input.InputActionSet;
import com.megacrit.cardcrawl.core.CardCrawlGame;

public class SplashScreenPatch {

  @SpirePatch(clz = SplashScreen.class, method = "update")
  public static class SplashScreenFadePatch {

    @SpireInsertPatch(locator = Locator.class)
    public static void insert(SplashScreen _instance) {
      Speech.speak("Slay the Spire");
    }

    private static class Locator extends SpireInsertLocator {
      public int[] Locate(CtBehavior ctMethodToPatch)
          throws CannotCompileException, PatchingException {
        Matcher matcher = new Matcher.FieldAccessMatcher(SplashScreen.class, "isDone");
        return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
      }
    }
  }

  @SpirePatch(clz = SplashScreen.class, method = "update")
  public static class SplashScreenInitPatch {

    @SpireInsertPatch(locator = Locator.class)
    public static void insert(SplashScreen _instance) {
      Speech.speak("Mega Crit");
    }

    private static class Locator extends SpireInsertLocator {
      public int[] Locate(CtBehavior ctMethodToPatch)
          throws CannotCompileException, PatchingException {
        Matcher matcher = new Matcher.MethodCallMatcher(Graphics.class, "getDeltaTime");
        return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
      }
    }
  }

  @SpirePatch(clz = SplashScreen.class, method = "update")
  public static class SplashScreenUpdatePrefixPatch {

    @SpirePrefixPatch
    public static void prefix(SplashScreen _instance) {
      if (InputActionSet.confirm.isJustPressed()) {
        InputHelper.justClickedLeft = true;
      }
    }
  }

  @SpirePatch(clz = SplashScreen.class, method = "update")
  public static class SplashScreenFadePatch2 {

    @SpireInsertPatch(locator = Locator.class)
    public static void insert(SplashScreen _instance) {
      CardCrawlGame.sound.play("UI_CLICK_2");
    }

    private static class Locator extends SpireInsertLocator {
      public int[] Locate(CtBehavior ctMethodToPatch)
          throws CannotCompileException, PatchingException {
        Matcher matcher = new Matcher.FieldAccessMatcher(SplashScreen.class, "timer");
        return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
      }
    }
  }
}
