package Flameborn.InSpire;

import basemod.BaseMod;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Flameborn.InSpire.utils.autil;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.badlogic.gdx.Gdx;

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
File tolkDLL = new File("Tolk.dll");
if(!tolkDLL.exists()) { 
// Extract
logger.info("Unable to find Tolk library, extracting...");
try {
extractFile(InSpire.class.getResourceAsStream("/InSpireResources/libs/Tolk.dll"), "Tolk.dll");
extractFile(InSpire.class.getResourceAsStream("/InSpireResources/libs/nvdaControllerClient64.dll"),"nvdaControllerClient64.dll");
extractFile(InSpire.class.getResourceAsStream("/InSpireResources/libs/SAAPI64.dll"),"SAAPI64.dll");
} catch(IOException e) {
logger.error("Unable to extract Tolk.");
}
}
if (!autil.load()) {
tolkError();
}
        logger.info("=== Done! ===");
  }

private static void tolkError() {
JOptionPane.showMessageDialog(null, "Unable to load Tolk.","Error",JOptionPane.ERROR_MESSAGE);
Gdx.app.exit();
}

private static void extractFile(InputStream io, String fileName) throws IOException {
FileOutputStream fos = new FileOutputStream(fileName);
byte[] buf = new byte[256];
int read = 0;

while ((read = io.read(buf)) > 0) {
fos.write(buf, 0, read);
}
fos.close();
}

}
