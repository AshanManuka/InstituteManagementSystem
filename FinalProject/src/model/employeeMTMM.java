package model;

public class employeeMTMM {
private String empId;
private String empName;
private String empAddress;
private double empSalary;
private int empContact;

    public employeeMTMM() {
    }

    public employeeMTMM(String empId, String empName, String empAddress, double empSalary, int empContact) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
        this.empContact = empContact;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpContact() {
        return empContact;
    }

    public void setEmpContact(int empContact) {
        this.empContact = empContact;
    }

    @Override
    public String toString() {
        return "employeeMTMM{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empSalary=" + empSalary +
                ", empContact=" + empContact +
                '}';
    }
}
