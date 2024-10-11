package characters;

import java.util.ArrayList;

import dungeons.Location;
import inventories.Inventory;
import items.Equippable;
import items.Item;
import items.Stackable;

public abstract class Character {
    public final String name;
    ArrayList<Equippable> equippedItems = new ArrayList<>();
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
                System.out.printf("%s doesn't have that item!\n", this.name);
            }
            else {
                System.out.printf("%s dropped %s x %d\n", this.name, item.getName(), quantity);
            }
        }
        else if (this.inventory.remove(item)) {
            System.out.printf("%s dropped %s\n", this.name, item.getName());
            location.inventory.add(item);
        }
        else {
            System.out.printf("%s doesn't have that item!\n", this.name);
        }
    }
}
