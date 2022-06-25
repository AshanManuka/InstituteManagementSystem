package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEmployeeFormController {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public Label showId;
    public Label showAddress;
    public Label showName;
    public Label showContact;
    public Label showSalary;
    public JFXTextField checkName;
    public JFXButton showDetailId;
    int j =0;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM employee WHERE employeeId=? OR employeeName=?",checkID.getText(),checkName.getText());
        if (result.next()) {
            showId.setText(result.getString(1));
            showName.setText(result.getString(2));
            showAddress.setText(result.getString(3));
            showSalary.setText(result.getString(4));
            showContact.setText(result.getString(5));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

    public void clearBTN(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (j==0){
                j++;
                checkName.requestFocus();
            }else if (j==1){
                showDetailId.requestFocus();
                searchResult();
            }
        }
    }
}
