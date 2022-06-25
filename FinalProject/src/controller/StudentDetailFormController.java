package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.studentMTM;
import model.studentMTMM;
import model.teacherMTMM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentDetailFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public TableView<studentMTMM> studentTable;
    public TableColumn studentId;
    public TableColumn studentName;
    public TableColumn studentAddress;
    public TableColumn studentGrade;
    public TableColumn studentContact;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void doneBtn(ActionEvent actionEvent) {
        System.out.println("set functions");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();

        studentId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("stName"));
        studentAddress.setCellValueFactory(new PropertyValueFactory<>("stAddress"));
        studentGrade.setCellValueFactory(new PropertyValueFactory<>("stGrade"));
        studentContact.setCellValueFactory(new PropertyValueFactory<>("stContact"));

        try {
            ResultSet result= crudUtil.execute("SELECT * FROM student");
            ObservableList<studentMTMM> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new studentMTMM(
                                result.getString("studentId"),
                                result.getString("studentName"),
                                result.getString("studentAddress"),
                                result.getInt("studentGrade"),
                                result.getInt("studentContact")
                        )
                );
            }
            studentTable.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setTime(){
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm:ss aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    timeID.setText(times);
                });
            }
        });
        thread.start();

    }

}
