package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.budget;
import util.crudUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SetbudgetFormController implements Initializable {
    public AnchorPane smallContext;
    public JFXTextField desc;
    public JFXTextField amountfee;
    public JFXButton addDetail;
    public JFXButton backToGo;
    public JFXTextField type;
    public ComboBox yearbox;
    public ComboBox monthbox;
    public JFXTextField Type;
    String selectedYear;
    String selectedMonth;


    public void addBudget(ActionEvent actionEvent) {
       setbudget();
    }

    private void setbudget() {
        budget b1= new budget(desc.getText(),Type.getText(),Integer.parseInt(selectedYear),selectedMonth,Double.parseDouble(amountfee.getText()));

        try{
            if(crudUtil.execute("INSERT INTO budget VALUES (?,?,?,?,?)",b1.getDescription(),b1.getType(),b1.getYear(),b1.getMonth(),b1.getAmount())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void cancelBtn(ActionEvent actionEvent) {
        smallContext.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] year={"2022","2023","2024","2025"};
        String[] month={"January","February","March","April","May","June","July","August","September","October","November","December"};

        yearbox.getItems().addAll(year);
        monthbox.getItems().addAll(month);

        yearbox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedYear = String.valueOf(newValue);
        });

        monthbox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedMonth = String.valueOf(newValue);
        });

    }


    public void keyAction(KeyEvent keyEvent) {
        String fType= Type.getText();
        Pattern type = Pattern.compile("(income)|(cost)");
        boolean matcherType = type.matcher(fType).matches();
        if (matcherType){
        Type.setStyle("-fx-background-color: #81ecec");
        }else {
            Type.setStyle("-fx-background-color: FF987B");
        }

    }
}
