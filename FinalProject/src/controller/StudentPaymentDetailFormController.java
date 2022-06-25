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
import model.teacherAttendanceTM;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentPaymentDetailFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public JFXTextField checkName;
    public TableView<studentPayment> paymentTBL;
    public TableColumn year;
    public TableColumn studentId;
    public TableColumn month;
    public TableColumn amount;
    public JFXButton checkDetailId;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM studentpayment WHERE studentId=?",checkID.getText());
        ObservableList<studentPayment> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new studentPayment(
                            result.getString("studentId"),
                            result.getInt("year"),
                            result.getString("month"),
                            result.getDouble("amount")
                    )
            );
        }
        paymentTBL.setItems(obList);

    }

    public void goToBack(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        amount.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            checkDetailId.requestFocus();
            searchResult();
        }
    }
}
