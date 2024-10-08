package items.foods;

public class Apple extends Food implements Edible {

    public Apple() {
        super("Apple", "A beautiful crunchy apple", 2);
        healthRestored = 2;
        maxQuantity = 10;
    }
}
