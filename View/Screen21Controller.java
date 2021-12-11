package sample;

import javafx.beans.value.ObservableSetValue;
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

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen21Controller {

    @FXML
    private TableView<Data21> data21TableView;
    @FXML
    private TableColumn<Data21, String> movie;
    @FXML
    private TableColumn<Data21, String> theater;
    @FXML
    private TableColumn<Data21, String> company;
    @FXML
    private TableColumn<Data21, String> cardNum;
    @FXML
    private TableColumn<Data21, String> viewDate;

    @FXML
    private Button backButton;

    public ObservableList<Data21> list = FXCollections.observableArrayList();

    public void initialize() throws Exception{
        //Data21 test = new Data21("1","2","3","4","5");
        //list.add(test);
        DataOperation init = new DataOperation();
        StoredProcedure procedure = new StoredProcedure();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select username from team32.UserLogin");
        ResultSet rs0 = st.executeQuery(sq0);
        rs0.next();
        String username = rs0.getObject("username").toString();  //  change to the login type

        ResultSet rsHistory = procedure.customer_view_history(init.conn, username);
        while (rsHistory.next()) {
            Data21 d1 = new Data21(rsHistory.getObject("movName").toString(),
                    rsHistory.getObject("thName").toString(), rsHistory.getObject("comName").toString(),
                    rsHistory.getObject("creditCardNum").toString(),rsHistory.getObject("movPlayDate").toString());
            list.add(d1);
        }
        movie.setCellValueFactory(new PropertyValueFactory<Data21, String>("movie"));
        theater.setCellValueFactory(new PropertyValueFactory<Data21, String>("theater"));
        company.setCellValueFactory(new PropertyValueFactory<Data21, String>("company"));
        cardNum.setCellValueFactory(new PropertyValueFactory<Data21, String>("cardNum"));
        viewDate.setCellValueFactory(new PropertyValueFactory<Data21, String>("viewDate"));
        data21TableView.setItems(list);
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

        if (isCustomer.equals("1") && isManager.equals("0") && isAdmin.equals("1")) {


            backToFileName = "Screen8.fxml"; //Screen 9: Custom-Ad Functionality

        } else if (isCustomer.equals("1") && isManager.equals("1") && isAdmin.equals("0")) {


            backToFileName = "Screen10.fxml"; //Screen10: Manager-Cus Functionality

        } else if (isCustomer.equals("1") && isManager.equals("0") && isAdmin.equals("0")) {


            backToFileName = "Screen11.fxml"; //Screen10: Custom-Only Functionality

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
