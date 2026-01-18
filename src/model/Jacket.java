package model;

public class Jacket extends ClothingItem {

    private boolean waterproof;
    private String season;

    public Jacket(String name, String size, double price, String category,
                  boolean waterproof, String season) {
        super(name, size, price, category);
        this.waterproof = waterproof;
        this.season = season;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Waterproof: " + waterproof +
                ", Season: " + season;
    }
}
