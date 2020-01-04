package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller5{
    @FXML
    private Button backButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField unameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField zipcodeField;
    @FXML
    private ChoiceBox stateBox;
    @FXML
    private ChoiceBox companyBox;


    public void Navi(ActionEvent event) throws IOException {

        Stage stage = null;
        Parent myNewscene = null;
        System.out.println(event.getSource());

        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }

    public void Register(ActionEvent event) throws Exception {

        Stage stage = null;
        Parent myNewscene = null;
        String password = this.passwordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();

        if (password.equals(confirmPassword)) {

            String username = this.unameField.getText();

            String firstname = this.fnameField.getText();
            String lastname = this.lnameField.getText();
            String company = this.companyBox.getValue().toString();

            String city = this.cityField.getText();
            String street = this.addressField.getText();
            String state = this.stateBox.getValue().toString();
            String zipcode = this.zipcodeField.getText();

            StoredProcedure procedure = new StoredProcedure();
            DataOperation init = new DataOperation();
            init.connectDatabase();
            procedure.manager_only_register(init.conn, username, password, firstname, lastname, company, street, city, state, zipcode);
            init.conn.close();
//            System.out.println(username);
//            System.out.println(password);
//            System.out.println(firstname);
//            System.out.println(lastname);
//            System.out.println(company);
//            System.out.println(city);
//            System.out.println(street);
//            System.out.println(state);
//            System.out.println(zipcode);

            if (event.getSource() == registerButton) {

                stage = (Stage) registerButton.getScene().getWindow();
                myNewscene = FXMLLoader.load(getClass().getResource("screen1.fxml"));

            }

            Scene scene = new Scene(myNewscene);
            stage.setScene(scene);
            stage.setTitle("Atlantic Movie");
            stage.show();

        }
    }
}