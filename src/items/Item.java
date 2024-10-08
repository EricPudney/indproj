package items;

public abstract class Item {
    String name;
    String description;
    int price;

    public Item() {}


    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

}
