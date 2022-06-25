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
import model.teacherMTMM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TeacherDetailFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public TableView<teacherMTMM> teacherTable;
    public TableColumn TeacherID;
    public TableColumn teacherName;
    public TableColumn teacherAddress;
    public TableColumn teacherSalary;
    public TableColumn teacherContact;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void doneBtn(ActionEvent actionEvent) {
        System.out.println("set Function");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();

        TeacherID.setCellValueFactory(new PropertyValueFactory<>("teID"));
        teacherName.setCellValueFactory(new PropertyValueFactory<>("teNAME"));
        teacherAddress.setCellValueFactory(new PropertyValueFactory<>("teADDRESS"));
        teacherSalary.setCellValueFactory(new PropertyValueFactory<>("teSALARY"));
        teacherContact.setCellValueFactory(new PropertyValueFactory<>("teCONTACT"));

        try {
            ResultSet result= crudUtil.execute("SELECT * FROM teacher");
            ObservableList<teacherMTMM> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new teacherMTMM(
                                result.getString("teacherId"),
                                result.getString("teacherName"),
                                result.getString("teacherAddress"),
                                result.getDouble("teacherSalary"),
                                result.getInt("teacherContact")
                        )
                );
            }
            teacherTable.setItems(obList);

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
