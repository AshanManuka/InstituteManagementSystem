package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {
    public Label wishID;
    public Label dateID;
    public Label timeID;
    public  JFXButton ulogin;
    public ImageView context;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showDate();
        RunningTime();
        setWish();
    }

    private void setWish() {
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                char c1=times.charAt(0);
                char c2=times.charAt(1);
                char c3=times.charAt(5);
                char c4=times.charAt(6);
                Platform.runLater(() -> {
                    //System.out.println(c);
                    //System.out.println(times);
                    if ("1".equals(String.valueOf(c1)) && "2".equals(String.valueOf(c2)) && "P".equals(String.valueOf(c4))){
                     wishID.setText("Good Afternoon...!");
                    }else if ("A".equals(String.valueOf(c3)) || "A".equals(String.valueOf(c4))){
                        wishID.setText("Good Morning...!");
                    }else if ("P".equals(String.valueOf(c3)) || "P".equals(String.valueOf(c4))){
                        wishID.setText("Good Evening...!");
                    }
                });
            }
        });
        thread.start();
    }

    private void RunningTime() {
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

    private void showDate() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateID.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void managerLogin(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/managerLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.show();

        Stage stage3 = (Stage) ulogin.getScene().getWindow();
        stage3.close();


    }

    public void userLogin(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/userLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();

        Stage stage = (Stage) ulogin.getScene().getWindow();
        stage.close();
    }

}
