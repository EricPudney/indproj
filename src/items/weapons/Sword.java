package items.weapons;

import characters.Character;
import items.Material;
import items.Quality;

public class Sword extends Weapon {
    public Sword(Quality quality, Material material) {
        super(quality, material);
        // Swords get a +2 damage boost...other weapons can have other effects
        this.attack += 2;
        this.name = quality.name().toLowerCase() + " " + material.name().toLowerCase() + " sword";
    }

    @Override
    public boolean equip(Character character) {
        if (character.equippedWeapon == null) {
            character.inventory.remove(this);
            character.equippedWeapon = this;
            return true;
        }
        else {
            System.out.println("You already have a weapon!");
            return false;
        }
    }

    @Override
    public boolean unEquip(Character character) {
        if (character.equippedWeapon == this) {
            if (character.inventory.add(this)) {
                character.equippedHelmet = null;
                return true;
            }
            else {
                System.out.println("Unable to remove sword. Is your inventory full?");
                return false;
            }
        }
        else {
            System.out.println("You're don't have a sword equipped!");
            return false;
        }
    }
}
