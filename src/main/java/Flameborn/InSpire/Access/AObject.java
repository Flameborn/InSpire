package Flameborn.InSpire.Access;

import Flameborn.InSpire.utils.Speech;
import com.megacrit.cardcrawl.helpers.Hitbox;
import java.util.ArrayList;

public class AObject {
  public String label;
  public String hint;
  private ArrayList<AAction> actions = new ArrayList<>();
  private int actionIndex = -1;
  public Types type;

  public void addAction(String name, Hitbox hb) {
    this.actionIndex++;
    this.actions.add(new AAction(name, hb));
  }

  public AAction curAction() {
    return this.actions.get(actionIndex);
  }

  public void readCurAction() {
    Speech.speak(this.curAction().name, true);
  }

  public AAction nextAction() {
    if (this.actions.size() == 1) {
      this.readCurAction();
      return this.curAction();
    }

    if (this.actionIndex == this.actions.size() - 1) {
      this.actionIndex = 0;
    } else {
      this.actionIndex++;
    }
    this.readCurAction();
    return this.curAction();
  }

  public enum Types {
    menuButton,
    button,
    list,
    edit,
    text,
    slider;
  }
}
