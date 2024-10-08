package items;

public abstract class Stackable extends Item {
    public int quantity = 1;
    // default max size for stack is 10 but can vary in subclasses
    public int maxQuantity = 10;
    public Stackable(String name, String description, int price) {
        super(name, description, price);
    }
    public Stackable(String name, String description, int price, int quantity) {
        super(name, description, price);
        if (quantity > 0 && quantity <= maxQuantity) {
            this.quantity = quantity;
        }
        else {
            throw new IllegalArgumentException(String.format("You can only put %d %ss in a stack. Use a loop instead!", maxQuantity, name));
        }
    }
}
