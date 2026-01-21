package model;

public abstract class ClothingItem {

    protected String name;
    protected String size;
    protected double price;

    public ClothingItem(String name, String size, double price) {
        setName(name);
        setSize(size);
        setPrice(price);
    }

    // ABSTRACT METHOD (REQUIRED)
    public abstract String getType();

    // ===== SETTERS WITH EXCEPTIONS =====

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        this.name = name;
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty");
        }
        this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    // ===== GETTERS =====

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // ===== COMMON METHOD =====
    @Override
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Type: " + getType();
    }
}
