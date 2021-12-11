package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen19Controller{
    @FXML private ComboBox<String> combo;
    @FXML private DatePicker reDatePicker;
    @FXML private DatePicker plDatePicker;
    @FXML private Button backButton;

    private String reDate;
    private String plDate;
    private String comboValue;

    ObservableList<String> list = FXCollections.observableArrayList();
    public void initialize()throws Exception{
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select movName from team32.movie");
        ResultSet rs0 = st.executeQuery(sq0);
        while(rs0.next()) {
            list.add(rs0.getObject("movName").toString());
        }
        combo.setItems(list);
        rs0.close();

    }

    public void action()throws Exception{
        reDate = reDatePicker.getValue().toString();
        plDate = plDatePicker.getValue().toString();
        comboValue = combo.getValue();
        System.out.println(combo.getValue());
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select username from team32.UserLogin");
        ResultSet rs0 = st.executeQuery(sq0);
        rs0.next();
        String manUserName = rs0.getObject("username").toString();  //  change to the login type
        procedures.manager_schedule_mov(init.conn, manUserName, comboValue, reDate, plDate);


    }

    @FXML
    private void backToManFunc(ActionEvent event) throws Exception {

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

        if (isCustomer.equals("0") && isManager.equals("1") && isAdmin.equals("0")) {


            backToFileName = "Screen9.fxml"; //Screen 9: Manager-only Functionality

        } else if (isCustomer.equals("1") && isManager.equals("1") && isAdmin.equals("0")) {


            backToFileName = "Screen10.fxml"; //Screen10: Manager-Cus Functionality

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