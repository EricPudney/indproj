package items.foods;

import characters.Character;

public interface Edible {
    default void consume(Character character) {
        int health = character.getHealth();
        health += getHealthRestored();
        character.setHealth(health);
    }

    int getHealthRestored();
}
