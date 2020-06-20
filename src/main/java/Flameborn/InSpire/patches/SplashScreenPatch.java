package Flameborn.InSpire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.splash.SplashScreen;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import Flameborn.InSpire.utils.autil;
import java.util.ArrayList;

    @SpirePatch(
            clz= SplashScreen.class,
            method="update"
    )
    public class SplashScreenPatch{

    @SpireInsertPatch(
            locator=Locator.class
    )
        public static void insert(SplashScreen _instance) {
autil.speak("Welcome to Slay the Spire");
}

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher matcher = new Matcher.FieldAccessMatcher(SplashScreen.class, "isDone");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), matcher);
        }

    }

}