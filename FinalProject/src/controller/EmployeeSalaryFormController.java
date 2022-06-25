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
import model.employeeSalary;
import model.teacherSalary;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeSalaryFormController implements Initializable {
    public JFXTextField checkID;
    public JFXTextField checkName;
    public TableView<employeeSalary> employeeSalaryTable;
    public TableColumn year;
    public TableColumn employeeId;
    public TableColumn month;
    public TableColumn amount;
    public AnchorPane smallContext;
    public JFXButton checkDetailId;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM employeesalary WHERE employeeId=?",checkID.getText());
        ObservableList<employeeSalary> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new employeeSalary(
                            result.getString("employeeId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getDouble("amount")
                    )
            );
        }
        employeeSalaryTable.setItems(obList);
    }


    public void goToBack(ActionEvent actionEvent) {
    smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
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
