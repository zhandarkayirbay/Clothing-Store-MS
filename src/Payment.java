public class Payment {

    private String method;
    private double amount;
    private boolean paid;

    public Payment(String method, double amount) {
        this.method = method;
        this.amount = amount;
        this.paid = true;
    }

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Payment method: " + method +
                ", Amount: " + amount +
                ", Paid: " + paid;
    }
}
