package Flameborn.InSpire;

import basemod.BaseMod;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Flameborn.InSpire.utils.autil;

@SpireInitializer
public class InSpire {

    public static final Logger logger = LogManager.getLogger(InSpire.class.getName());
    private static String modID;

    public static void setModID(String ID) {
            modID = ID;
        logger.info("Success! ID is " + modID);
    }
    
    public static String getModID() {
        return modID;
    }
    
    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("=== Initializing InSpire ===");
InSpire inspire = new InSpire();
if (!autil.load()) {
        logger.error("Unable to load Tolk!");
}
        logger.info("=== Done! ===");
  }

}
