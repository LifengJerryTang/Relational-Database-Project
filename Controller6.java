package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller6 {
    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;

    @FXML
    private TextField addCreditCardField;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField unameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private TextField streetAddressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField zipcodeField;

    @FXML
    private ChoiceBox stateBox;
    @FXML
    private ChoiceBox companyBox;

    @FXML
    private Label cr1;
    @FXML
    private Label cr2;
    @FXML
    private Label cr3;
    @FXML
    private Label cr4;
    @FXML
    private Label cr5;
    @FXML
    private Button r1;
    @FXML
    private Button r2;
    @FXML
    private Button r3;
    @FXML
    private Button r4;
    @FXML
    private Button r5;

    private int cardNum = 0;
    public void navi(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent myNewscene = null;
        String password = this.passwordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();

        if(password.equals(confirmPassword) && event.getSource() == registerButton) {

            String fname = this.fnameField.getText();
            String lname = this.lnameField.getText();
            String company = this.companyBox.getValue().toString();

            String uname = this.unameField.getText();


            String streetAddress = this.streetAddressField.getText();
            String city = this.cityField.getText();
            String state = this.stateBox.getValue().toString();
            String zipcode = this.zipcodeField.getText();

            String creditCard1 = this.cr1.getText();
            String creditCard2 = this.cr2.getText();
            String creditCard3 = this.cr3.getText();
            String creditCard4 = this.cr4.getText();
            String creditCard5 = this.cr5.getText();
            StoredProcedure procedure = new StoredProcedure();
            DataOperation init = new DataOperation();
            init.connectDatabase();
            procedure.manager_customer_register(init.conn, uname, password, fname, lname,company, streetAddress, city,state, zipcode);

            for(int i = 0; i < cardNum; ++i) {
                if(i == 0)
                    procedure.manager_customer_add_creditcard(init.conn, uname, creditCard1);
                else if (i == 1)
                    procedure.manager_customer_add_creditcard(init.conn, uname, creditCard2);
                else if (i == 2)
                    procedure.manager_customer_add_creditcard(init.conn, uname, creditCard3);
                else if (i == 3)
                    procedure.manager_customer_add_creditcard(init.conn, uname, creditCard4);
                else if (i == 4)
                    procedure.manager_customer_add_creditcard(init.conn, uname, creditCard5);
            }
            init.conn.close();
            cardNum = 0;

            stage = (Stage) registerButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen1.fxml"));
        }

/*
        System.out.println(fname);
        System.out.println(lname);
        System.out.println(company);
        System.out.println(uname);
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(streetAddress);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zipcode);
        System.out.println(creditCard1);
        System.out.println(creditCard2);
        System.out.println(creditCard3);
        System.out.println(creditCard4);
        System.out.println(creditCard5);*/
        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }
    public void addCard(ActionEvent event) throws IOException {
        String card1 = addCreditCardField.getText();
        if (cr1.getText().trim().equals("")) {
            cr1.setText(card1);
            addCreditCardField.clear();
            cardNum = 1;
        } else if (cr2.getText().trim().equals("")) {
            String card2 = addCreditCardField.getText();
            cr2.setText(card2);
            addCreditCardField.clear();
            cardNum = 2;
        } else if (cr3.getText().trim().equals("")) {
            String card3 = addCreditCardField.getText();
            cr3.setText(card3);
            addCreditCardField.clear();
            cardNum = 3;
        } else if (cr4.getText().trim().equals("")) {
            String card4 = addCreditCardField.getText();
            cr4.setText(card4);
            System.out.println(cr4);
            addCreditCardField.clear();
            cardNum = 4;
        } else if (cr5.getText().trim().equals("")) {
            String card5 = addCreditCardField.getText();
            cr5.setText(card5);
            addCreditCardField.clear();
            cardNum = 5;
        }
    }
    public void remove(ActionEvent event) throws IOException {
        if (event.getSource() == r1) {
            cr1.setText("");
            cardNum = 0;
        } else if (event.getSource() == r2) {
            cr2.setText("");
            cardNum = 1;
        } else if (event.getSource() == r3) {
            cr3.setText("");
            cardNum = 2;
        } else if (event.getSource() == r4) {
            cr4.setText("");
            cardNum = 3;
        } else if (event.getSource() == r5) {
            cr5.setText("");
            cardNum = 4;
        }
    }
}

