package dungeons;

import characters.Enemy;
import inventories.Inventory;
import items.Item;
import main.RandomGeneration;

import static main.Main.rand;

public class Location {
    public Enemy enemy = null;
    String description;
    public final Inventory inventory = new Inventory();

    public Location() {
    // location contains either enemy with an item, or item, or (usually) nothing
        double probability = rand.nextDouble();
        if (probability > 0.92) {
            this.enemy = new Enemy("Goblin");
            this.enemy.inventory.add(RandomGeneration.generateRandomItem());
        } else if (probability < 0.08) {
            Item item = RandomGeneration.generateRandomItem();
            this.inventory.add(item);
        }
        Descriptions[] descriptions = Descriptions.values();
        this.description = String.valueOf(descriptions[(rand.nextInt(descriptions.length))].text);
    }

    public String toString() {
        if (enemy != null) {
            String text = String.format("You have encountered a monster! A %s stand before you.", enemy.getName());
            return description + text;
        }
        else if (!inventory.isEmpty()) {
            String text = String.format("You have found the following item(s): \n %s", this.inventory);
            return description + text;
        }
        return description;
    }
}