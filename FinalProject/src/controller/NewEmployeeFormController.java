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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewEmployeeFormController implements Initializable{
    public AnchorPane smallContext;
    public JFXTextField employeeID;
    public JFXTextField employeeName;
    public JFXTextField employeeAddress;
    public JFXTextField employeeSalary;
    public JFXTextField employeeContact;
    public JFXButton addemployeeId;

    public void addEmployee(ActionEvent actionEvent) {
    setEmployee();
    }

    private void setEmployee() {
        employee e1=new employee(employeeID.getText(),employeeName.getText(),employeeAddress.getText(),Double.parseDouble(employeeSalary.getText()),Integer.parseInt(employeeContact.getText()));
        try{
            if(crudUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?)",e1.getEmployeeId(),e1.getEmployeeName(),e1.getEmployeeAddress(),e1.getEmployeeSalary(),e1.getEmployeeContact())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addemployeeId.setDisable(true);
    }

    public void keyReleasedAction(KeyEvent keyEvent) {
        String eId = employeeID.getText();
        String eName = employeeName.getText();
        String eAddress = employeeAddress.getText();
        String eSalary = employeeSalary.getText();
        String eContact = employeeContact.getText();

        Pattern ceId = Pattern.compile("^(e)[0-9]{4}$");
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
            employeeID.setStyle("-fx-background-color: #81ecec");
            if (keyEvent.getCode() == KeyCode.ENTER){
                employeeName.requestFocus();
            }
            if (matcherName){
                employeeName.setStyle("-fx-background-color: #81ecec");
                if (keyEvent.getCode() == KeyCode.ENTER){
                    employeeAddress.requestFocus();
                }
                if (matcherAddress){
                    employeeAddress.setStyle("-fx-background-color: #81ecec");
                    if (keyEvent.getCode() == KeyCode.ENTER){
                        employeeSalary.requestFocus();
                    }
                    if (matcherSalary){
                        employeeSalary.setStyle("-fx-background-color: #81ecec");
                        if (keyEvent.getCode() == KeyCode.ENTER){
                            employeeContact.requestFocus();
                        }
                        if (matcherContact){
                            employeeContact.setStyle("-fx-background-color: #81ecec");
                            addemployeeId.setDisable(false);
                            if (keyEvent.getCode() == KeyCode.ENTER){
                                addemployeeId.requestFocus();
                                setEmployee();
                            }
                        }else{
                            employeeContact.setStyle("-fx-background-color: FF987B");
                        }
                    }else{
                        employeeSalary.setStyle("-fx-background-color: FF987B");
                    }
                }else{
                    employeeAddress.setStyle("-fx-background-color: FF987B");
                }
            }else{
                employeeName.setStyle("-fx-background-color: FF987B");
            }
        }else{
            employeeID.setStyle("-fx-background-color: FF987B");
        }

    }
}
