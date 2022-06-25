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

public class PaymentFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public AnchorPane smallContext;
    public JFXButton userSalaryId;
    public JFXButton employeeSalaryID;
    public JFXButton teacherPaymentID;
    public JFXButton studentPaymentID;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void userSalary(ActionEvent actionEvent) throws IOException {
        userSalaryId.setStyle("-fx-background-color: darkcyan");
        employeeSalaryID.setStyle("-fx-background-color: #1B9CFC");
        teacherPaymentID.setStyle("-fx-background-color: #1B9CFC");
        studentPaymentID.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userPaymentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void employeeSalary(ActionEvent actionEvent) throws IOException {
        userSalaryId.setStyle("-fx-background-color: #1B9CFC");
        employeeSalaryID.setStyle("-fx-background-color: darkcyan");
        teacherPaymentID.setStyle("-fx-background-color: #1B9CFC");
        studentPaymentID.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/employeePaymentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void teacherPayment(ActionEvent actionEvent) throws IOException {
        userSalaryId.setStyle("-fx-background-color: #1B9CFC");
        employeeSalaryID.setStyle("-fx-background-color: #1B9CFC");
        teacherPaymentID.setStyle("-fx-background-color: darkcyan");
        studentPaymentID.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/teacherPaymentForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void studentPayment(ActionEvent actionEvent) throws IOException {
        userSalaryId.setStyle("-fx-background-color: #1B9CFC");
        employeeSalaryID.setStyle("-fx-background-color: #1B9CFC");
        teacherPaymentID.setStyle("-fx-background-color: #1B9CFC");
        studentPaymentID.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/studentfeeForm.fxml"));
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
