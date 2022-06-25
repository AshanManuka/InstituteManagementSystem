package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import model.result;
import util.crudUtil;

import java.sql.SQLException;

public class SetResultFormController {
    public AnchorPane smallContext;
    public JFXTextField grade;
    public JFXTextField examCode;
    public JFXTextField results;
    public JFXTextField studentID;

    public void setResults(ActionEvent actionEvent) {
    result rs=new result(Integer.parseInt(grade.getText()),examCode.getText(),studentID.getText(),Double.parseDouble(results.getText()));

        try{
            if(crudUtil.execute("INSERT INTO result VALUES (?,?,?,?)",rs.getGrade(),rs.getExamCode(),rs.getStudentId(),rs.getResult())){
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
