package model;

public class teacherAttendanceTM {
private String teacherId;
private int year;
private String month;
private String date;
private String status;

    public teacherAttendanceTM() {
    }

    public teacherAttendanceTM(String teacherId, int year, String month, String date, String status) {
        this.teacherId = teacherId;
        this.year = year;
        this.month = month;
        this.date = date;
        this.status = status;
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
        return "teacherAttendanceTM{" +
                "teacherId='" + teacherId + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
