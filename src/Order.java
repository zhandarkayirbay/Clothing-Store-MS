public class Order {

    private int orderId;
    private double totalPrice;
    private String orderDate;
    private String status;

    public Order(int orderId, double totalPrice, String orderDate, String status) {
        setOrderId(orderId);
        setTotalPrice(totalPrice);
        setOrderDate(orderDate);
        setStatus(status);
    }

    // ===== Getters =====
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

    // ===== Setters with validation =====
    public void setOrderId(int orderId) {
        if (orderId <= 0) {
            return;
        }
        this.orderId = orderId;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice <= 0) {
            return;
        }
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(String orderDate) {
        if (orderDate == null || orderDate.trim().isEmpty()) {
            return;
        }
        this.orderDate = orderDate.trim();
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            return;
        }
        this.status = status.trim();
    }

    // ===== Additional methods =====
    public void applyBonusDiscount(double bonus) {
        if (bonus > 0 && bonus < totalPrice) {
            totalPrice -= bonus;
        }
    }

    public boolean isCompleted() {
        return "Completed".equalsIgnoreCase(status);
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Total price: " + totalPrice +
                ", Date: " + orderDate +
                ", Status: " + status;
    }
}
