public class Customer {

    // Клиенттің аты
    private String name;

    // Телефон нөмірі
    private String phone;

    // Бонус ұпайы
    private int points;

    // Конструктор
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.points = 0; // бастапқыда 0
    }

    // бонус қосу
    public void addPoints(int amount) {
        points = points + amount;
    }

    // Экранға шығару
    public String toString() {
        return "Customer name: " + name +
                ", Phone: " + phone +
                ", Points: " + points;
    }
}
