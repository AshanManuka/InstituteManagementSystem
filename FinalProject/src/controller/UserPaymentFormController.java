package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import model.budget;
import model.userSalary;
import util.crudUtil;

import java.sql.SQLException;

public class UserPaymentFormController {
    public AnchorPane smallContext;
    public JFXTextField userId;
    public JFXTextField Year;
    public JFXTextField month;
    public JFXTextField amount;

    public void setPayment(ActionEvent actionEvent) {
        String description="User Salary";
        String type= "Cost";
        budget b1=new budget(description,type,Integer.parseInt(Year.getText()),month.getText(),Double.parseDouble(amount.getText()));
        userSalary us= new userSalary(userId.getText(),Integer.parseInt(Year.getText()),month.getText(),Double.parseDouble(amount.getText()));
        try{
            if(crudUtil.execute("INSERT INTO usersalary VALUES (?,?,?,?)",us.getUserId(),us.getYear(),us.getMonth(),us.getAmount())){
                crudUtil.execute("INSERT INTO budget VALUES(?,?,?,?,?)",b1.getDescription(),b1.getType(),b1.getYear(),b1.getMonth(),b1.getAmount());
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    public void cancelBtn(ActionEvent actionEvent) {
    }
}
