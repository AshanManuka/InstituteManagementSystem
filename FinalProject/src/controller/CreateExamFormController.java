package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import model.exam;
import util.crudUtil;

import java.sql.SQLException;

public class CreateExamFormController {
    public AnchorPane smallContext;
    public JFXTextField setGrade;
    public JFXTextField setDate;
    public JFXTextField setDuration;
    public JFXTextField setTeacher;
    public JFXTextField setStudentsNumber;
    public JFXButton goToBack;
    public AnchorPane context;
    public JFXTextField examCode;

    public void setExams(ActionEvent actionEvent) {
        exam ex=new exam(examCode.getText(),Integer.parseInt(setGrade.getText()),setDate.getText(),Double.parseDouble(setDuration.getText()),setTeacher.getText(),Integer.parseInt(setStudentsNumber.getText()));

        try{
            if(crudUtil.execute("INSERT INTO exam VALUES (?,?,?,?,?,?)",ex.getExamCode(),ex.getGrade(),ex.getDate(),ex.getDuration(),ex.getTeacherId(),ex.getNoStudent())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void goToBack(ActionEvent actionEvent) {
    smallContext.getChildren().clear();
    }
}
