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

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TeacherFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;

    public JFXButton paymentD;
    public JFXButton attendanceD;
    public AnchorPane smallContext;
    public JFXButton updateTeacher;
    public JFXButton searchTeacher;
    public JFXButton addTeacher;
    public JFXButton deleteTeacher;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }


    public void updateTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: #1B9CFC");
        searchTeacher.setStyle("-fx-background-color: #1B9CFC");
        updateTeacher.setStyle("-fx-background-color: darkcyan");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteTeacher.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/updateTeacherForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void searchTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: #1B9CFC");
        searchTeacher.setStyle("-fx-background-color: darkcyan");
        updateTeacher.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteTeacher.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/searchTeacherForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void newTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: darkcyan");
        searchTeacher.setStyle("-fx-background-color: #1B9CFC");
        updateTeacher.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteTeacher.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/addTeacherForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void paymentTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: #1B9CFC");
        searchTeacher.setStyle("-fx-background-color: #1B9CFC");
        updateTeacher.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: darkcyan");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteTeacher.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/teacherSalaryForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void attandanceTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: #1B9CFC");
        searchTeacher.setStyle("-fx-background-color: #1B9CFC");
        updateTeacher.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: darkcyan");
        deleteTeacher.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/teacherAttendanceForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void deleteTeacher(ActionEvent actionEvent) throws IOException {
        addTeacher.setStyle("-fx-background-color: #1B9CFC");
        searchTeacher.setStyle("-fx-background-color: #1B9CFC");
        updateTeacher.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteTeacher.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/deleteTeacherForm.fxml"));
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
