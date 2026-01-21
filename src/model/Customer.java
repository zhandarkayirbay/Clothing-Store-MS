package model;

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

    // ===== GETTERS =====
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

    // ===== SETTERS WITH EXCEPTIONS (REQUIRED) =====
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phone = phone.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email.trim();
    }

    public void setPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
        this.points = points;
    }

    // ===== BUSINESS METHODS =====
    public void addPoints(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Points to add must be positive");
        }
        this.points += amount;
    }

    public boolean hasEnoughPoints(int amount) {
        return points >= amount;
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return "Customer name: " + name +
                ", Phone: " + phone +
                ", Email: " + email +
                ", Points: " + points;
    }
}
