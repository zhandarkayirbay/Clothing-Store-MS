public class ClothingItem {

    private String name;
    private String size;
    private double price;
    private String category;

    public ClothingItem(String name, String size, double price, String category) {
        setName(name);
        setSize(size);
        setPrice(price);
        setCategory(category);
    }

    // ===== Getters =====
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // ===== Setters with validation =====
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        this.name = name.trim();
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            return;
        }
        this.size = size.trim();
    }

    public void setPrice(double price) {
        if (price <= 0) {
            return;
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            return;
        }
        this.category = category.trim();
    }

    // ===== Additional methods =====
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            price = price - (price * percent / 100);
        }
    }

    public boolean isExpensive() {
        return price > 15000;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Category: " + category;
    }
}
