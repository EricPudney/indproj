package items;

public abstract class Stackable extends Item {
    public int quantity;
    public int maxQuantity;

    public Stackable(String name, String description, int price) {
        super(name, description, price);
        this.quantity = 1;
    }
    public Stackable(String name, String description, int price, int quantity, int maxQuantity) {
        super(name, description, price);
        this.maxQuantity = maxQuantity;
        if (quantity > 0 && quantity <= maxQuantity) {
            this.quantity = quantity;
        }
        else {
            throw new IllegalArgumentException(String.format("You can only put %d %ss in a stack. Use a loop instead!", maxQuantity, name));
        }
    }
}
