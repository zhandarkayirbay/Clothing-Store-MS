package model;

public class Shirt extends ClothingItem {

    // =================================================
    // ================= FIELDS ========================
    // =================================================

    private boolean longSleeve;
    private String material;

    // =================================================
    // ================= CONSTRUCTORS ==================
    // =================================================

    // OLD CONSTRUCTOR (Week 7 – unchanged, safe)
    public Shirt(String name, String size, double price,
                 boolean longSleeve, String material) {
        super(name, size, price);
        setLongSleeve(longSleeve);
        setMaterial(material);
    }

    // NEW CONSTRUCTOR (Week 8 – database support)
    public Shirt(String name, String size, double price,
                 boolean longSleeve, String material, int quantity) {
        super(name, size, price, quantity);
        setLongSleeve(longSleeve);
        setMaterial(material);
    }

    // =================================================
    // ================= ABSTRACT ======================
    // =================================================

    @Override
    public String getType() {
        return "Shirt";
    }

    // =================================================
    // ================= SETTERS =======================
    // =================================================

    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material cannot be empty");
        }
        this.material = material;
    }

    // =================================================
    // ================= GETTERS =======================
    // =================================================

    public boolean isLongSleeve() {
        return longSleeve;
    }

    public String getMaterial() {
        return material;
    }

    // =================================================
    // ================= COMMON ========================
    // =================================================

    @Override
    public String toString() {
        return super.toString() +
                ", Long sleeve: " + longSleeve +
                ", Material: " + material;
    }
}
