package model;

public class studentMTM {
    private String sId;
    private String sName;
    private String sAddress;
    private int sGrade;
    private int sContact;

    public studentMTM() {
    }

    public studentMTM(String sId, String sName, String sAddress, int sGrade, int sContact) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sGrade = sGrade;
        this.sContact = sContact;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public int getsGrade() {
        return sGrade;
    }

    public void setsGrade(int sGrade) {
        this.sGrade = sGrade;
    }

    public int getsContact() {
        return sContact;
    }

    public void setsContact(int sContact) {
        this.sContact = sContact;
    }

    @Override
    public String toString() {
        return "studentMTM{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sGrade=" + sGrade +
                ", sContact=" + sContact +
                '}';
    }
}

