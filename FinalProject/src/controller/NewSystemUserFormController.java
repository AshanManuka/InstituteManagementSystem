package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.systemUser;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class NewSystemUserFormController implements Initializable {
    public AnchorPane context;
    public JFXTextField userId;
    public JFXTextField userName;
    public JFXTextField address;
    public JFXTextField salary;
    public JFXTextField contact;
    public JFXTextField systemUserName;
    public JFXPasswordField newPassword;
    public JFXPasswordField comfirnPassword;
    public Label dateID;
    public Label timeID;
    public JFXButton addSUserId;
    int j = 0 ;

    public void searchUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ResultSet result = crudUtil.execute("SELECT * FROM user WHERE userId=?",userId.getText());
        if (result.next()) {
            userName.setText(result.getString(2));
            address.setText(result.getString(3));
            salary.setText(result.getString(4));
            contact.setText(result.getString(5));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

    public void addSystemUser(ActionEvent actionEvent) {
        addUser();
    }

    private void addUser() {
        String newUName = systemUserName.getText();
        String newPword = newPassword.getText();
        String comPword = comfirnPassword.getText();


        if (newPword.equals(comPword)){
            try {
                if (crudUtil.execute("INSERT INTO systemUser VALUES(?,?,?)",userId.getText(),newUName,newPword)){
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void deleteSystemUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try{
            if (crudUtil.execute("DELETE FROM systemUser WHERE userId=?",userId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!..").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Can't Delete!..").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashboardForm.fxml"));
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

    public void keyAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (j==0){
                j++;
               newPassword.requestFocus();
            }else if (j==1){
                j++;
                comfirnPassword.requestFocus();
            }else if (j==2){
                addSUserId.requestFocus();
                addUser();
            }
        }
    }
}

