package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.employeeAttendanceTM;
import model.teacherAttendanceTM;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeAttendanceFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public JFXTextField checkName;
    public TableColumn year;
    public TableColumn employeeId;
    public TableColumn month;
    public TableColumn date;
    public TableColumn status;
    public TableView<employeeAttendanceTM> employeeAttendanceTable;
    public JFXButton checkDetailId;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM employeeAttendance WHERE employeeId=?",checkID.getText());
        ObservableList<employeeAttendanceTM> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new employeeAttendanceTM(
                            result.getString("employeeId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getString("date"),
                            result.getString("status")
                    )
            );
        }
        employeeAttendanceTable.setItems(obList);
    }

    public void goToBack(ActionEvent actionEvent) {
    smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            checkDetailId.requestFocus();
            searchResult();
        }
    }
}
