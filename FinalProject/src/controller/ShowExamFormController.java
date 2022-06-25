package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.employeeAttendanceTM;
import model.exam;
import model.examTM;
import model.result;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowExamFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXComboBox<String> gradeList;
    public TableView<examTM> resultTable;
    public TableColumn examCode;
    public TableColumn examDate;
    public TableColumn examDuration;
    public TableColumn noOfStudent;
    public TableColumn teacherId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] gradeArray={"1","2","3","3","4","5","6","7","8","9","10","11"};
        gradeList.getItems().addAll(gradeArray);

        examCode.setCellValueFactory(new PropertyValueFactory<>("examCode"));
        examDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        examDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        teacherId.setCellValueFactory(new PropertyValueFactory<>("teacherId"));
        noOfStudent.setCellValueFactory(new PropertyValueFactory<>("noStudent"));


        gradeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           String selectedGrade = newValue;

            try {
                ResultSet result=crudUtil.execute("SELECT examCode, date, duration, teacherId, noStudent FROM exam WHERE grade=?",selectedGrade);
                ObservableList<examTM> obList = FXCollections.observableArrayList();
                while (result.next()){
                    obList.add(
                            new examTM(
                                    result.getString("examCode"),
                                    result.getString("date"),
                                    result.getDouble("duration"),
                                    result.getString("teacherId"),
                                    result.getInt("noStudent")
                            )
                    );
                }
                resultTable.setItems(obList);

            } catch (SQLException  | ClassNotFoundException e) {
                e.printStackTrace();
            }


        });


    }

    public void goToBack(ActionEvent actionEvent) {
        System.out.println("set functions");
    }

}
