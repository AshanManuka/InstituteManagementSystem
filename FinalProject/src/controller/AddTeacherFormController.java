package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.teacher;
import util.crudUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddTeacherFormController implements Initializable {
    public AnchorPane smalllContext;
    public JFXTextField teacherID;
    public JFXTextField teacherName;
    public JFXTextField teacherAddress;
    public JFXTextField teacherSalary;
    public JFXTextField teacherContact;
    public JFXButton addTeacherId;

    public void addTeacher(ActionEvent actionEvent) {
        setTeacher();
    }

    private void setTeacher() {
        teacher t1=new teacher(teacherID.getText(),teacherName.getText(),teacherAddress.getText(),Double.parseDouble(teacherSalary.getText()),Integer.parseInt(teacherContact.getText()));

        try{
            if(crudUtil.execute("INSERT INTO teacher VALUES (?,?,?,?,?)",t1.getTeacherId(),t1.getTeacherName(),t1.getTeacherAddress(),t1.getTeacherSalary(),t1.getTeacherContact())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void clearPane(MouseEvent mouseEvent) {
        smalllContext.getChildren().clear();
    }

    public void keyReleaseAction(KeyEvent keyEvent) {
        String tId = teacherID.getText();
        String tName = teacherName.getText();
        String tAddress = teacherAddress.getText();
        String tSalary = teacherSalary.getText();
        String tContact = teacherContact.getText();

        Pattern comTeacherId = Pattern.compile("^(t)[0-9]{4}$");
        boolean matcherId = comTeacherId.matcher(tId).matches();
        Pattern comTeacherName = Pattern.compile("^[A-z ]{3,25}$");
        boolean matcherName = comTeacherName.matcher(tName).matches();
        Pattern comTeacherAddress = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        boolean matcherAddress = comTeacherAddress.matcher(tAddress).matches();
        Pattern comTeacherSalary = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");
        boolean matcherSalary = comTeacherSalary.matcher(tSalary).matches();
        Pattern comTeacherContact = Pattern.compile("^[0-9]{9,10}$");
        boolean matcherContact = comTeacherContact.matcher(tContact).matches();

        if (matcherId){
            teacherID.setStyle("-fx-background-color: #81ecec");
            if (keyEvent.getCode() == KeyCode.ENTER){
                teacherName.requestFocus();
            }
            if (matcherName){
                teacherName.setStyle("-fx-background-color: #81ecec");
                if (keyEvent.getCode() == KeyCode.ENTER){
                    teacherAddress.requestFocus();
                }
                if (matcherAddress){
                    teacherAddress.setStyle("-fx-background-color: #81ecec");
                    if (keyEvent.getCode() == KeyCode.ENTER){
                        teacherSalary.requestFocus();
                    }
                    if (matcherSalary){
                        teacherSalary.setStyle("-fx-background-color: #81ecec");
                        if (keyEvent.getCode() == KeyCode.ENTER){
                            teacherContact.requestFocus();
                        }
                        if (matcherContact){
                            teacherContact.setStyle("-fx-background-color: #81ecec");
                            addTeacherId.setDisable(false);
                            if (keyEvent.getCode() == KeyCode.ENTER){
                                addTeacherId.requestFocus();
                                setTeacher();
                            }
                        }else{
                            teacherContact.setStyle("-fx-background-color: FF987B");
                        }
                    }else{
                        teacherSalary.setStyle("-fx-background-color: FF987B");
                    }
                }else{
                    teacherAddress.setStyle("-fx-background-color: FF987B");
                }
            }else{
                teacherName.setStyle("-fx-background-color: FF987B");
            }
        }else{
            teacherID.setStyle("-fx-background-color: FF987B");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTeacherId.setDisable(true);
    }
}
