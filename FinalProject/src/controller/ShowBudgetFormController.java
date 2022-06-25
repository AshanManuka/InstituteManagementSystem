package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.budget;
import util.crudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowBudgetFormController implements Initializable {
    public AnchorPane smallController;
    public TableView<budget> budgetDetailTable;
    public TableColumn discribtion;
    public TableColumn amount;
    public TableColumn type;
    public TableColumn year;
    public TableColumn month;

    public void goToBack(ActionEvent actionEvent) {
    smallController.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        discribtion.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        try {
            ResultSet result=crudUtil.execute("SELECT * FROM budget");
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
            budgetDetailTable.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
