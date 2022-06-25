package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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

public class UserDashboardFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public JFXButton home;
    public static String sName;
    public Label setNameId;

    public void studentPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/studentForm.fxml"));
        context.getChildren().add(parent);
    }

    public void teacherPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/teacherForm.fxml"));
        context.getChildren().add(parent);
    }

    public void examPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/examForm.fxml"));
        context.getChildren().add(parent);
    }

    public void userPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userForm.fxml"));
        context.getChildren().add(parent);
    }

    public void employeePage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/employeeForm.fxml"));
        context.getChildren().add(parent);
    }

    public void budgetPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/budgetForm.fxml"));
        context.getChildren().add(parent);
    }

    public void noticePage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/noticeForm.fxml"));
        context.getChildren().add(parent);
    }

    public void paymentPage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/paymentForm.fxml"));
        context.getChildren().add(parent);
    }

    public void attendancePage(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/attendanceForm.fxml"));
        context.getChildren().add(parent);
    }

    public void logOutbtn(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/homeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();

        Stage stage = (Stage) home.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNameId.setText(sName);
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();
    }

    private void setTime() {
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

