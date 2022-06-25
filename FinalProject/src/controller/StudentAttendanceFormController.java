package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.studentAttendanceTM;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentAttendanceFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public TableView<studentAttendanceTM> studentAttendace;
    public TableColumn studentIDT;
    public TableColumn year;
    public TableColumn month;
    public TableColumn date;
    public TableColumn status;
    public JFXButton checkDetailId;


    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM studentAttendance WHERE studentId=?",checkID.getText());
        ObservableList<studentAttendanceTM> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new studentAttendanceTM(
                            result.getString("studentId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getString("date"),
                            result.getString("status")
                    )
            );
        }
        studentAttendace.setItems(obList);
    }

    public void goToBack(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        studentIDT.setCellValueFactory(new PropertyValueFactory<>("studentId"));
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
