public class Order {

    private int orderId;
    private double totalPrice;
    private String orderDate;
    private String status;

    public Order(int orderId, double totalPrice, String orderDate, String status) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
    }

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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void applyBonusDiscount(double bonus) {
        totalPrice -= bonus;
    }

    public boolean isCompleted() {
        return status.equals("Completed");
    }


    public String toString() {
        return "Order ID: " + orderId +
                ", Total price: " + totalPrice +
                ", Date: " + orderDate +
                ", Status: " + status;
    }
}
