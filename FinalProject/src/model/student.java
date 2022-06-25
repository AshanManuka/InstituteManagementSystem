package model;

public class student {
private String studentId;
private String studentName;
private String studentAddress;
private int studentGrade;
private int studentContact;

    public student(String text, String studentNameText, String studentAddressText, int i) {
    }

    public student(String studentId, String studentName, String studentAddress, int studentGrade, int studentContact) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentGrade = studentGrade;
        this.studentContact = studentContact;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(int studentContact) {
        this.studentContact = studentContact;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentGrade=" + studentGrade +
                ", studentContact=" + studentContact +
                '}';
    }
}
