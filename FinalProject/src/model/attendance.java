package model;

public class attendance {
private int year;
private String month;
private String date;
private String aId;
private String status;

    public attendance() {
    }

    public attendance(int year, String month, String date, String aId, String status) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.aId = aId;
        this.status = status;
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

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "attendance{" +
                "year=" + year +
                ", month='" + month + '\'' +
                ", date='" + date + '\'' +
                ", aId='" + aId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
