public class Customer {

    private String name;
    private String phone;
    private int points;
    private String email;

    public Customer(String name, String phone, String email) {
        setName(name);
        setPhone(phone);
        setEmail(email);
        this.points = 0;
    }

    // ===== Getters =====
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPoints() {
        return points;
    }

    public String getEmail() {
        return email;
    }

    // ===== Setters with validation =====
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        this.name = name.trim();
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return;
        }
        this.phone = phone.trim();
    }

    public void setPoints(int points) {
        if (points < 0) {
            return;
        }
        this.points = points;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return;
        }
        this.email = email.trim();
    }

    // ===== Additional methods =====
    public void addPoints(int amount) {
        if (amount > 0) {
            points += amount;
        }
    }

    public boolean hasEnoughPoints(int amount) {
        return points >= amount;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Customer name: " + name +
                ", Phone: " + phone +
                ", Email: " + email +
                ", Points: " + points;
    }
}
