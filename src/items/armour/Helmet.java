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
    public void applyEffect(Character character) {
        double totalDefence = character.getDefence() + this.defence;
        character.setDefence(totalDefence);
    }

    @Override
    public void removeEffect(Character character) {
        double totalDefence = character.getDefence();
        character.setDefence(totalDefence - this.defence);
    }
}
