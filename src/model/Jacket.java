package model;

public class Jacket extends ClothingItem {

    // =================================================
    // ================= FIELDS ========================
    // =================================================

    private boolean waterproof;
    private String season;

    // =================================================
    // ================= CONSTRUCTORS ==================
    // =================================================

    // OLD CONSTRUCTOR (Week 7 – unchanged, safe)
    public Jacket(String name, String size, double price,
                  boolean waterproof, String season) {
        super(name, size, price);
        setWaterproof(waterproof);
        setSeason(season);
    }

    // OPTIONAL NEW CONSTRUCTOR (Week 8 – database ready)
    public Jacket(String name, String size, double price,
                  boolean waterproof, String season, int quantity) {
        super(name, size, price, quantity);
        setWaterproof(waterproof);
        setSeason(season);
    }

    // =================================================
    // ================= ABSTRACT ======================
    // =================================================

    @Override
    public String getType() {
        return "Jacket";
    }

    // =================================================
    // ================= SETTERS =======================
    // =================================================

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public void setSeason(String season) {
        if (season == null || season.trim().isEmpty()) {
            throw new IllegalArgumentException("Season cannot be empty");
        }
        this.season = season;
    }

    // =================================================
    // ================= GETTERS =======================
    // =================================================

    public boolean isWaterproof() {
        return waterproof;
    }

    public String getSeason() {
        return season;
    }

    // =================================================
    // ================= COMMON ========================
    // =================================================

    @Override
    public String toString() {
        return super.toString() +
                ", Waterproof: " + waterproof +
                ", Season: " + season;
    }
}
