package model;

public class teacher {
private String teacherId;
private String teacherName;
private String teacherAddress;
private double teacherSalary;
private int teacherContact;

    public teacher() {
    }

    public teacher(String teacherId, String teacherName, String teacherAddress, double teacherSalary, int teacherContact) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
        this.teacherSalary = teacherSalary;
        this.teacherContact = teacherContact;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public int getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(int teacherContact) {
        this.teacherContact = teacherContact;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", teacherSalary=" + teacherSalary +
                ", teacherContact=" + teacherContact +
                '}';
    }
}
