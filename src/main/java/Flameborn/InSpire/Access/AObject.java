package Flameborn.InSpire.Access;

import com.megacrit.cardcrawl.helpers.Hitbox;

public class AObject {
  public String label;
  public String hint;
  public Hitbox hb = null;
  public Types type;

  public enum Types {
    menuButton,
    button,
    list,
    edit,
    slider;
  }
}
