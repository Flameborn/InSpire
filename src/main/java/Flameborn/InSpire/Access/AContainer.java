package Flameborn.InSpire.Access;

import Flameborn.InSpire.InSpire;
import Flameborn.InSpire.utils.Reflection;
import Flameborn.InSpire.utils.Speech;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.Hitbox;
import java.util.ArrayList;

public class AContainer {
  public int index = -1;
  private ArrayList<AObject> items = new ArrayList<AObject>();

  public void add(Object item, AObject.Types type) {
    AObject obj = new AObject();
    if (Reflection.hasField(item, "hb")) {
      if (Reflection.isPrivate(item, "hb")) {
        obj.hb = (Hitbox) Reflection.getPrivate(item, Hitbox.class, "hb");
      } else {
        obj.hb = (Hitbox) Reflection.getField(item, "hb");
      }
    }
    obj.type = type;
    if (Reflection.hasField(item, "label") && Reflection.isPrivate(item, "label")) {
      obj.label = (String) Reflection.getPrivate(item, item.getClass(), "label");
      InSpire.logger.info(obj.label);
    }
    this.items.add(obj);
  }

  public AObject curItem() {
    return this.items.get(this.index);
  }

  public void readCurItem() {
    AObject o = this.curItem();
    Speech.speak(o.label, true);
  }

  public void handleHitbox(Hitbox hb) {
    if (hb == null) return;
    hb.justHovered = true;
  }

  public void prevItem() {
    this.index--;
    if (this.index < 0) {
      this.index = 0;
      return;
    }
    this.readCurItem();
    CardCrawlGame.sound.play("UI_HOVER", 0.75f);
  }

  public void nextItem() {
    this.index++;
    if (this.index > items.size() - 1) {
      this.index = this.items.size() - 1;
      return;
    }
    this.readCurItem();
    CardCrawlGame.sound.play("UI_HOVER");
  }

  public void activateItem() {
    if (this.curItem().hb == null) return;
    CardCrawlGame.sound.playA("UI_CLICK_1", -0.1f);
    this.curItem().hb.clicked = true;
  }
}
