package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;
import java.sql.ResultSet;

public class Screen1Controller {
    @FXML
    private Button register;
    @FXML
    private Button login;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;


    public void GetLoginInfo(ActionEvent e) throws Exception {
        String user = username.getText();
        String pwd = password.getText();

        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        ResultSet rs = procedures.user_login(init.conn, user, pwd);

        Stage stage = null;
        Parent myNewscene = null;
        rs.next();
        String isCustomer = rs.getObject("isCustomer").toString();
        String isAdmin = rs.getObject("isAdmin").toString();
        String isManager = rs.getObject("isManager").toString();
        String status = rs.getObject("status").toString();
        System.out.println(rs.getObject("isCustomer"));
        if (isCustomer.equals("0") && isAdmin.equals("0") && isManager.equals("0") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen12.fxml"));
        }
        else if (isCustomer.equals("0") && isAdmin.equals("0") && isManager.equals("1") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen9.fxml"));
        }
        else if (isCustomer.equals("0") && isAdmin.equals("1") && isManager.equals("0") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen7.fxml"));
        }
        else if (isCustomer.equals("1") && isAdmin.equals("1") && isManager.equals("0") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen8.fxml"));
        }
        else if (isCustomer.equals("1") && isAdmin.equals("0") && isManager.equals("1") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen10.fxml"));
        }
        else if (isCustomer.equals("1") && isAdmin.equals("0") && isManager.equals("0") && status.equals("Approved")) {
            stage = (Stage) login.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen11.fxml"));
        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }

    public void BackToNavi(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewscene = null;
        if (event.getSource() == register) {
            stage = (Stage) register.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }

}