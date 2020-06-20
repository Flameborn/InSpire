package Flameborn.InSpire.utils;

import com.davykager.tolk.Tolk;

public class autil {

public static boolean load() {
Tolk.trySAPI(true);
Tolk.preferSAPI(true);
Tolk.load();
if (!Tolk.isLoaded()) {
return false;
}
return true;
}

public static void speak(String text) {
Tolk.output(text);
}

}
