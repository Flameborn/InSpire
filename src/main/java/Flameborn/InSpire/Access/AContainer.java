package Flameborn.InSpire.Access;

import com.megacrit.cardcrawl.helpers.Hitbox;
import Flameborn.InSpire.Access.AObject;
import Flameborn.InSpire.utils.Speech;
import Flameborn.InSpire.utils.Reflection;
import java.util.ArrayList;

public class AContainer {
  public int index = -1;
  private ArrayList<AObject> items = new ArrayList<AObject>();

  public void add(Object item, AObject.Types type) throws Exception {
    AObject obj = new AObject();
    if (Reflection.hasField(item, "hb")) obj.hb = (Hitbox) item.getClass().getField("hb").get(this);
    obj.type = type;
    obj.label = (String) Reflection.getPrivate(item, item.getClass(), "label");
    this.items.add(obj);
  }

  public AObject curItem() {
    return this.items.get(this.index);
  }

  public void readCurItem() {
    AObject o = this.curItem();
    o.hb.justHovered = true;
    Speech.speak(o.label);
  }

  public void prevItem() {
    this.index--;
    if (this.index < 0) this.index = 0;
    this.readCurItem();
  }

  public void nextItem() {
    this.index++;
    if (this.index > this.items.size() - 1) this.index = this.items.size() - 1;
    this.readCurItem();
  }
}
