public abstract class ClothingItem {

    private String name;
    private String size;
    private double price;
    private String category;

    public ClothingItem(String name, String size, double price, String category) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
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

    // ===== Setters =====
    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setSize(String size) {
        if (!size.trim().isEmpty()) {
            this.size = size;
        }
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setCategory(String category) {
        if (!category.trim().isEmpty()) {
            this.category = category;
        }
    }

    // ===== ABSTRACT METHOD (NEW) =====
    public abstract String getItemType();

    @Override
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Category: " + category;
    }
}
