package model;

public class Payment implements Payable {

    private String method;
    private double amount;
    private boolean paid;

    public Payment(String method, double amount) {
        this.method = method;
        this.amount = amount;
        this.paid = false;
    }

    @Override
    public void pay() {
        this.paid = true;
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
