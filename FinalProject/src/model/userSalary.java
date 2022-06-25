package model;

public class userSalary {
private String userId;
private int year;
private String month;
private double amount;

    public userSalary() {
    }

    public userSalary(String userId, int year, String month, double amount) {
        this.userId = userId;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "userSalary{" +
                "userId='" + userId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                '}';
    }
}
