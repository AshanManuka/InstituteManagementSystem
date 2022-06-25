package model;

public class examResultTM {
private String eCode;
private String eStudentId;
private String eStudentName;
private double eResult;

    public examResultTM() {
    }

    public examResultTM(String eCode, String eStudentId, String eStudentName, double eResult) {
        this.eCode = eCode;
        this.eStudentId = eStudentId;
        this.eStudentName = eStudentName;
        this.eResult = eResult;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String geteStudentId() {
        return eStudentId;
    }

    public void seteStudentId(String eStudentId) {
        this.eStudentId = eStudentId;
    }

    public String geteStudentName() {
        return eStudentName;
    }

    public void seteStudentName(String eStudentName) {
        this.eStudentName = eStudentName;
    }

    public double geteResult() {
        return eResult;
    }

    public void seteResult(double eResult) {
        this.eResult = eResult;
    }

    @Override
    public String toString() {
        return "examResultTM{" +
                "eCode='" + eCode + '\'' +
                ", eStudentId='" + eStudentId + '\'' +
                ", eStudentName='" + eStudentName + '\'' +
                ", eResult=" + eResult +
                '}';
    }
}
