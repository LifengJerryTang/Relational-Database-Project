package sample;

import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen18Controller {
    @FXML
    private TableView<Data18> data18TableView;
    @FXML
    private TableColumn<Data18, String> movie;
    @FXML
    private TableColumn<Data18, String> duration;
    @FXML
    private TableColumn<Data18, String> release;
    @FXML
    private TableColumn<Data18, String> play;

    @FXML
    private TextField movieNameField;
    @FXML
    private TextField lowDurationField;
    @FXML
    private TextField upDurationField;
    @FXML
    private DatePicker lowReDate;
    @FXML
    private DatePicker upReDate;
    @FXML
    private DatePicker lowPlDate;
    @FXML
    private DatePicker upPlDate;
    @FXML
    private CheckBox checkbox;
    @FXML
    private Button backButton;

    private String movieName;
    private String lowerDuration;
    private String upperDuration;
    private String lowerReleaseDate;
    private String upperReleaseDate;
    private String lowerPlayDate;
    private String upperPlayDate;
    private boolean isChecked;
    private ResultSet rs;


    public ObservableList<Data18> list = FXCollections.observableArrayList();


    public void initialize() {
        movie.setCellValueFactory(new PropertyValueFactory<Data18, String>("movie"));
        duration.setCellValueFactory(new PropertyValueFactory<Data18, String>("duration"));
        release.setCellValueFactory(new PropertyValueFactory<Data18, String>("release"));
        play.setCellValueFactory(new PropertyValueFactory<Data18, String>("play"));
    }

    public void addRow() throws Exception {
        list = FXCollections.observableArrayList();
        movieName = movieNameField.getText();
        lowerDuration = lowDurationField.getText();
        upperDuration = upDurationField.getText();
        lowerReleaseDate = String.valueOf(lowReDate.getValue());
        upperReleaseDate = String.valueOf(upReDate.getValue());
        lowerPlayDate = String.valueOf(lowPlDate.getValue());
        upperPlayDate = String.valueOf(upPlDate.getValue());
        isChecked = checkbox.isSelected();
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select username from team32.UserLogin");
        ResultSet rs0 = st.executeQuery(sq0);
        rs0.next();
        String manUsername = rs0.getObject("username").toString();  //  change to the login type

        ResultSet rs = procedures.manager_filter_th(init.conn, manUsername, movieName, lowerDuration, upperDuration,
                lowerReleaseDate, upperReleaseDate, lowerPlayDate, upperPlayDate, String.valueOf(isChecked));  //the function in procedure
        // find next line while exists
        while (rs.next()) {
            String tempPlayDate;
            if (String.valueOf(rs.getObject("movPlayDate")).equals("null")) {
                tempPlayDate = new String("");
            } else {
                tempPlayDate = String.valueOf(rs.getObject("movPlayDate"));
            }   // this is-else is for transfer "null" to ""
            Data18 d1 = new Data18(rs.getObject("movName").toString(), rs.getObject("movDuration").toString(),
                    rs.getObject("movReleaseDate").toString(), tempPlayDate);   //output per line
            list.add(d1); // add to list
        }

        data18TableView.setItems(list);
    }

    public void backToManFunc(ActionEvent event) throws Exception {

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
