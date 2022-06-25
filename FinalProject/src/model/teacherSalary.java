package model;

public class teacherSalary {
private String teacherId;
private int year;
private String month;
private double amount;

    public teacherSalary() {
    }

    public teacherSalary(String teacherId, int year, String month, double amount) {
        this.teacherId = teacherId;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
        return "teacherSalary{" +
                "teacherId='" + teacherId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                '}';
    }
}
