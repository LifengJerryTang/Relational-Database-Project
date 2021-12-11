package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Screen23Controller {
    @FXML
    private TableView<Data23> tableview;
    @FXML
    private TableColumn<Data23, String> theater;
    @FXML
    private TableColumn<Data23, String> address;
    @FXML
    private TableColumn<Data23, String> company;
    @FXML
    private TableColumn<Data23, String> vdate;

    @FXML
    private ComboBox<String> combo;
    @FXML
    private DatePicker minDate;
    @FXML
    private DatePicker maxDate;
    @FXML
    private Button backButton;
    private String cName;
    private String lowDate;
    private String upDate;

    private ObservableList<Data23> list = FXCollections.observableArrayList();

    public void initialize() {
        theater.setCellValueFactory(new PropertyValueFactory<Data23, String>("theater"));
        address.setCellValueFactory(new PropertyValueFactory<Data23, String>("address"));
        company.setCellValueFactory(new PropertyValueFactory<Data23, String>("company"));
        vdate.setCellValueFactory(new PropertyValueFactory<Data23, String>("visitdate"));

    }

    public void filterAction() throws Exception {
        list = FXCollections.observableArrayList(); //init
        cName = combo.getValue();
        lowDate = String.valueOf(minDate.getValue());
        upDate = String.valueOf(maxDate.getValue());
        System.out.println(cName + lowDate + upDate);


        DataOperation init = new DataOperation();
        StoredProcedure procedure = new StoredProcedure();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select username from team32.UserLogin");
        ResultSet rs0 = st.executeQuery(sq0);
        rs0.next();
        String username = rs0.getObject("username").toString();  //  change to the login type

        ResultSet rs1 = procedure.user_filter_visitHistory(init.conn, username, lowDate, upDate, cName);
        while (rs1.next()) {
            String totalAddress = new String(rs1.getObject("thStreet").toString() + "," +
                    rs1.getObject("thCity").toString() + "," + rs1.getObject("thState").toString() + " " +
                    rs1.getObject("thZipCode").toString());
            Data23 d1 = new Data23(rs1.getObject("thName").toString(), totalAddress,
                    rs1.getObject("comName").toString(), rs1.getObject("visitDate").toString());
            list.add(d1);
        }
        //rs=function();
        //rs.next()
        //rs.getObject().toString()
        //Data23 d1 = new Data23(.......)
        //list.add()d1
        tableview.setItems(list);
    }

    public void backToFunc(ActionEvent event) throws Exception {

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

        if (isCustomer.equals("1") && isManager.equals("1") && isAdmin.equals("0")) {


            backToFileName = "Screen10.fxml"; //Screen 10: Manager-Customer Functionality

        } else if (isCustomer.equals("1") && isAdmin.equals("1") && isManager.equals("0")) {


            backToFileName = "Screen8.fxml"; //Screen 8: Administrator-Customer Functionality

        } else if (isCustomer.equals("1") && isAdmin.equals("0") && isManager.equals("0")) {


            backToFileName = "Screen11.fxml"; //Screen 11: Customer-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("1") && isManager.equals("0")) {


            backToFileName = "Screen7.fxml"; //Screen 11: Admin-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("0") && isManager.equals("1")) {


            backToFileName = "Screen9.fxml"; //Screen 11: Manager-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("0") && isManager.equals("0")) {


            backToFileName = "Screen12.fxml"; //Screen 11: User Functionality

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
