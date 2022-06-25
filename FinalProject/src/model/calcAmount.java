package model;

public class calcAmount {
private double payment;

    public calcAmount() {
    }

    public calcAmount(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "calcAmount{" +
                "payment=" + payment +
                '}';
    }
}
