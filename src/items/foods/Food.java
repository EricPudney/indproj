package items.foods;

import characters.Character;
import items.Stackable;

import static java.lang.Math.min;

public abstract class Food extends Stackable implements Edible {
    int healthRestored;

    public Food(String name, String description, int price, int maxQuantity) {
        super(name, description, price, maxQuantity);
        quantity = 1;
    }

    public Food(String name, String description, int price, int quantity, int maxQuantity) {
        super(name, description, price, quantity, maxQuantity);
    }

    public void consume(Character character) {
        int health = character.getHealth();
        health += healthRestored;
        int maxHealth = character.getMaxHealth();
        if (this.quantity > 1) {
            this.quantity -= 1;
            character.setHealth(min(health, maxHealth));
            System.out.printf("Ate one %s, %d left in stack\n", this.getName().toLowerCase(), this.quantity);
        }
        else if (this.quantity == 1 && character.inventory.remove(this)) {
            character.setHealth(min(health, maxHealth));
            System.out.printf("Ate last %s in stack\n", this.getName().toLowerCase());
        }
        else {
            System.out.printf("You don't have any %ss left!\n", this.getName().toLowerCase());
        }
    }

    public String toString() {
        return this.getName() + ": " + this.description;
    }
}
