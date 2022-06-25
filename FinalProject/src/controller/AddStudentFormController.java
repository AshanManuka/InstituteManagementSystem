package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.student;
import util.crudUtil;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudentFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField studentID;
    public JFXTextField studentName;
    public JFXTextField studentAddress;
    public JFXTextField studentGrade;
    public JFXTextField studentContact;
    public JFXButton addStudent;

    public void addStudent(ActionEvent actionEvent) {
    setStudent();
    }

    private void setStudent() {
        student s1=new student(studentID.getText(),studentName.getText(),studentAddress.getText(),Integer.parseInt(studentGrade.getText()),Integer.parseInt(studentContact.getText()));
        try{
            if(crudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?)",s1.getStudentId(),s1.getStudentName(),s1.getStudentAddress(),s1.getStudentGrade(),s1.getStudentContact())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void clearPane(MouseEvent mouseEvent) {
        smallContext.getChildren().clear();
            }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addStudent.setDisable(true);
    }

    public void keyReleaseedAction(KeyEvent keyEvent) {
        String stId = studentID.getText();
        String stName = studentName.getText();
        String stAddress = studentAddress.getText();
        String stGrade = studentGrade.getText();
        String stContact = studentContact.getText();

        Pattern comStudentId = Pattern.compile("^(s)[0-9]{4}$");
        boolean matcherId = comStudentId.matcher(stId).matches();
        Pattern comStudentName = Pattern.compile("^[A-z ]{3,25}$");
        boolean matcherName = comStudentName.matcher(stName).matches();
        Pattern comStudentAddress = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        boolean matcherAddress = comStudentAddress.matcher(stAddress).matches();
        Pattern comStudentGrade = Pattern.compile("^[0-9]{1,2}$");
        boolean matcherGrade = comStudentGrade.matcher(stGrade).matches();
        Pattern comStudentContact = Pattern.compile("^[0-9]{9,10}$");
        boolean matcherContact = comStudentContact.matcher(stContact).matches();

        if (matcherId){
            studentID.setStyle("-fx-background-color: #81ecec");
            if (keyEvent.getCode() == KeyCode.ENTER){
             studentName.requestFocus();
            }
            if (matcherName){
                studentName.setStyle("-fx-background-color: #81ecec");
                if (keyEvent.getCode() == KeyCode.ENTER){
                    studentAddress.requestFocus();
                }
                if (matcherAddress){
                    studentAddress.setStyle("-fx-background-color: #81ecec");
                    if (keyEvent.getCode() == KeyCode.ENTER){
                    studentGrade.requestFocus();
                }
                    if (matcherGrade){
                        studentGrade.setStyle("-fx-background-color: #81ecec");
                        if (keyEvent.getCode() == KeyCode.ENTER){
                            studentContact.requestFocus();
                        }
                        if (matcherContact){
                            studentContact.setStyle("-fx-background-color: #81ecec");
                            addStudent.setDisable(false);
                            if (keyEvent.getCode() == KeyCode.ENTER){
                                addStudent.requestFocus();
                                setStudent();
                            }
                        }else{
                            studentContact.setStyle("-fx-background-color: FF987B");
                        }
                    }else{
                        studentGrade.setStyle("-fx-background-color: FF987B");
                    }
                }else{
                    studentAddress.setStyle("-fx-background-color: FF987B");
                }
            }else{
                studentName.setStyle("-fx-background-color: FF987B");
            }
        }else{
            studentID.setStyle("-fx-background-color: FF987B");
        }


    }

}
