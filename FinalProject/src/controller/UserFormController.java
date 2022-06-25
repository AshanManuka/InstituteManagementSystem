package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.naming.Context;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public AnchorPane smallContext;
    public JFXButton updateUser;
    public JFXButton searchUser;
    public JFXButton addUser;
    public JFXButton paymentD;
    public JFXButton loginetails;
    public JFXButton deleteUser;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void updateUser(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: #1B9CFC");
        searchUser.setStyle("-fx-background-color: #1B9CFC");
        updateUser.setStyle("-fx-background-color: darkcyan");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        loginetails.setStyle("-fx-background-color: #1B9CFC");
        deleteUser.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/updateUserForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void searchUser(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: #1B9CFC");
        searchUser.setStyle("-fx-background-color: darkcyan");
        updateUser.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        loginetails.setStyle("-fx-background-color: #1B9CFC");
        deleteUser.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/searchUserForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void newUser(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: darkcyan");
        searchUser.setStyle("-fx-background-color: #1B9CFC");
        updateUser.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        loginetails.setStyle("-fx-background-color: #1B9CFC");
        deleteUser.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/newUserForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void paymentUser(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: #1B9CFC");
        searchUser.setStyle("-fx-background-color: #1B9CFC");
        updateUser.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: darkcyan");
        loginetails.setStyle("-fx-background-color: #1B9CFC");
        deleteUser.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/UserSalaryForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void loginDetails(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: #1B9CFC");
        searchUser.setStyle("-fx-background-color: #1B9CFC");
        updateUser.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        loginetails.setStyle("-fx-background-color: darkcyan");
        deleteUser.setStyle("-fx-background-color: #1B9CFC");
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/loginDetailForm.fxml"));
        context.getChildren().add(parent);
    }

    public void deleteUser(ActionEvent actionEvent) throws IOException {
        addUser.setStyle("-fx-background-color: #1B9CFC");
        searchUser.setStyle("-fx-background-color: #1B9CFC");
        updateUser.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        loginetails.setStyle("-fx-background-color: #1B9CFC");
        deleteUser.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/deleteUserForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();
    }
    public void setTime(){
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm:ss aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    timeID.setText(times);
                });
            }
        });
        thread.start();

    }

}
