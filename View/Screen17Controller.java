package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Screen17Controller {

    @FXML
    private DatePicker movieReleaseDatePicker;
    @FXML
    private TextField movieNameField;
    @FXML
    private TextField movieDurationField;
    @FXML
    private Button backButton;
    String i_movReleaseDate;

    public void createMovie(ActionEvent e) throws Exception {

        String i_movName = movieNameField.getText();
        int i_movDuration = Integer.valueOf(movieDurationField.getText());
        System.out.println(i_movDuration);
        System.out.println(i_movName);
        System.out.println(i_movReleaseDate);

        StoredProcedure p17 = new StoredProcedure();
        DataOperation pm17 = new DataOperation();
        pm17.connectDatabase();
        p17.admin_create_mov(pm17.conn, i_movName, i_movDuration, i_movReleaseDate);
        pm17.conn.close();
    }

    public void extractDate(ActionEvent e) {

        i_movReleaseDate = (movieReleaseDatePicker.getValue().toString());

    }

    public void backToAdminFunc(ActionEvent event) throws Exception {

        Stage stage = null;

        Parent myNewscene = null;

        String backToFileName = null;

        DataOperation init = new DataOperation();
        StoredProcedure procedure = new StoredProcedure();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select isCustomer, isManager, isAdmin from team32.UserLogin");
        ResultSet rs0 = st.executeQuery(sq0);
        rs0.next();
        String isCustomer = new String(rs0.getObject("isCustomer").toString());
        String isManager = new String(rs0.getObject("isManager").toString());
        String isAdmin = new String(rs0.getObject("isAdmin").toString());
        System.out.println(rs0.getObject("isCustomer").toString());

        if (isCustomer.equals("1") && isManager.equals("0") && isAdmin.equals("1")) {


            backToFileName = "Screen8.fxml"; //Screen 8: Administrator-Customer Functionality

        } else if (isCustomer.equals("0") && isManager.equals("0") && isAdmin.equals("1")) {


            backToFileName = "Screen7.fxml"; //Screen7: Administrator-Only Functionality

        }
        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource(backToFileName));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();



    }
}