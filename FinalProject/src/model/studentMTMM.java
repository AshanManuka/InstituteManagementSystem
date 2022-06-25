package model;

public class studentMTMM {
private String stId;
private String stName;
private String stAddress;
private int stGrade;
private int stContact;

    public studentMTMM() {
    }

    public studentMTMM(String stId, String stName, String stAddress, int stGrade, int stContact) {
        this.stId = stId;
        this.stName = stName;
        this.stAddress = stAddress;
        this.stGrade = stGrade;
        this.stContact = stContact;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public int getStGrade() {
        return stGrade;
    }

    public void setStGrade(int stGrade) {
        this.stGrade = stGrade;
    }

    public int getStContact() {
        return stContact;
    }

    public void setStContact(int stContact) {
        this.stContact = stContact;
    }

    @Override
    public String toString() {
        return "studentMTMM{" +
                "stId='" + stId + '\'' +
                ", stName='" + stName + '\'' +
                ", stAddress='" + stAddress + '\'' +
                ", stGrade=" + stGrade +
                ", stContact=" + stContact +
                '}';
    }
}
