package model;

public class studentAttendanceTM {
private String studentId;
private int year;
private String month;
private String date;
private String status;

    public studentAttendanceTM() {
    }

    public studentAttendanceTM(String studentId, int year, String month, String date, String status) {
        this.studentId = studentId;
        this.year = year;
        this.month = month;
        this.date = date;
        this.status = status;
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
        return "studentAttendanceTM{" +
                "studentId='" + studentId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
