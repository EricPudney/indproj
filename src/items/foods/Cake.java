package items.foods;

import characters.Character;

public class Cake extends Food {
    public Cake() {
        super("Cake", "A delicious chocolate cake!", 5);
        healthRestored = 5;
    }

    @Override
    public int getHealthRestored() {
        return super.getHealthRestored();
    }

    @Override
    public void consume(Character character) {
        if (character.inventory.remove(this)) {
            super.consume(character);
        }
        else {
            System.out.println("You don't have a cake!");
        }
    }
}
