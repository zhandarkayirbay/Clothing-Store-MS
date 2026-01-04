public class Jacket extends ClothingItem {

    private boolean waterproof;
    private String season;

    public Jacket(String name, String size, double price, String category,
                  boolean waterproof, String season) {

        super(name, size, price, category);
        setWaterproof(waterproof);
        setSeason(season);
    }

    // ===== Getters =====
    public boolean isWaterproof() {
        return waterproof;
    }

    public String getSeason() {
        return season;
    }

    // ===== Setters with validation =====
    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public void setSeason(String season) {
        if (season == null || season.trim().isEmpty()) {
            return;
        }
        this.season = season.trim();
    }

    // ===== toString =====
    @Override
    public String toString() {
        return super.toString() +
                ", Waterproof: " + waterproof +
                ", Season: " + season;
    }
}
