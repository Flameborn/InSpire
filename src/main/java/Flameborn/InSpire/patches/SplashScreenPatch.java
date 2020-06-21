package Flameborn.InSpire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import Flameborn.InSpire.utils.autil;
import java.util.ArrayList;
import com.megacrit.cardcrawl.screens.splash.SplashScreen;
import com.badlogic.gdx.Graphics;

public class SplashScreenPatch {

    @SpirePatch(
            clz= SplashScreen.class,
            method="update"
    )
    public static class SplashScreenFadePatch{

    @SpireInsertPatch(
            locator=Locator.class
    )
        public static void insert(SplashScreen _instance) {
autil.speak("Slay the Spire");
}

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher matcher = new Matcher.FieldAccessMatcher(SplashScreen.class, "isDone");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
        }
    }
}

    @SpirePatch(
            clz= SplashScreen.class,
            method="update"
    )
    public static class SplashScreenInitPatch{

    @SpireInsertPatch(
            locator=Locator.class
    )
        public static void insert(SplashScreen _instance) {
autil.speak("Mega Crit");
}

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher matcher = new Matcher.MethodCallMatcher(Graphics.class, "getDeltaTime");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
        }

    }
}

}