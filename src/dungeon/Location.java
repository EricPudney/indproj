package dungeon;

import characters.Enemy;
import inventories.Inventory;
import items.Item;
import main.RandomGeneration;

import static main.Main.rand;

public class Location {
    Enemy enemy = null;
    String description;
    Inventory inventory = new Inventory();

    public Location() {
    // either enemy or item or neither, but not both
        if (rand.nextDouble() > 0.92) {
        this.enemy = new Enemy("Hobgoblin");
    }
    else //if (rand.nextDouble() > 0.92)
    {
        for (int i = 0; i < 5; i++) {
        Item item = RandomGeneration.generateRandomItem();
        this.inventory.add(item);
    }

    }
    Descriptions[] descriptions = Descriptions.values();
    this.description = String.valueOf(descriptions[(rand.nextInt(descriptions.length))].text);
    }

    public String toString() {
        if (enemy != null) {
            String text = String.format("You have encountered a monster! A %s stand before you.", enemy.getName());
            description = description + text;
        }
        else if (!inventory.isEmpty()) {
            String text = String.format("You have found the following item(s): \n %s", this.inventory);
            description = description + text;
        }
        return description;
    }
}