package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.studentPayment;
import model.teacherSalary;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherSalaryFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public JFXTextField checkName;
    public TableView<teacherSalary> teacherSalaryTable;
    public TableColumn teacherId;
    public TableColumn year;
    public TableColumn month;
    public TableColumn amount;
    public JFXButton checkDetailId;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM teachersalary WHERE teacherId=?",checkID.getText());
        ObservableList<teacherSalary> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new teacherSalary(
                            result.getString("teacherId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getDouble("amount")
                    )
            );
        }
        teacherSalaryTable.setItems(obList);
    }

    public void backToGo(ActionEvent actionEvent) {
    smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherId.setCellValueFactory(new PropertyValueFactory<>("teacherId"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            checkDetailId.requestFocus();
            searchResult();
        }
    }
}
