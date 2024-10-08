package items.foods;

public class Apple extends Food implements Edible {

    public Apple() {
        super("Apple", "A beautiful crunchy apple", 2);
    }

    public Apple(int quantity) {
        super("Apple", "A beautiful crunchy apple", 2, quantity);
        healthRestored = 2;
    }
}
