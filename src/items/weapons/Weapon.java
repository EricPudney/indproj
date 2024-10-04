package items.weapons;

import items.Equippable;
import items.Item;
import items.Material;
import items.Quality;


public abstract class Weapon extends Item implements Equippable {
    String name;
    Material material;
    Quality quality;
    int attack;

    public Weapon(Quality quality, Material material) {
        super();
        this.material = material;
        this.quality = quality;
        this.attack = material.attack + quality.attack;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": attack " + this.attack;
    }
}
