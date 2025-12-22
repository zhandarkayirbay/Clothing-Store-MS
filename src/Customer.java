public class Customer {

    private String name;
    private String phone;
    private int points;
    private String email;

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.points = 0;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addPoints(int amount) {
        points += amount;
    }

    public boolean hasEnoughPoints(int amount) {
        return points >= amount;
    }


    public String toString() {
        return "Customer name: " + name +
                ", Phone: " + phone +
                ", Email: " + email +
                ", Points: " + points;
    }
}
