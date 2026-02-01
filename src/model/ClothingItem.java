package model;

public abstract class ClothingItem {

    // =================================================
    // ================= FIELDS ========================
    // =================================================

    protected String name;
    protected String size;
    protected double price;
    protected int quantity;   // Week 8 (DB support)

    // =================================================
    // ================= CONSTRUCTORS ==================
    // =================================================

    // OLD CONSTRUCTOR (Week 7 – unchanged, safe)
    public ClothingItem(String name, String size, double price) {
        setName(name);
        setSize(size);
        setPrice(price);
        this.quantity = 0; // default value, old code not broken
    }

    // NEW CONSTRUCTOR (Week 8 – database)
    public ClothingItem(String name, String size, double price, int quantity) {
        setName(name);
        setSize(size);
        setPrice(price);
        setQuantity(quantity);
    }

    // =================================================
    // ================= ABSTRACT ======================
    // =================================================

    public abstract String getType();

    // =================================================
    // ================= SETTERS =======================
    // =================================================

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

    // Week 8
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    // =================================================
    // ================= GETTERS =======================
    // =================================================

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Week 8
    public int getQuantity() {
        return quantity;
    }

    // =================================================
    // ================= COMMON ========================
    // =================================================

    @Override
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Quantity: " + quantity +
                ", Type: " + getType();
    }
}
