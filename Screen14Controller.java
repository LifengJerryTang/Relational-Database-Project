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


public class Screen14Controller {

    @FXML private ChoiceBox companyNames;
    @FXML private TextField minCitiesField;
    @FXML private TextField maxCitiesField;
    @FXML private TextField minEmployeesField;
    @FXML private TextField maxEmployeesField;
    @FXML private TextField minTheatersField;
    @FXML private TextField maxTheatersField;
    @FXML private Button filterButton;
    @FXML private Button createTheaterButton;
    @FXML private Button detailButton;
    @FXML private Button backButton;

    @FXML private TableView<Data14> tableview;
    @FXML private TableColumn<Data14,RadioButton> name;
    @FXML private TableColumn<Data14,String> city;
    @FXML private TableColumn<Data14,String> theater;
    @FXML private TableColumn<Data14,String> employee;

    private String cName;
    private String minCity;
    private String maxCity;
    private String minTheater;
    private String maxTheater;
    private String minEmployee;
    private String maxEmployee;


    private int count = 0;
    private ObservableList<Data14> list = FXCollections.observableArrayList();

    public void initialize(){
        name.setCellValueFactory(new PropertyValueFactory<Data14,RadioButton>("name"));
        city.setCellValueFactory(new PropertyValueFactory<Data14,String>("city"));
        theater.setCellValueFactory(new PropertyValueFactory<Data14,String>("theater"));
        employee.setCellValueFactory(new PropertyValueFactory<Data14,String>("employee"));
    }

    public void filter(ActionEvent e) throws Exception{
        list = FXCollections.observableArrayList();
        count = 0;

        cName = companyNames.getValue().toString();
        minCity = minCitiesField.getText();
        maxCity = maxCitiesField.getText();
        minTheater = minTheatersField.getText();
        maxTheater = maxTheatersField.getText();
        minEmployee = minEmployeesField.getText();
        maxEmployee = maxEmployeesField.getText();
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        ResultSet rs1 = procedures.admin_filter_company(init.conn, cName, minCity,
                maxCity, minTheater, maxTheater, minEmployee, maxEmployee,"", "");
        while(rs1.next()) {
            ++count;
            Data14 d1 = new Data14(rs1.getObject("comName").toString(),
                    rs1.getObject("numCityCover").toString(), rs1.getObject("numTheater").toString(),
                    rs1.getObject("numEmployee").toString());
            list.add(d1);
        }
        //rs=f();
        //rs.next
        //rs.getObject.toString
        //Data13 d1 = new Data13(.....)
        //list.add(d1); loop, need to count the total number of elements in the list

        tableview.setItems(list);

        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < count; ++i) {
            list.get(i).getName().setToggleGroup(group);
        }
        //list.get(index).Name().setToggleGroup(group);

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

    public void createTheater(ActionEvent event) throws IOException {

        //String companyName = companyNames.getValue().toString();
        //Stage stage = null;

        //FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen14.fxml"));
        //Parent myNewscene = loader.load();
        //Parent myNewscene = null;

//        if (event.getSource() == createTheaterButton) {
//            stage = (Stage) createTheaterButton.getScene().getWindow();
//            myNewscene = FXMLLoader.load(getClass().getResource("Screen15.fxml"));
//            //Scene scene = primaryStage.getScene();
//            //Screen15Controller controller15 = loader.getController();
//            //controller15.setComName(companyName);
//        }
//        Scene scene = new Scene(myNewscene);
//        stage.setScene(scene);
//        stage.setTitle("Atlantic Movie");
//        stage.show();

        Parent root = FXMLLoader.load(getClass().getResource("Screen15.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Atlanta Movie");
        stage.setScene(new Scene(root,640,400));
        stage.show();

    }

    public void viewCompanyDetail(ActionEvent event) throws Exception {
//        Stage stage = null;
//
//        Parent myNewscene = null;
//
//        if (event.getSource() == detailButton) {
//            stage = (Stage) detailButton.getScene().getWindow();
//            myNewscene = FXMLLoader.load(getClass().getResource("Screen16.fxml"));
//
//        }
//        Scene scene = new Scene(myNewscene);
//        stage.setScene(scene);
//        stage.setTitle("Atlantic Movie");
//        stage.show();

       String selectName;


        String totalEmployees;
        ObservableList<Data16> list16 = FXCollections.observableArrayList();


        for(int i = 0; i < count; ++i) {
            if(list.get(i).getName().isSelected()) {
                StoredProcedure procedures = new StoredProcedure();
                DataOperation init = new DataOperation();
                init.connectDatabase();
                selectName = list.get(i).getName().getText();
                System.out.println(selectName);
                procedures.test_for_phase4(init.conn,selectName);
                break;
            }
        }
        //check which radio button is selected:
        //list.get(i).getName().isSelected();
        //if selected, cName = list.get(i).getName().getText()
        //totalEmployees, need to add up strings
        //retrieve all the fields needed to pass to the backend function, execute backend function
        //need to initialize list16


        //controller16.setEmployeesLabel(totalEmployees);
        Parent root = FXMLLoader.load(getClass().getResource("Screen16.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Atlanta Movie");
        stage.setScene(new Scene(root,640,400));
        stage.show();
    }



}
