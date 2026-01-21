package model;

public class Order {

    private int orderId;
    private double totalPrice;
    private String orderDate;
    private String status;
    private Payment payment;

    public Order(int orderId, double totalPrice, String orderDate) {
        setOrderId(orderId);
        setTotalPrice(totalPrice);
        setOrderDate(orderDate);
        this.status = "Created";
        this.payment = null;
    }

    // ===== SETTERS WITH EXCEPTIONS (REQUIRED) =====

    public void setOrderId(int orderId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be positive");
        }
        this.orderId = orderId;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(String orderDate) {
        if (orderDate == null || orderDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Order date cannot be empty");
        }
        this.orderDate = orderDate.trim();
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Order status cannot be empty");
        }
        this.status = status.trim();
    }

    public void setPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        this.payment = payment;
        this.status = "Paid";
    }

    // ===== GETTERS =====

    public int getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Payment getPayment() {
        return payment;
    }

    // ===== BUSINESS LOGIC =====

    public boolean isPaid() {
        return payment != null && payment.isPaid();
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Total price: " + totalPrice +
                ", Date: " + orderDate +
                ", Status: " + status +
                ", Payment: " + (payment == null ? "No payment" : payment);
    }
}
