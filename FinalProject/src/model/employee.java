package model;

public class employee {
private String employeeId;
private String employeeName;
private String employeeAddress;
private double employeeSalary;
private int employeeContact;

    public employee() {
    }

    public employee(String employeeId, String employeeName, String employeeAddress, double employeeSalary, int employeeContact) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.employeeContact = employeeContact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(int employeeContact) {
        this.employeeContact = employeeContact;
    }

    @Override
    public String toString() {
        return "employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeContact=" + employeeContact +
                '}';
    }
}
