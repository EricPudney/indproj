package items.foods;

public class Cake extends Food {
    public Cake() {
        super("Cake", "A delicious chocolate cake!", 5);
        healthRestored = 5;
        maxQuantity = 5;
    }
    public Cake(int quantity) {
        super("Cake", "A delicious chocolate cake!", quantity);
    }
}
