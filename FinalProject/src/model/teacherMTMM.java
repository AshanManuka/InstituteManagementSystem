package model;

public class teacherMTMM {
private String teID;
private String teNAME;
private String teADDRESS;
private double teSALARY;
private int teCONTACT;

    public teacherMTMM() {
    }

    public teacherMTMM(String teID, String teNAME, String teADDRESS, double teSALARY, int teCONTACT) {
        this.teID = teID;
        this.teNAME = teNAME;
        this.teADDRESS = teADDRESS;
        this.teSALARY = teSALARY;
        this.teCONTACT = teCONTACT;
    }

    public String getTeID() {
        return teID;
    }

    public void setTeID(String teID) {
        this.teID = teID;
    }

    public String getTeNAME() {
        return teNAME;
    }

    public void setTeNAME(String teNAME) {
        this.teNAME = teNAME;
    }

    public String getTeADDRESS() {
        return teADDRESS;
    }

    public void setTeADDRESS(String teADDRESS) {
        this.teADDRESS = teADDRESS;
    }

    public double getTeSALARY() {
        return teSALARY;
    }

    public void setTeSALARY(double teSALARY) {
        this.teSALARY = teSALARY;
    }

    public int getTeCONTACT() {
        return teCONTACT;
    }

    public void setTeCONTACT(int teCONTACT) {
        this.teCONTACT = teCONTACT;
    }

    @Override
    public String toString() {
        return "teacherMTMM{" +
                "teID='" + teID + '\'' +
                ", teNAME='" + teNAME + '\'' +
                ", teADDRESS='" + teADDRESS + '\'' +
                ", teSALARY=" + teSALARY +
                ", teCONTACT=" + teCONTACT +
                '}';
    }
}
