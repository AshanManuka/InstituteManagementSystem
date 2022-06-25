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
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public AnchorPane smallContext;
    public JFXButton updateStudent;
    public JFXButton searchStudent;
    public JFXButton addStudent;
    public JFXButton paymentD;
    public JFXButton attendanceD;
    public JFXButton deleteStudent;

    public void newStudent(ActionEvent actionEvent) throws IOException {
       addStudent.setStyle("-fx-background-color: darkcyan");
       searchStudent.setStyle("-fx-background-color: #1B9CFC");
       updateStudent.setStyle("-fx-background-color: #1B9CFC");
       paymentD.setStyle("-fx-background-color: #1B9CFC");
       attendanceD.setStyle("-fx-background-color: #1B9CFC");
       deleteStudent.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/addStudentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void updateStudent(ActionEvent actionEvent) throws IOException {
        addStudent.setStyle("-fx-background-color: #1B9CFC");
        searchStudent.setStyle("-fx-background-color: #1B9CFC");
        updateStudent.setStyle("-fx-background-color: darkcyan");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteStudent.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/updateStuentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void searchStudent(ActionEvent actionEvent) throws IOException {
        addStudent.setStyle("-fx-background-color: #1B9CFC");
        searchStudent.setStyle("-fx-background-color: darkcyan");
        updateStudent.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteStudent.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/searchStudentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void paymentStudent(ActionEvent actionEvent) throws IOException {
        addStudent.setStyle("-fx-background-color: #1B9CFC");
        searchStudent.setStyle("-fx-background-color: #1B9CFC");
        updateStudent.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: darkcyan");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteStudent.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/studentPaymentDetailForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void attandanceStudent(ActionEvent actionEvent) throws IOException {
        addStudent.setStyle("-fx-background-color: #1B9CFC");
        searchStudent.setStyle("-fx-background-color: #1B9CFC");
        updateStudent.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: darkcyan");
        deleteStudent.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/studentAttendanceForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void deleteStudent(ActionEvent actionEvent) throws IOException {
        addStudent.setStyle("-fx-background-color: #1B9CFC");
        searchStudent.setStyle("-fx-background-color: #1B9CFC");
        updateStudent.setStyle("-fx-background-color: #1B9CFC");
        paymentD.setStyle("-fx-background-color: #1B9CFC");
        attendanceD.setStyle("-fx-background-color: #1B9CFC");
        deleteStudent.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/deleteStudentForm.fxml"));
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
