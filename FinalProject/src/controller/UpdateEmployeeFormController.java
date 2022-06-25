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
import model.employee;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class UpdateEmployeeFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public JFXTextField checkName;
    public JFXTextField newID;
    public JFXTextField newName;
    public JFXTextField newSalary;
    public JFXTextField newAddress;
    public JFXTextField newContact;
    public JFXButton updateId;
    public JFXButton showDetailId;
    int i = 1;
    int j = 0;

    public void checkDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM employee WHERE employeeId=? OR employeeName=?",checkID.getText(),checkName.getText());
        if (result.next()) {
            newID.setText(result.getString(1));
            newName.setText(result.getString(2));
            newAddress.setText(result.getString(3));
            newSalary.setText(result.getString(4));
            newContact.setText(result.getString(5));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

    public void updateBTN(ActionEvent actionEvent) {
       updateDetail();
    }

    private void updateDetail() {
        employee e1=new employee(newID.getText(),newName.getText(),newAddress.getText(),Double.parseDouble(newSalary.getText()),Integer.parseInt(newContact.getText()));

        try{
            if(crudUtil.execute("UPDATE employee SET employeeName=?,employeeAddress=?,employeeSalary=?,employeeContact=?  WHERE employeeId=?",e1.getEmployeeName(),e1.getEmployeeAddress(),e1.getEmployeeSalary(),e1.getEmployeeContact(),e1.getEmployeeId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateId.setDisable(true);
    }


    public void keyReleasedAction(KeyEvent keyEvent) {
        String stId = newID.getText();
        String stName = newName.getText();
        String stAddress = newAddress.getText();
        String stSalary =newSalary.getText();
        String stContact = newContact.getText();

        Pattern comStudentId = Pattern.compile("^(e)[0-9]{4}$");
        boolean matcherId = comStudentId.matcher(stId).matches();
        Pattern comStudentName = Pattern.compile("^[A-z ]{3,25}$");
        boolean matcherName = comStudentName.matcher(stName).matches();
        Pattern comStudentAddress = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        boolean matcherAddress = comStudentAddress.matcher(stAddress).matches();
        Pattern comStudentSalary = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");
        boolean matcherSalary = comStudentSalary.matcher(stSalary).matches();
        Pattern comStudentContact = Pattern.compile("^[0-9]{9,10}$");
        boolean matcherContact = comStudentContact.matcher(stContact).matches();

        if (keyEvent.getCode() == KeyCode.ENTER){
            if(i==1){
                newID.requestFocus();
                i=2;
            }else if (i==2){
                newName.requestFocus();
                i=3;
            }else if (i==3){
                newAddress.requestFocus();
                i=4;
            }else if (i==4){
                newSalary.requestFocus();
                i=5;
            }else if (i==5){
                newContact.requestFocus();
                updateId.setDisable(false);
                i=6;
            }else if (i==6){
                updateId.requestFocus();
                updateDetail();
            }
        }


        if (!matcherId){
            newID.setStyle("-fx-background-color: FF987B");
        }else{
            newID.setStyle("-fx-background-color: #81ecec");
        }
        if (! matcherName){
            newName.setStyle("-fx-background-color: FF987B");
        }else{
            newName.setStyle("-fx-background-color: #81ecec");
        }
        if (! matcherSalary){
            newSalary.setStyle("-fx-background-color: FF987B");
        }else{
            newSalary.setStyle("-fx-background-color: #81ecec");
        }
        if (! matcherContact){
            newContact.setStyle("-fx-background-color: FF987B");
        }else{
            newContact.setStyle("-fx-background-color: #81ecec");
        }
        if (! matcherAddress){
            newAddress.setStyle("-fx-background-color: FF987B");
        }else{
            newAddress.setStyle("-fx-background-color: #81ecec");
        }

    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (j==0){
                j++;
                checkName.requestFocus();
            }else if (j==1){
                showDetailId.requestFocus();
                searchResult();
            }
        }
    }
}
