package model;

public class Jacket extends ClothingItem {

    private boolean waterproof;
    private String season;

    public Jacket(String name, String size, double price,
                  boolean waterproof, String season) {
        super(name, size, price);
        setWaterproof(waterproof);
        setSeason(season);
    }

    // IMPLEMENT ABSTRACT METHOD
    @Override
    public String getType() {
        return "Jacket";
    }

    // ===== SETTERS WITH EXCEPTIONS =====

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public void setSeason(String season) {
        if (season == null || season.trim().isEmpty()) {
            throw new IllegalArgumentException("Season cannot be empty");
        }
        this.season = season;
    }

    // ===== GETTERS =====

    public boolean isWaterproof() {
        return waterproof;
    }

    public String getSeason() {
        return season;
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return super.toString() +
                ", Waterproof: " + waterproof +
                ", Season: " + season;
    }
}
