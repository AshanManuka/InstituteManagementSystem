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
import model.studentAttendanceTM;
import model.teacherAttendanceTM;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherAttendanceFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public JFXTextField checkName;
    public TableColumn year;
    public TableView<teacherAttendanceTM> teacherAttendanceTable;
    public TableColumn teacherId;
    public TableColumn month;
    public TableColumn date;
    public TableColumn status;
    public JFXButton checkDetailId;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM teacherAttendance WHERE teacherId=?",checkID.getText());
        ObservableList<teacherAttendanceTM> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new teacherAttendanceTM(
                            result.getString("teacherId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getString("date"),
                            result.getString("status")
                    )
            );
        }
        teacherAttendanceTable.setItems(obList);
    }

    public void goToBack(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherId.setCellValueFactory(new PropertyValueFactory<>("teacherId"));
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
