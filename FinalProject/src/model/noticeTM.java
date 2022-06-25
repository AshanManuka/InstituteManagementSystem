package model;

public class noticeTM {
private String date;
private String notice;

    public noticeTM() {
    }

    public noticeTM(String date, String notice) {
        this.date = date;
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "noticeTM{" +
                "date='" + date + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
