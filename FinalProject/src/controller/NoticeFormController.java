package controller;

import com.jfoenix.controls.JFXTextField;
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
import model.examTM;
import model.noticeTM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class NoticeFormController implements Initializable {
    public AnchorPane context;
    public Label timeID;
    public Label dateID;
    public TextArea inputNotice;
    public TableView<noticeTM> noticeTable;
    public TableColumn NoticeDate;
    public TableColumn NoticeDesc;
    public TextField rDate;

    public void goToBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/userDashboardForm.fxml"));
        context.getChildren().add(parent);
    }

    public void setNoticeBtn(ActionEvent actionEvent) {

    noticeTM n1 = new noticeTM(rDate.getText(),inputNotice.getText());
        try{
            if(crudUtil.execute("INSERT INTO notice VALUES (?,?)",n1.getDate(),n1.getNotice())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String dates = dateTime.setDate();
        dateID.setText(dates);
        setTime();
        NoticeDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        NoticeDesc.setCellValueFactory(new PropertyValueFactory<>("notice"));


    }

    public void showNoticeBtn(ActionEvent actionEvent) {

        try {
            ResultSet result=crudUtil.execute("SELECT * FROM notice");
            ObservableList<noticeTM> obList = FXCollections.observableArrayList();
            while (result.next()){
                obList.add(
                        new noticeTM(
                                result.getString("date"),
                                result.getString("description")
                        )
                );
            }
            noticeTable.setItems(obList);

        } catch (SQLException  | ClassNotFoundException e) {
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
