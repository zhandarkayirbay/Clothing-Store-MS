public class Order {

    private int orderId;
    private double totalPrice;
    private String orderDate;
    private String status;
    private Payment payment;

    public Order(int orderId, double totalPrice, String orderDate) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = "Created";
        this.payment = null;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        this.status = "Paid";
    }

    public boolean isPaid() {
        return payment != null && payment.isPaid();
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Total price: " + totalPrice +
                ", Date: " + orderDate +
                ", Status: " + status +
                ", Payment: " + (payment == null ? "No payment" : payment);
    }
}
