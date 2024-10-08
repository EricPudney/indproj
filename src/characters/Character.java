package characters;

import inventories.Inventory;
import items.armour.Helmet;
import items.weapons.Weapon;

public abstract class Character {
    public final String name;
    public Helmet equippedHelmet;
    public Weapon equippedWeapon;
    public Inventory inventory;
    int maxHealth;
    int health;
    double defence;
    int attack;
    public boolean fireproof = false;

    public Character(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
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

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getDefence() {
        return defence;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }
}
