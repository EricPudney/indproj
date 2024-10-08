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
        this.maxSpaces = 1000;
    }

    @Override
    public boolean add(Item item) {
        if (item instanceof Stackable) {
            for (Item i : this) {
                // if a matching stackable item exists and the current stack is not full:
                if (i.getClass() == item.getClass() && ((Stackable) i).quantity < ((Stackable) i).maxQuantity) {
                    Stackable stack = ((Stackable) i);
                    int itemQuantity = ((Stackable) item).quantity;
                    // increase by the new quantity if it will fit in the stack
                    if (stack.quantity + itemQuantity <= stack.maxQuantity) {
                        stack.quantity += itemQuantity;
                        return true;
                    }
                    // or fill up the current stack and call the add function again on remaining items
                    else {
                        int difference = stack.maxQuantity - stack.quantity;
                        ((Stackable) item).quantity -= difference;
                        stack.quantity = stack.maxQuantity;
                        if (((Stackable) item).quantity > 0) {
                            return this.add(item);
                        }
                    }
                }
            }
        }
        // adds non-stackable items or starts a new stack
        if (this.size() < this.maxSpaces) {
                super.add(item);
                return true;
        }
        // returns false if the inventory is full
        return false;
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
