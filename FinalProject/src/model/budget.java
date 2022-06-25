package model;

public class budget {
private String description;
private String type;
private int year;
private String month;
private double amount;

    public budget() {
    }

    public budget(String description, String type, int year, String month, double amount) {
        this.description = description;
        this.type = type;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "budget{" +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                '}';
    }
}
