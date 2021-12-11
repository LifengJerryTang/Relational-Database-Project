package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller3 {
    @FXML
    private Button register;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField uname;
    @FXML
    private Button back;
    @FXML
    private PasswordField pwd;
    @FXML
    private PasswordField cpwd;

    public void GetUserInfo(ActionEvent e) throws Exception {
        Stage stage = null;
        Parent myNewscene = null;
        String pass = pwd.getText();
        String cpass = cpwd.getText();
        if (pass.equals(cpass)) {
            String username = uname.getText();
            String firstname = fname.getText();
            String lastname = lname.getText();
            String password = pwd.getText();

            StoredProcedure procedure = new StoredProcedure();
            DataOperation init = new DataOperation();
            init.connectDatabase();
            procedure.user_register(init.conn, username, password, firstname, lastname);
            init.conn.close();
            if (e.getSource() == register) {
                stage = (Stage) register.getScene().getWindow();
                myNewscene = FXMLLoader.load(getClass().getResource("screen1.fxml"));

            }
        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }

    public void BackToNavi(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewscene = null;
        if (event.getSource() == back) {
            stage = (Stage) back.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen2.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }
}