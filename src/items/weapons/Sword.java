package items.weapons;

import characters.Character;
import items.Material;
import items.Quality;

public class Sword extends Weapon {
    public Sword(Quality quality, Material material) {
        super(quality, material);
        // Swords get a +2 damage boost...other weapons could have other special effects
        this.attack += 2;
        this.name = quality.name().toLowerCase() + " " + material.name().toLowerCase() + " sword";
    }

    @Override
    public void applyEffect(Character character) {
        int totalAttack = character.getAttack() + this.attack;
        character.setAttack(totalAttack);
    }

    @Override
    public void removeEffect(Character character) {
        int currentAttack = character.getAttack();
        character.setAttack(currentAttack - this.attack);
    }
}
