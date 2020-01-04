package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class Screen13Controller {

    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox statusBox;

    @FXML
    private TableView<Data13> tableview;
    @FXML
    private TableColumn<Data13, RadioButton> username;
    @FXML
    private TableColumn<Data13, String> creditcardnumber;
    @FXML
    private TableColumn<Data13, String> usertype;
    @FXML
    private TableColumn<Data13, String> status;

    @FXML
    private Button filterButton;
    @FXML
    private Button approveButton;
    @FXML
    private Button declineButton;
    @FXML
    private Button backButton;

    private String uName;
    private String Status;
    private int count = 0;

    private ObservableList<Data13> list = FXCollections.observableArrayList();

    public void initialize() {
        username.setCellValueFactory(new PropertyValueFactory<Data13, RadioButton>("username"));
        creditcardnumber.setCellValueFactory(new PropertyValueFactory<Data13, String>("creditcount"));
        usertype.setCellValueFactory(new PropertyValueFactory<Data13, String>("usertype"));
        status.setCellValueFactory(new PropertyValueFactory<Data13, String>("status"));

    }

    public void filterAction() throws Exception {
        list = FXCollections.observableArrayList();
        count = 0;

        uName = usernameField.getText();
        Status = statusBox.getValue().toString();
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        ResultSet rs1 = procedures.admin_filter_user(init.conn, uName, Status, "username", "DESC");
        while (rs1.next()) {
            Data13 d1 = new Data13(rs1.getObject("username").toString(),
                    rs1.getObject("creditCardCount").toString(), rs1.getObject("userType").toString(),
                    rs1.getObject("status").toString());
            list.add(d1);
            ++count;
        }
        //rs=f();
        //rs.next
        //rs.getObject.toString
        //Data13 d1 = new Data13(.....)
        //list.add(d1); loop, need to count the total number of elements in the list

        tableview.setItems(list);

        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < count; ++i) {
            list.get(i).getUsername().setToggleGroup(group);
        }


        tableview.setItems(list);
        init.conn.close();
    }

    public void approveAction() throws Exception {
        for (int i = 0; i < count; ++i) {
            if (list.get(i).getUsername().isSelected()) {
                StoredProcedure procedures = new StoredProcedure();
                DataOperation init = new DataOperation();
                init.connectDatabase();
                procedures.admin_approve_user(init.conn, list.get(i).getUsername().getText());
                //list.get(i).setStatus("Approved");

                break;
            }
        }
        filterAction();
        //check which radio button is selected:
        //list.get(index).getUsername().isSelected();
        //if selected, list.get(i).setStatus("Approved");
        //retrieve all the fields needed to pass to the backend function, execute backend function
        //tableview.setItems(list);
    }

    public void declineAction() throws Exception{
        for (int i = 0; i < count; ++i) {
            if (list.get(i).getUsername().isSelected()) {
                StoredProcedure procedures = new StoredProcedure();
                DataOperation init = new DataOperation();
                init.connectDatabase();
                procedures.admin_decline_user(init.conn, list.get(i).getUsername().getText());
                break;
            }
        }
        filterAction();
        //check which radio button is selected:
        //list.get(index).getUsername().isSelected();
        //if selected, list.get(i).setStatus("Approved");
        //retrieve all the fields needed to pass to the backend function, execute backend function
        //tableview.setItems(list);
        //check which radio button is selected:
        //list.get(index).getUsername().isSelected();
        //if selected, list.get(i).setStatus("Declined");
        //retrieve all the fields needed to pass to the backend function, execute backend function


    }


//    public void filter(ActionEvent e) {
//
//        String currentStatus = statusBox.getValue().toString();
//        System.out.println(currentStatus);
//
//    }

//    public void action(ActionEvent e) {
//
//        String userName;
//        String status;
//
//        if (e.getSource() == approveButton) {
//
//            userName = usernameField.getText();
//            status = statusBox.getValue().toString();
//
//            System.out.println(userName);
//
//        } else if (e.getSource() == declineButton) {
//
//
//
//        } else if (e.getSource() == filterButton) {
//
//
//
//        }
//
//    }

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
