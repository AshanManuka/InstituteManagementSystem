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
import model.employeeMTMM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class EmployeDetailFormController implements Initializable {
    public AnchorPane context;
    public TableView<employeeMTMM> employeeTable;
    public TableColumn eID;
    public TableColumn eName;
    public TableColumn eAddress;
    public TableColumn eSalary;
    public Label timeID;
    public Label dateID;
    public TableColumn contact;

    public void goToBack(MouseEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();

        eID.setCellValueFactory(new PropertyValueFactory<>("empId"));
        eName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        eAddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));
        eSalary.setCellValueFactory(new PropertyValueFactory<>("empSalary"));
        contact.setCellValueFactory(new PropertyValueFactory<>("empContact"));

        try {
            ResultSet result= crudUtil.execute("SELECT * FROM employee");
            ObservableList<employeeMTMM> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new employeeMTMM(
                                result.getString("employeeId"),
                                result.getString("employeeName"),
                                result.getString("employeeAddress"),
                                result.getDouble("employeeSalary"),
                                result.getInt("employeeContact")
                        )
                );
            }
            employeeTable.setItems(obList);

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
