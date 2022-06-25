package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.budget;
import model.loginDetailTM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class LoginDetailFormController implements Initializable {

    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public TableView<loginDetailTM> loginTable;
    public TableColumn userId;
    public TableColumn loginDate;
    public TableColumn loginTime;



    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        loginDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        loginTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        try {
            ResultSet result=crudUtil.execute("SELECT * FROM userLogin");
            ObservableList<loginDetailTM> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new loginDetailTM(
                                result.getString("userId"),
                                result.getString("loginDate"),
                                result.getString("loginTime")
                        )
                );
            }
            loginTable.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }








    }
}
