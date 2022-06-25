package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class SignUpFormController {
    public AnchorPane context;
    public JFXTextField newID;
    public JFXTextField newName;
    public JFXTextField newAddress;
    public JFXTextField newTele;
    public JFXTextField newSalary;
    public JFXTextField newUserName;
    public JFXPasswordField newPassword;

    public void backToHome(ActionEvent actionEvent) {
        System.out.println("go to home");
    }

    public void createNew(ActionEvent actionEvent) {
        System.out.println("set action correctly");
    }
}
