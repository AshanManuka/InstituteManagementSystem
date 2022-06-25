package model;

public class examTM {
private String examCode;
private String date;
private double duration;
private String teacherId;
private int noStudent;

    public examTM() {
    }

    public examTM(String examCode, String date, double duration, String teacherId, int noStudent) {
        this.examCode = examCode;
        this.date = date;
        this.duration = duration;
        this.teacherId = teacherId;
        this.noStudent = noStudent;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getNoStudent() {
        return noStudent;
    }

    public void setNoStudent(int noStudent) {
        this.noStudent = noStudent;
    }

    @Override
    public String toString() {
        return "examTM{" +
                "examCode='" + examCode + '\'' +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", teacherId='" + teacherId + '\'' +
                ", noStudent=" + noStudent +
                '}';
    }
}
