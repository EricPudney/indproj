package items.weapons;

import characters.Enemy;
import items.Material;
import items.Quality;

public class FireSword extends Sword implements MagicalWeapon {
    int bonusDamage = 2;

    public FireSword(Quality quality, Material material) {
        super(quality, material);
        this.name = quality.name().toLowerCase() + " " + material.name().toLowerCase() + " magical fire sword";
    }

    @Override
    public int magicEffect(Enemy enemy) {
        if (enemy.fireproof) {
            return 0;
        }
        else{
            return bonusDamage;
        }
    }
}
