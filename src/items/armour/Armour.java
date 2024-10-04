package items.armour;

import items.Equippable;
import items.Item;
import items.Material;
import items.Quality;


public abstract class Armour extends Item implements Equippable {
    String name;
    Material material;
    Quality quality;
    int defence;

    public Armour(Quality quality, Material material) {
        super();
        this.material = material;
        this.quality = quality;
        this.defence = material.defence + quality.defence;
    }

    public String toString() {
        return this.name + ": defence " + this.defence;
    }

    public String getName() {
        return this.name;
    }
}
