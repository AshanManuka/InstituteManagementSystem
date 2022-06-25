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

public class ExamFormController implements Initializable {
    public Label timeID;
    public Label dateID;
    public AnchorPane smallContext;
    public JFXButton exam4;
    public JFXButton exam3;
    public JFXButton exam2;
    public JFXButton exam1;
    public AnchorPane context;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void showResults(ActionEvent actionEvent) throws IOException {
        exam1.setStyle("-fx-background-color: #1B9CFC");
        exam2.setStyle("-fx-background-color: #1B9CFC");
        exam3.setStyle("-fx-background-color: #1B9CFC");
        exam4.setStyle("-fx-background-color: darkcyan");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/showResultForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void showExams(ActionEvent actionEvent) throws IOException {
        exam1.setStyle("-fx-background-color: #1B9CFC");
        exam2.setStyle("-fx-background-color: #1B9CFC");
        exam3.setStyle("-fx-background-color: darkcyan");
        exam4.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/showExamForm.fxml"));
        smallContext.getChildren().add(parent);
    }

    public void setResults(ActionEvent actionEvent) throws IOException {
        exam1.setStyle("-fx-background-color: #1B9CFC");
        exam2.setStyle("-fx-background-color: darkcyan");
        exam3.setStyle("-fx-background-color: #1B9CFC");
        exam4.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/setResultForm.fxml"));
        smallContext.getChildren().add(parent);
        }

    public void setExam(ActionEvent actionEvent) throws IOException {
        exam1.setStyle("-fx-background-color: darkcyan");
        exam2.setStyle("-fx-background-color: #1B9CFC");
        exam3.setStyle("-fx-background-color: #1B9CFC");
        exam4.setStyle("-fx-background-color: #1B9CFC");
        smallContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/createExamForm.fxml"));
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
