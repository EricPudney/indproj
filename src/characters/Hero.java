package characters;

import inventories.Inventory;

public class Hero extends Character {

    public Hero(String name) {
        super(name);
        health = 100;
        this.inventory = new Inventory(30);
    }



    public String toString() {
        return "Hero: " + name + ", wearing " + equippedHelmet + " and wielding a " + equippedWeapon + ", and carrying " + inventory.toString() + "\nHealth: " + getHealth();
    }
}
