package model;

public class payment {
private String personId;
private String year;
private String month;
private String budgetCode;
private double amount;

    public payment() {
    }

    public payment(String personId, String year, String month, String budgetCode, double amount) {
        this.personId = personId;
        this.year = year;
        this.month = month;
        this.budgetCode = budgetCode;
        this.amount = amount;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "payment{" +
                "personId='" + personId + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", budgetCode='" + budgetCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}
