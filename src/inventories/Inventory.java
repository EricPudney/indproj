package inventories;

import items.Item;
import items.Stackable;

import java.util.ArrayList;

public class Inventory extends ArrayList<Item> {
    int maxSpaces;

    public Inventory(int maxSpaces) {
        this.maxSpaces = maxSpaces;
    }

    public Inventory() {
        this.maxSpaces = 10;
    }

    @Override
    public boolean add(Item item) {
        if (item instanceof Stackable) {
            for (Item i : this) {
                if (i.getClass() == item.getClass()) {
                    ((Stackable) i).quantity += 1;
                    return true;
                }
            }
        }
        if (this.size() < this.maxSpaces) {
            super.add(item);
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        String result = "";
        for (Item item : this) {
            if (item instanceof Stackable) {
                result = result.concat(item.getName() + " x " + ((Stackable) item).quantity + "\n");
            }
            else {
                result = result.concat(item.getName() + "\n");
                }
        }
        if (result.isEmpty()) {
            result = "nothing.";
        }
        return result;
    }
}
