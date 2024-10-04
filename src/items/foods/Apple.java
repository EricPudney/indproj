package items.foods;

import characters.Character;
import items.Item;

public class Apple extends Food implements Item.Edible {

    public Apple() {
        super("Apple", "A delicious crunchy apple", 2);
        healthRestored = 2;
    }

    @Override
    public int getHealthRestored() {
        return super.getHealthRestored();
    }

    @Override
    public void consume(Character character) {
        if (this.quantity > 1) {
            this.quantity -= 1;
            super.consume(character);
            return;
        }
        if (this.quantity == 1 && character.inventory.remove(this)) {
            super.consume(character);
        }
        else {
            System.out.println("You don't have an apple!");
        }
    }
}
