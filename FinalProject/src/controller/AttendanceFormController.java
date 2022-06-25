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

public class AttendanceFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public AnchorPane smallContext;
    public JFXButton studentAttendanceId;
    public JFXButton employeeAttendanceId;
    public JFXButton teacherAttendanceID;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void studentAttendance(ActionEvent actionEvent) throws IOException {
        studentAttendanceId.setStyle("-fx-background-color: darkcyan");
        employeeAttendanceId.setStyle("-fx-background-color: #1B9CFC");
        teacherAttendanceID.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/attendanceStudentmForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void employeeAttendance(ActionEvent actionEvent) throws IOException {
        studentAttendanceId.setStyle("-fx-background-color: #1B9CFC");
        employeeAttendanceId.setStyle("-fx-background-color: darkcyan");
        teacherAttendanceID.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/attendanceEmployeemForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void teacherAttendance(ActionEvent actionEvent) throws IOException {
        studentAttendanceId.setStyle("-fx-background-color: #1B9CFC");
        employeeAttendanceId.setStyle("-fx-background-color: #1B9CFC");
        teacherAttendanceID.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/attendanceTeachermForm.fxml"));
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
