public class Jacket extends ClothingItem {

    private boolean waterproof;

    public Jacket(String name, String size, double price, String category, boolean waterproof) {
        super(name, size, price, category);
        this.waterproof = waterproof;
    }

    @Override
    public String toString() {
        return super.toString() + ", Waterproof: " + waterproof;
    }
}
