package model;

public class employeeSalary {
private String employeeId;
private int year;
private String month;
private double amount;

    public employeeSalary() {
    }

    public employeeSalary(String employeeId, int year, String month, double amount) {
        this.employeeId = employeeId;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
        return "employeeSalary{" +
                "employeeId='" + employeeId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                '}';
    }
}
