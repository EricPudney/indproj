package characters;

import inventories.Inventory;

public class Enemy extends Character {
    public Enemy(String name) {
        super(name);
        inventory = new Inventory();
    }

    @Override
    public String toString() {
        return "The " + name + " has the following items: " + this.inventory.toString();
    }
}
