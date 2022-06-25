package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.loginDetailTM;
import util.crudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerLoginFormController {
    public AnchorPane context;
    public JFXTextField uNameID;
    public JFXPasswordField uPasswordID;
    public JFXButton btnLogin;
    public JFXButton goBack;
    int i = 0;

    public void login(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
      setLogin();
    }

    private void setLogin() throws IOException, SQLException, ClassNotFoundException {

        String dates= String.valueOf(java.time.LocalDate.now());
        String times= String.valueOf(java.time.LocalTime.now());

        String uName=uNameID.getText();
        String uPass=uPasswordID.getText();

        ResultSet result1 = crudUtil.execute("SELECT userId FROM managerUser WHERE userName=?",uName);
        ResultSet result2 = crudUtil.execute("SELECT userId FROM managerUser WHERE password=?",uPass);

        if (result1.next() && result2.next()){
            String uname = result1.getString(1);
            String upass = result1.getString(1);


            if (uname.equals(upass)){

                ResultSet resultSet = crudUtil.execute("SELECT userName FROM user WHERE userId=?",uname);
                if (resultSet.next()){
                    String setName = resultSet.getString(1);
                    UserDashboardFormController.sName=setName;
                }

                Parent parent = FXMLLoader.load(getClass().getResource("../view/managementDashBoardForm.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.show();

                Stage stage1 = (Stage) btnLogin.getScene().getWindow();
                stage1.close();

                loginDetailTM ld = new loginDetailTM(uname,dates,times);

                try {
                    crudUtil.execute("INSERT INTO userLogin VALUES(?,?,?)",uname,dates,times);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Wrong UserName or Password").show();
        }

    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/homeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();

        Stage stage = (Stage) goBack.getScene().getWindow();
        stage.close();
    }

    public void keyAction(KeyEvent keyEvent) throws SQLException, IOException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (i==0){
                i++;
                uPasswordID.requestFocus();
            }else if (i==1){
                btnLogin.requestFocus();
                setLogin();
            }
        }
    }
}
