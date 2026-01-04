public class Shirt extends ClothingItem {

    private boolean longSleeve;

    public Shirt(String name, String size, double price, String category, boolean longSleeve) {
        super(name, size, price, category);
        this.longSleeve = longSleeve;
    }

    public boolean isLongSleeve() {
        return longSleeve;
    }

    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Long sleeve: " + longSleeve;
    }
}
