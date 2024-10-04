package characters;

import inventories.Inventory;
import items.armour.Helmet;
import items.weapons.Weapon;

public abstract class Character {
    public String name;
    public Helmet equippedHelmet;
    public Weapon equippedWeapon;
    public Inventory inventory;
    int health;

    public Character(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Object getName() {
        return name;
    }
}
