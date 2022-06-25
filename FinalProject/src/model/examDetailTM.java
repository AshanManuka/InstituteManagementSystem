package model;

public class examDetailTM {
private String eCode;
private String eDate;
private double eDuration;
private int eStudent;
private String tId;

    public examDetailTM() {
    }

    public examDetailTM(String eCode, String eDate, double eDuration, int eStudent, String tId) {
        this.eCode = eCode;
        this.eDate = eDate;
        this.eDuration = eDuration;
        this.eStudent = eStudent;
        this.tId = tId;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public double geteDuration() {
        return eDuration;
    }

    public void seteDuration(double eDuration) {
        this.eDuration = eDuration;
    }

    public int geteStudent() {
        return eStudent;
    }

    public void seteStudent(int eStudent) {
        this.eStudent = eStudent;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "examDetailTM{" +
                "eCode='" + eCode + '\'' +
                ", eDate='" + eDate + '\'' +
                ", eDuration=" + eDuration +
                ", eStudent=" + eStudent +
                ", tId='" + tId + '\'' +
                '}';
    }
}
