package items.foods;

public class Apple extends Food {

    public Apple() {
        super("Apple", "A beautiful crunchy apple", 2);
        healthRestored = 2;
    }

    public Apple(int quantity) {
        super("Apple", "A beautiful crunchy apple", 2, quantity, 10);
        healthRestored = 2;
    }
}
