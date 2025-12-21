public class Order {

    // Тапсырыс нөмірі
    private int orderId;

    // Жалпы сумма
    private double totalPrice;

    // Конструктор
    public Order(int orderId, double totalPrice) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }

    // Экранға шығару
    public String toString() {
        return "Order ID: " + orderId +
                ", Total price: " + totalPrice;
    }
}
