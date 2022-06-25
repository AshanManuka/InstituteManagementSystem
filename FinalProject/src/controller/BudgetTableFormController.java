package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.budget;
import model.calcAmount;
import model.examTM;
import model.result;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class BudgetTableFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public TableView<budget> budgetTable;
    public TableColumn budgetType;
    public TableColumn budgetDescribe;
    public TableColumn budgetAmount;
    public Label incomeLbl;
    public Label costLbl;
    public Label profitLbl;
    public ComboBox monthBox;
    public ComboBox yearBox;
    public TableColumn budgetYear;
    public TableColumn budgetMonth;
    String selectYear ="null";
    String selectMonth ="null";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();

        budgetDescribe.setCellValueFactory(new PropertyValueFactory<>("description"));
        budgetType.setCellValueFactory(new PropertyValueFactory<>("type"));
        budgetYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        budgetMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        budgetAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));


        try {
            ResultSet result= crudUtil.execute("SELECT * FROM budget");
            ObservableList<budget> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new budget(
                                result.getString("description"),
                                result.getString("type"),
                                result.getInt("year"),
                                result.getString("month"),
                                result.getDouble("amount")
                        )
                );
            }
            budgetTable.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String[] year={"2022","2023","2024","2025","2026"};
        String[] month={"January","February","March","April","May","June","July","August","September","October","November","December"};
        yearBox.getItems().addAll(year);
        monthBox.getItems().addAll(month);

        yearBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectYear = String.valueOf(newValue);
            System.out.println(selectYear);
        });
        monthBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectMonth = String.valueOf(newValue);
            System.out.println(selectMonth);
        });

    }



    public void doneBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        incomeLbl.setText(" ");
        costLbl.setText(" ");
        profitLbl.setText(" ");

        if(selectYear.equals("null") && selectMonth.equals("null")){
            new Alert(Alert.AlertType.WARNING, "Select Year or Month or Year & Month").show();
        }else if(selectMonth.equals("null")){
            double total1 = 0;
            double total2 = 0;
            double incomeTotal=0;
            double costTotal=0;
            double profit;

            ResultSet resultSet3 = crudUtil.execute("SELECT amount FROM budget WHERE type=? && year=?", "Income", selectYear);
            if (resultSet3.next()) {
                total1 = total1 + resultSet3.getDouble(1);
                incomeLbl.setText(String.valueOf(total1));
                incomeTotal=total1;
            }

            ResultSet resultSet2 = crudUtil.execute("SELECT amount FROM budget WHERE type=? && year=?", "cost", selectYear);
            if (resultSet2.next()) {
                total2 = total2 + resultSet2.getDouble(1);
                costLbl.setText(String.valueOf(total2));
                costTotal=total2;
            }
            profit=incomeTotal-costTotal;
            profitLbl.setText(String.valueOf(profit));

        }else{
            double total1 = 0;
            double total2 = 0;
            double incomeTotal=0;
            double costTotal=0;
            double profit;
            ResultSet resultSet1 = crudUtil.execute("SELECT amount FROM budget WHERE type=? && year=? && month=?", "Income", selectYear,selectMonth);
            if (resultSet1.next()) {
                total1 = total1 + resultSet1.getDouble(1);
                incomeLbl.setText(String.valueOf(total1));
                incomeTotal=total1;
            }

            ResultSet resultSet2 = crudUtil.execute("SELECT amount FROM budget WHERE type=? && year=? && month=?", "cost", selectYear,selectMonth);
            if (resultSet2.next()) {
                total2 = total2 + resultSet2.getDouble(1);
                costLbl.setText(String.valueOf(total2));
                costTotal=total2;
            }
            profit=incomeTotal-costTotal;
            profitLbl.setText(String.valueOf(profit));
        }
    }


    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashboardForm.fxml"));
        context.getChildren().add(parent);
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
