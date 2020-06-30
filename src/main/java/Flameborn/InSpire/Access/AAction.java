package Flameborn.InSpire.Access;

import com.megacrit.cardcrawl.helpers.Hitbox;

public class AAction {
  public Hitbox hb = null;
  public String name;

  public AAction(String name, Hitbox hb) {
    this.name = name;
    this.hb = hb;
  }
}
