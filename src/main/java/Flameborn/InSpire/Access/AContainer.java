package Flameborn.InSpire.Access;

import Flameborn.InSpire.utils.Reflection;
import Flameborn.InSpire.utils.Speech;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;
import java.util.ArrayList;
import java.util.Collections;

public class AContainer {
  public int index = -1;
  private ArrayList<AObject> items = new ArrayList<>();

  public void addButton(Object item) {
    AObject obj = new AObject();
    obj.addAction("Activate", (Hitbox) Reflection.getField(item, "hb"));
    obj.type = AObject.Types.button;
    obj.label = (String) Reflection.getPrivate(item, item.getClass(), "label");
    this.items.add(obj);
  }

  public void addSaveSlotsButton(Object obj) {
    AObject aobj = new AObject();
    aobj.label = CardCrawlGame.playerName;
    aobj.type = AObject.Types.button;
    String[] text = (String[]) Reflection.getField(obj, "TEXT");
    aobj.hint = text[3];
    aobj.addAction(
        "Activate", (Hitbox) Reflection.getPrivate(obj, MainMenuScreen.class, "nameEditHb"));
    this.items.add(aobj);
  }

  public AObject curItem() {
    return this.items.get(this.index);
  }

  public void readCurItem() {
    this.readCurItem(true);
  }

  public void readCurItem(boolean interrupt) {
    AObject o = this.curItem();
    if (!o.label.endsWith(".")) o.label += ".";
    if (o.hint != null) {
      Speech.speak(o.label + " " + o.hint, interrupt);
    } else {
      Speech.speak(o.label, interrupt);
    }
  }

  public void handleHitbox(Hitbox hb) {
    if (hb == null) return;

    Gdx.input.setCursorPosition((int) hb.cX, Settings.HEIGHT - (int) hb.cY);
  }

  public void prevItem() {
    this.index--;
    if (this.index < 0) {
      this.index = 0;
      return;
    }
    this.handleHitbox(this.curItem().curAction().hb);
    this.readCurItem();
  }

  public void nextItem() {
    this.index++;
    if (this.index > items.size() - 1) {
      this.index = this.items.size() - 1;
      return;
    }
    this.handleHitbox(this.curItem().curAction().hb);
    this.readCurItem();
  }

  public void activateItem() {
    if (this.curItem().curAction().hb == null) return;
    InputHelper.justClickedLeft = true;
    this.curItem().curAction().hb.clicked = true;
  }

  public AObject firstItem() {
    return this.firstItem(true);
  }

  public AObject firstItem(boolean interrupt) {
    this.index = 0;
    this.handleHitbox(this.curItem().curAction().hb);
    this.readCurItem(interrupt);
    return this.curItem();
  }

  public AObject lastItem() {
    return this.lastItem(true);
  }

  public AObject lastItem(boolean interrupt) {
    this.index = this.items.size() - 1;
    this.handleHitbox(this.curItem().curAction().hb);
    this.readCurItem(interrupt);
    return this.curItem();
  }

  public AObject focusItem(int item) {
    return this.focusItem(item, true);
  }

  public AObject focusItem(int item, boolean interrupt) {
    if ((item > this.items.size() - 1) | (item < 0)) return this.curItem();

    this.index = item;
    this.handleHitbox(this.curItem().curAction().hb);
    this.readCurItem(interrupt);
    return this.curItem();
  }

  public void reverseitems() {
    Collections.reverse(items);
  }
}
