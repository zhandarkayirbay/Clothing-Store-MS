public class Shirt extends ClothingItem {

    private boolean longSleeve;
    private String material;

    public Shirt(String name, String size, double price, String category,
                 boolean longSleeve, String material) {

        super(name, size, price, category);
        setLongSleeve(longSleeve);
        setMaterial(material);
    }

    // ===== Getters =====
    public boolean isLongSleeve() {
        return longSleeve;
    }

    public String getMaterial() {
        return material;
    }

    // ===== Setters with validation =====
    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            return;
        }
        this.material = material.trim();
    }

    // ===== toString =====
    @Override
    public String toString() {
        return super.toString() +
                ", Long sleeve: " + longSleeve +
                ", Material: " + material;
    }
}
