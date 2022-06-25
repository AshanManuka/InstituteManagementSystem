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

public class SearchStudentFormController {
    public AnchorPane smallContext;
    public JFXTextField checkID;
    public Label showId;
    public Label showAddress;
    public Label showName;
    public Label showContact;
    public Label showGrade;
    public JFXTextField checkName;
    public JFXButton showBTId;
    int i = 0;

    public void showDetailBTN(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      searchResult();
    }

    private void searchResult() throws SQLException, ClassNotFoundException {
        ResultSet result = crudUtil.execute("SELECT * FROM student WHERE studentId=? OR studentName=?",checkID.getText(),checkName.getText());
        if (result.next()) {
            showId.setText(result.getString(1));
            showName.setText(result.getString(2));
            showAddress.setText(result.getString(3));
            showGrade.setText(result.getString(4));
            showContact.setText(result.getString(5));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

    public void clearBTN(ActionEvent actionEvent) {
        System.out.println("set functionals");
        smallContext.getChildren().clear();
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (i==0){
                i++;
                checkName.requestFocus();
            }else if (i==1){
                showBTId.requestFocus();
                searchResult();
            }
        }
    }
}
