package items;

public abstract class Stackable extends Item {
    public int quantity = 1;
    public Stackable(String name, String description, int price) {
        super(name, description, price);
    }
}
