package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.examTM;
import model.resultTM;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowResultFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXComboBox gradeList;
    public TableView<resultTM> resultTable;
    public TableColumn examCode;
    public TableColumn studentId;
    public TableColumn result;
    public JFXTextField checkId;
    public TableColumn grade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] gradeArray={"1","2","3","3","4","5","6","7","8","9","10","11"};
        gradeList.getItems().addAll(gradeArray);

        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        examCode.setCellValueFactory(new PropertyValueFactory<>("examCode"));
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        result.setCellValueFactory(new PropertyValueFactory<>("results"));


        gradeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String sGrade= String.valueOf(newValue);

            try {
                ResultSet result= crudUtil.execute("SELECT * FROM result WHERE grade=? AND studentId=? ",sGrade,checkId.getText());
                ObservableList<resultTM> obList = FXCollections.observableArrayList();
                while (result.next()){
                    obList.add(
                            new resultTM(
                                    result.getInt("grade"),
                                    result.getString("examCode"),
                                    result.getString("studentId"),
                                    result.getDouble("results")

                            )
                    );
                }
                resultTable.setItems(obList);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        });






    }

    public void doneBtn(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }
}


