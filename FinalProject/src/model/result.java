package model;

public class result {
private int grade;
private String examCode;
private String studentId;
private double result;

    public result() {
    }

    public result(int grade, String examCode, String studentId, double result) {
        this.grade = grade;
        this.examCode = examCode;
        this.studentId = studentId;
        this.result = result;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "result{" +
                "grade=" + grade +
                ", examCode='" + examCode + '\'' +
                ", studentId='" + studentId + '\'' +
                ", result=" + result +
                '}';
    }
}
