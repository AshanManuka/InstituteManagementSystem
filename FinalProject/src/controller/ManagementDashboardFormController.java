package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ManagementDashboardFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public JFXButton home;

    public void studentPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/studentDetailForm.fxml"));
        context.getChildren().add(parent);
    }

    public void budgetPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/budgetTableForm.fxml"));
        context.getChildren().add(parent);
    }

    public void teacherPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/teacherDetailForm.fxml"));
        context.getChildren().add(parent);
    }

    public void logOutbtn(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/homeForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();

        Stage stage1 = (Stage) home.getScene().getWindow();
        stage1.close();
    }

    public void employeePage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/employeDetailForm.fxml"));
        context.getChildren().add(parent);
    }


    public void userDashboardPage(ActionEvent actionEvent) throws IOException {
        UserDashboardFormController.sName="Manager";
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void newUserPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/newSystemUserForm.fxml"));
        context.getChildren().add(parent);
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
