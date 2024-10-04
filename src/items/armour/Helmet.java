package items.armour;

import characters.Character;
import items.Material;
import items.Quality;

public class Helmet extends Armour {

    public Helmet(Quality quality, Material material) {
        super(quality, material);
        this.name = quality.name().toLowerCase() + " " + material.name().toLowerCase() + " helmet";
    }

    @Override
    public boolean equip(Character character) {
        if (character.equippedHelmet == null) {
            character.inventory.remove(this);
            character.equippedHelmet = this;
            return true;
        }
        else {
            System.out.println("You're already wearing a helmet!");
            return false;
        }
    }

    @Override
    public boolean unEquip(Character character) {
        if (character.equippedHelmet == this) {
            if (character.inventory.add(this)) {
                character.equippedHelmet = null;
                return true;
            }
            else {
                System.out.println("Unable to remove helmet. Is your inventory full?");
                return false;
            }
        }
        else {
            System.out.println("You're not wearing a helmet!");
            return false;
        }
    }
}
