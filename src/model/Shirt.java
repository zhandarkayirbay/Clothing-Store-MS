package model;

public class Shirt extends ClothingItem {

    private boolean longSleeve;
    private String material;

    public Shirt(String name, String size, double price,
                 boolean longSleeve, String material) {
        super(name, size, price);
        setLongSleeve(longSleeve);
        setMaterial(material);
    }

    // IMPLEMENT ABSTRACT METHOD
    @Override
    public String getType() {
        return "Shirt";
    }

    // ===== SETTERS WITH EXCEPTIONS =====

    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material cannot be empty");
        }
        this.material = material;
    }

    // ===== GETTERS =====

    public boolean isLongSleeve() {
        return longSleeve;
    }

    public String getMaterial() {
        return material;
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return super.toString() +
                ", Long sleeve: " + longSleeve +
                ", Material: " + material;
    }
}
