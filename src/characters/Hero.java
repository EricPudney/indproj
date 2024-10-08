package characters;

import dungeon.Location;
import inventories.Inventory;
import items.Equippable;
import items.Item;
import items.Stackable;
import items.armour.Helmet;
import items.foods.Edible;
import items.weapons.Weapon;

public class Hero extends Character {

    public Hero(String name) {
        super(name);
        maxHealth = 100;
        health = 100;
        this.inventory = new Inventory(30);
    }

    public boolean equip(Item item) {
        if (!(item instanceof Equippable)) {
            System.out.println("That item cannot be equipped!");
            return false;
        }
        if (item instanceof Helmet && equippedHelmet == null) {
            this.inventory.remove(item);
            equippedHelmet = (Helmet) item;
            return true;
        }
        if (item instanceof Weapon && equippedWeapon == null) {
            this.inventory.remove(item);
            equippedWeapon = (Weapon) item;
            return true;
        }
        System.out.println("You already have an item equipped in that slot!");
        return false;
    }

    public boolean unEquip(Equippable item) {
        if (item instanceof Helmet && equippedHelmet == item) {
            if (inventory.add((Item) item)) {
                equippedHelmet = null;
                return true;
            }
            else {
                System.out.println("You don't have enough space in your inventory!");
            }
        }
        if (item instanceof Weapon && equippedWeapon == item) {
            if (inventory.add((Item) item)) {
                equippedWeapon = null;
                return true;
            }
            else {
                System.out.println("You don't have enough space in your inventory!");
            }
        }
        System.out.println("You don't have anything equipped there!");
        return false;
    }

    public boolean eat(Item item) {
        if (!(item instanceof Edible)) {
            System.out.printf("You cannot eat the %s!\n", item.getName());
            return false;
        }
        else{
            ((Edible) item).consume(this);
            return true;
        }
    }

    public void dropItem(Item item, Location location) {
        if (item instanceof Stackable) {
            boolean dropped = false;
            int quantity = 0;
            for (int i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i) instanceof Stackable droppedItem && item.getClass() == droppedItem.getClass()) {
                    quantity = droppedItem.quantity;
                    this.inventory.remove(droppedItem);
                    location.inventory.add(droppedItem);
                    dropped = true;
                    break;
                }
            }
            if (!dropped) {
                System.out.println("You don't have that item!");
            }
            else {
                System.out.printf("Dropped %s x %d\n", item.getName(), quantity);
            }
        }
        else if (this.inventory.remove(item)) {
            location.inventory.add(item);
        }
        else {
            System.out.println("You don't have that item!");
        }
    }


    public String toString() {
        String armourString = "";
        String weaponString = "";
        if (equippedHelmet != null) {
            armourString = "wearing " + equippedHelmet;
        }
        if (equippedWeapon != null) {
            weaponString = "wielding " + equippedWeapon;
        }
        return "Hero: " + name + armourString + " " + weaponString + " is carrying: \n" + inventory.toString() + "\nHealth: " + getHealth();
    }
}
