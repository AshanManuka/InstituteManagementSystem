package model;

public class employeeMTM {
    private String eId;
    private String eName;
    private String eAddress;
    private double eSalary;
    private int eContact;

    public employeeMTM() {
    }

    public employeeMTM(String eId, String eName, String eAddress, double eSalary, int eContact) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.eSalary = eSalary;
        this.eContact = eContact;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }

    public int geteContact() {
        return eContact;
    }

    public void seteContact(int eContact) {
        this.eContact = eContact;
    }

    @Override
    public String toString() {
        return "employeeMTM{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", eAddress='" + eAddress + '\'' +
                ", eSalary=" + eSalary +
                ", eContact=" + eContact +
                '}';
    }
}
