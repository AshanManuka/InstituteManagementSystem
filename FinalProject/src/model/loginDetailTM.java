package model;

public class loginDetailTM {
private String userId;
private String date;
private String time;

    public loginDetailTM() {
    }

    public loginDetailTM(String userId, String date, String time) {
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "loginDetailTM{" +
                "userId='" + userId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
