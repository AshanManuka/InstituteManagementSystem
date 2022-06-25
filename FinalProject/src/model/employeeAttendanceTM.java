package model;

public class employeeAttendanceTM {
private String employeeID;
private int year;
private String month;
private String date;
private String status;

    public employeeAttendanceTM() {
    }

    public employeeAttendanceTM(String employeeID, int year, String month, String date, String status) {
        this.employeeID = employeeID;
        this.year = year;
        this.month = month;
        this.date = date;
        this.status = status;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "employeeAttendanceTM{" +
                "employeeID='" + employeeID + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
