package model;

public class studentPayment {
private String studentId ;
private int year;
private String month;
private double fee;

    public studentPayment() {
    }

    public studentPayment(String studentId, int year, String month, double fee) {
        this.studentId = studentId;
        this.year = year;
        this.month = month;
        this.fee = fee;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "studentPayment{" +
                "studentId='" + studentId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", fee=" + fee +
                '}';
    }
}
