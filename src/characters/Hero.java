package characters;

import inventories.Inventory;
import items.Equippable;
import items.Item;
import items.armour.Helmet;
import items.foods.Edible;
import items.weapons.Weapon;

public class Hero extends Character {

    public Hero(String name) {
        super(name);
        maxHealth = 100;
        health = 96;
        this.inventory = new Inventory(30);
    }

    public boolean equip(Item item) {
        if (!(item instanceof Equippable)) {
            System.out.println("That item cannot be equipped!");
            return false;
        }
        // 1 weapon, 4 armour, 1 bag, up to 2 magic items?
        else if (equippedItems.size() >= 8) {
            System.out.println("You can't equip any more items!");
            return false;
        }
        else {
            for (Equippable i : equippedItems) {
                if (i.getClass() == item.getClass() || (i instanceof Weapon && item instanceof Weapon)) {
                    System.out.printf("You already have a %s equipped!\n", item.getClass().getSimpleName().toLowerCase());
                    return false;
                }
            }
            this.inventory.remove(item);
            equippedItems.add((Equippable) item);
            ((Equippable) item).applyEffect(this);
            System.out.println("Equipped " + item);
            return true;
        }
    }

    public boolean unEquip(Equippable item) {
        if (!equippedItems.contains(item)) {
            System.out.println("That item is not equipped!");
        }
        else {
            if (equippedItems.remove(item) && inventory.add((Item) item)) {
                item.removeEffect(this);
                System.out.println("Unequipped " + item + " successfully!");
                return true;
            }
            System.out.println("Unable to unequip item! Is your inventory full?");
        }
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


    public String toString() {
        String armourString = "";
        String weaponString = "";
        for (Equippable i : equippedItems) {
            if (i instanceof Helmet) {
                armourString = "wearing " + i;
            }
            if (i instanceof Weapon) {
                weaponString = "wielding " + i;
            }
        }

        return "Hero: " + name + " " + armourString + " " + weaponString + " is carrying: \n" + inventory.toString() + "\nHealth: " + getHealth();
    }
}
