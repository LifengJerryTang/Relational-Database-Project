package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller4 {
    @FXML
    private Button backButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField addCreditCardField;
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

    private int cardNum = 0;

    public void BackToNavi(ActionEvent event) throws IOException {

        Stage stage = null;
        Parent myNewscene = null;

        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }

    public void AddCard(ActionEvent event) throws IOException {

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

    public void getInfo(ActionEvent e) throws Exception {

        Stage stage = null;
        Parent myNewscene = null;
        String pass = this.passwordField.getText();
        String cpass = this.confirmPasswordField.getText();
        String username = this.unameField.getText();
        String firstname = this.fnameField.getText();
        String lastname = this.lnameField.getText();
        String password = this.passwordField.getText();
        String creditCard1 = this.cr1.getText();
        String creditCard2 = this.cr2.getText();
        String creditCard3 = this.cr3.getText();
        String creditCard4 = this.cr4.getText();
        String creditCard5 = this.cr5.getText();
        if (pass.equals(cpass)) {


            StoredProcedure procedure = new StoredProcedure();
            DataOperation init = new DataOperation();
            init.connectDatabase();
            procedure.customer_only_register(init.conn, username, password, firstname, lastname);

            for (int i = 0; i < cardNum; ++i) {
                if (i == 0)
                    procedure.customer_add_credit_card(init.conn, username, creditCard1);
                else if (i == 1)
                    procedure.customer_add_credit_card(init.conn, username, creditCard2);
                else if (i == 2)
                    procedure.customer_add_credit_card(init.conn, username, creditCard3);
                else if (i == 3)
                    procedure.customer_add_credit_card(init.conn, username, creditCard4);
                else if (i == 4)
                    procedure.customer_add_credit_card(init.conn, username, creditCard5);
            }

            init.conn.close();
            cardNum = 0;
            System.out.println(firstname);
            System.out.println(lastname);
            System.out.println(username);
            System.out.println(password);

            System.out.println(creditCard1);
            System.out.println(creditCard2);
            System.out.println(creditCard3);
            System.out.println(creditCard4);
            System.out.println(creditCard5);

        }

        if (e.getSource() == registerButton) {

            stage = (Stage) registerButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen12.fxml"));

        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }
}
