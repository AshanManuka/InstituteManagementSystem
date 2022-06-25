package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import model.attendance;
import util.crudUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AttendanceStudentmFormController implements Initializable{
    public AnchorPane smallContext;
    public JFXComboBox<String> yearBox;
    public JFXComboBox<String> monthBox;
    public JFXTextField setID;
    public JFXTextField setDate;
    public RadioButton presentCBTN;
    public RadioButton absentCBTN;
    int sYear;
    String sMonth;
    String aStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] year = {"2022","2023","2024","2025"};
        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};

        yearBox.setPromptText("Years");
        yearBox.getItems().addAll(year);
        monthBox.setPromptText("Months");
        monthBox.getItems().addAll(month);

        yearBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             sYear=Integer.parseInt(newValue);
            //setAttendance(sYear);
        });

        monthBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sMonth=newValue;
            //setAttendance(newValue);
        });
    }

    public void doneBTN(ActionEvent actionEvent) {
       if(presentCBTN.isSelected()){
           aStatus="Yes";
       }
       if(absentCBTN.isSelected()){
           aStatus="No";
       }

       attendance sa=new attendance(sYear,sMonth,setDate.getText(),setID.getText(),aStatus);

        try{
            if(crudUtil.execute("INSERT INTO studentattendance VALUES (?,?,?,?,?)",sa.getaId(),sa.getYear(),sa.getMonth(),sa.getDate(),sa.getStatus())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    public void cancelBTN(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }


}
