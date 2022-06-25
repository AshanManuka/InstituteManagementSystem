package model;

public class resultTM {
private int grade;
private String examCode;
private String studentId;
private double results;

    public resultTM() {
    }

    public resultTM(int grade, String examCode, String studentId, double results) {
        this.grade = grade;
        this.examCode = examCode;
        this.studentId = studentId;
        this.results = results;
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

    public double getResults() {
        return results;
    }

    public void setResults(double results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "resultTM{" +
                "grade=" + grade +
                ", examCode='" + examCode + '\'' +
                ", studentId='" + studentId + '\'' +
                ", results=" + results +
                '}';
    }
}
