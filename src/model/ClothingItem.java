package model;

public abstract class ClothingItem {

    protected String name;
    protected String size;
    protected double price;
    protected String category;

    public ClothingItem(String name, String size, double price, String category) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Category: " + category;
    }
}
