package model;

public class Shirt extends ClothingItem {

    private boolean longSleeve;
    private String material;

    public Shirt(String name, String size, double price, String category,
                 boolean longSleeve, String material) {
        super(name, size, price, category);
        this.longSleeve = longSleeve;
        this.material = material;
    }

    @Override
    public String getType() {
        return "Shirt";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Long sleeve: " + longSleeve +
                ", Material: " + material;
    }
}
