package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Timeline;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;


public class EmployeeFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public JFXButton updateEmployee;
    public JFXButton searchEmployee;
    public JFXButton addEmployee;
    public JFXButton paymentD;
    public JFXButton attendanceD;
    public JFXButton deleteEmployee;
    public AnchorPane smallContext;

    public void updateEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: #1B9CFC");
        searchEmployee.setStyle("-fx-background-color: #1B9CFC");
        updateEmployee.setStyle("-fx-background-color: darkcyan");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteEmployee.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/updateEmployeeForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void searchEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: #1B9CFC");
        searchEmployee.setStyle("-fx-background-color: darkcyan");
        updateEmployee.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteEmployee.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/searchEmployeeForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void newEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: darkcyan");
        searchEmployee.setStyle("-fx-background-color: #1B9CFC");
        updateEmployee.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteEmployee.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/newEmployeeForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void paymentEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: #1B9CFC");
        searchEmployee.setStyle("-fx-background-color: #1B9CFC");
        updateEmployee.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: darkcyan");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteEmployee.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/EmployeeSalaryForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void attandanceEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: #1B9CFC");
        searchEmployee.setStyle("-fx-background-color: #1B9CFC");
        updateEmployee.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: darkcyan");
        deleteEmployee.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/employeeAttendanceForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void deleteEmployee(ActionEvent actionEvent) throws IOException {
        addEmployee.setStyle("-fx-background-color: #1B9CFC");
        searchEmployee.setStyle("-fx-background-color: #1B9CFC");
        updateEmployee.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteEmployee.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/deleteEmployeeForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
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
