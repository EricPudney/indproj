package items.foods;

import characters.Character;
import items.Item;
import items.Stackable;

public abstract class Food extends Stackable implements Item.Edible {
    int healthRestored;

    public Food(String name, String description, int price) {
        super(name, description, price);
    }


    // needed?
    public int getHealthRestored() {
        return healthRestored;
    }

    public void setHealthRestored(int healthRestored) {
        this.healthRestored = healthRestored;
    }


    public void consume(Character character) {
        int health = character.getHealth();
        health += healthRestored;
        character.setHealth(health);
    }

}
