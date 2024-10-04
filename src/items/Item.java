package items;

import characters.Character;

public abstract class Item {
    String name;
    String description;
    int price;

    public Item() {}


    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public  interface Edible {
        default void consume(Character character) {
            int health = character.getHealth();
            health += getHealthRestored();
            character.setHealth(health);
        }

        int getHealthRestored();
    }
}
