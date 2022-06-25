package model;

public class user {
private String userId;
private String userName;
private String userAddress;
private double userSalary;
private int userContact;

    public user() {
    }

    public user(String userId, String userName, String userAddress, double userSalary, int userContact) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userSalary = userSalary;
        this.userContact = userContact;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(double userSalary) {
        this.userSalary = userSalary;
    }

    public int getUserContact() {
        return userContact;
    }

    public void setUserContact(int userContact) {
        this.userContact = userContact;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSalary=" + userSalary +
                ", userContact=" + userContact +
                '}';
    }
}
