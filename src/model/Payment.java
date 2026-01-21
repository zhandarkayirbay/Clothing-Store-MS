package model;

public class Payment implements Payable {

    private String method;
    private double amount;
    private boolean paid;

    public Payment(String method, double amount) {
        setMethod(method);
        setAmount(amount);
        this.paid = false;
    }

    // ===== SETTERS WITH EXCEPTIONS (REQUIRED) =====

    public void setMethod(String method) {
        if (method == null || method.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be empty");
        }
        this.method = method.trim();
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        this.amount = amount;
    }

    // ===== GETTERS =====

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    // ===== INTERFACE IMPLEMENTATION =====
    @Override
    public void pay() {
        this.paid = true;
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return "Payment method: " + method +
                ", Amount: " + amount +
                ", Paid: " + paid;
    }
}
