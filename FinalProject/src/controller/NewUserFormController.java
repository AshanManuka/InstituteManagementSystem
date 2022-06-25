package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.user;
import util.crudUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewUserFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField userID;
    public JFXTextField userName;
    public JFXTextField userAddress;
    public JFXTextField userContact;
    public JFXTextField userSalary;
    public JFXButton addUserId;

    public void addSUser(ActionEvent actionEvent) {
    setUser();
    }

    private void setUser() {
        user u1=new user(userID.getText(),userName.getText(),userAddress.getText(),Double.parseDouble(userSalary.getText()),Integer.parseInt(userContact.getText()));
        try{
            if(crudUtil.execute("INSERT INTO user VALUES (?,?,?,?,?)",u1.getUserId(),u1.getUserName(),u1.getUserAddress(),u1.getUserSalary(),u1.getUserContact())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addUserId.setDisable(true);
    }


    public void keyReleasedAction(KeyEvent keyEvent) {
        String eId = userID.getText();
        String eName = userName.getText();
        String eAddress = userAddress.getText();
        String eSalary = userSalary.getText();
        String eContact = userContact.getText();

        Pattern ceId = Pattern.compile("^(u)[0-9]{4}$");
        boolean matcherId = ceId.matcher(eId).matches();
        Pattern ceName = Pattern.compile("^[A-z ]{3,25}$");
        boolean matcherName = ceName.matcher(eName).matches();
        Pattern ceAddress = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        boolean matcherAddress = ceAddress.matcher(eAddress).matches();
        Pattern ceSalary = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");
        boolean matcherSalary = ceSalary.matcher(eSalary).matches();
        Pattern ceContact = Pattern.compile("^[0-9]{9,10}$");
        boolean matcherContact = ceContact.matcher(eContact).matches();

        if (matcherId){
            userID.setStyle("-fx-background-color: #81ecec");
            if (keyEvent.getCode() == KeyCode.ENTER){
                userName.requestFocus();
            }
            if (matcherName){
                userName.setStyle("-fx-background-color: #81ecec");
                if (keyEvent.getCode() == KeyCode.ENTER){
                    userAddress.requestFocus();
                }
                if (matcherAddress){
                    userAddress.setStyle("-fx-background-color: #81ecec");
                    if (keyEvent.getCode() == KeyCode.ENTER){
                        userSalary.requestFocus();
                    }
                    if (matcherSalary){
                        userSalary.setStyle("-fx-background-color: #81ecec");
                        if (keyEvent.getCode() == KeyCode.ENTER){
                            userContact.requestFocus();
                        }
                        if (matcherContact){
                            userContact.setStyle("-fx-background-color: #81ecec");
                            addUserId.setDisable(false);
                            if (keyEvent.getCode() == KeyCode.ENTER){
                                userID.requestFocus();
                                setUser();
                            }
                        }else{
                            userContact.setStyle("-fx-background-color: FF987B");
                        }
                    }else{
                        userSalary.setStyle("-fx-background-color: FF987B");
                    }
                }else{
                    userAddress.setStyle("-fx-background-color: FF987B");
                }
            }else{
                userName.setStyle("-fx-background-color: FF987B");
            }
        }else{
            userID.setStyle("-fx-background-color: FF987B");
        }

    }


}
