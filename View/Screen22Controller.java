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

import java.sql.ResultSet;
import java.sql.Statement;

public class Screen22Controller {
    @FXML
    private TableView<Data22> tableview;
    @FXML
    private TableColumn<Data22, RadioButton> theater;
    @FXML
    private TableColumn<Data22, String> address;
    @FXML
    private TableColumn<Data22, String> company;

    @FXML
    private ComboBox<String> theaterNameBox;
    @FXML
    private ComboBox<String> companyNameBox;
    @FXML
    private ComboBox<String> stateBox;

    @FXML
    private TextField cityField;
    @FXML
    private DatePicker vdPicker;

    @FXML
    private Button backButton;

    private String tName;
    private String cName;
    private String city;
    private String state;
    private String vDate;
    private int count = 0;

    private ObservableList<String> thName = FXCollections.observableArrayList();
    private ObservableList<Data22> list = FXCollections.observableArrayList();

    public void initialize() throws Exception {
        theater.setCellValueFactory(new PropertyValueFactory<Data22, RadioButton>("thbutton"));
        address.setCellValueFactory(new PropertyValueFactory<Data22, String>("address"));
        company.setCellValueFactory(new PropertyValueFactory<Data22, String>("company"));

        //initialize thName thName.add()

        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select thName from team32.theater");
        ResultSet rs0 = st.executeQuery(sq0);
        thName.add("ALL");
        while (rs0.next()) {
            thName.add(rs0.getObject("thName").toString());
        }
        theaterNameBox.setItems(thName);
    }

    public void filterAction() throws Exception {
        list = FXCollections.observableArrayList();
        count = 0;

        tName = theaterNameBox.getValue();
        cName = companyNameBox.getValue();
        city = cityField.getText();
        state = stateBox.getValue();
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        ResultSet rs1 = procedures.user_filter_th(init.conn, tName, cName, city, state);
        while (rs1.next()) {
            count++;
            String totalAddress = new String(rs1.getObject("thStreet").toString() + "," +
                    rs1.getObject("thCity").toString() + "," + rs1.getObject("thState").toString() + " " +
                    rs1.getObject("thZipCode").toString());
            Data22 d1 = new Data22(rs1.getObject("thName").toString(), totalAddress,rs1.getObject("comName").toString());
            list.add(d1);
        }
        //rs=function()
        //list.add(rs.next); loop,count
        tableview.setItems(list);
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < count; ++i) {
            list.get(i).getThbutton().setToggleGroup(group);
        }
        init.conn.close();
        //list.get(index).getThButton().setToggleGroup(group);
    }

    public void logVisitAction() throws Exception{
        //check which radio button is selected:
        //list.get(index).getThButton().isSelected();
        //retrieve all the fields needed to pass to the backend function
        vDate = String.valueOf(vdPicker.getValue());
        for(int i = 0; i < count; ++i) {
            if(list.get(i).getThbutton().isSelected()) {
                StoredProcedure procedures = new StoredProcedure();
                DataOperation init = new DataOperation();
                init.connectDatabase();
                Statement st = init.conn.createStatement();
                String squsername = new String("select username from team32.UserLogin");
                ResultSet rsusername = st.executeQuery(squsername);
                rsusername.next();
                String username = rsusername.getObject("username").toString();
                procedures.user_visit_th(init.conn, list.get(i).getThbutton().getText(),
                        list.get(i).getCompany(),  vDate, username);

                break;
            }
        }
        //execute backend function
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

        } else if (isCustomer.equals("1") && isAdmin.equals("1")&& isManager.equals("0") ) {


            backToFileName = "Screen8.fxml"; //Screen 8: Administrator-Customer Functionality

        } else if (isCustomer.equals("1") && isAdmin.equals("0")&& isManager.equals("0") ) {


            backToFileName = "Screen11.fxml"; //Screen 11: Customer-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("1")&& isManager.equals("0") ) {


            backToFileName = "Screen7.fxml"; //Screen 11: Admin-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("0")&& isManager.equals("1") ) {


            backToFileName = "Screen9.fxml"; //Screen 11: Manager-Only Functionality

        } else if (isCustomer.equals("0") && isAdmin.equals("0")&& isManager.equals("0") ) {


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
