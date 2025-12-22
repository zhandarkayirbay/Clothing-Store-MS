public class ClothingItem {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    public boolean isExpensive() {
        return price > 15000;
    }


    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Category: " + category;
    }
}
