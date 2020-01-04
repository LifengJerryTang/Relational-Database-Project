package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Screen20Controller {
    @FXML
    private TableView<Data20> tableview;
    @FXML
    private TableColumn<Data20, RadioButton> movie;
    @FXML
    private TableColumn<Data20, String> theater;
    @FXML
    private TableColumn<Data20, String> address;
    @FXML
    private TableColumn<Data20, String> company;
    @FXML
    private TableColumn<Data20, String> pldate;

    @FXML
    private ComboBox<String> movieName;
    @FXML
    private ComboBox<String> companyName;
    @FXML
    private ComboBox<String> state;
    @FXML
    private ComboBox<String> cardnumber;
    @FXML
    private Button backButton;
    @FXML
    private TextField city;
    @FXML
    private DatePicker minDate;
    @FXML
    private DatePicker maxDate;

    private String mName;
    private String cName;
    private String cityName;
    private String sName;
    private String lowPlDate;
    private String upPlDate;
    private String cardN;
    private int count = 0; // number of movies after filter

    private ObservableList<String> movName = FXCollections.observableArrayList();    //store movie name
    private ObservableList<String> cn = FXCollections.observableArrayList();        // store cardnumber
    private ObservableList<Data20> list = FXCollections.observableArrayList();

    public void initialize() throws Exception {
        movie.setCellValueFactory(new PropertyValueFactory<Data20, RadioButton>("movie"));
        theater.setCellValueFactory(new PropertyValueFactory<Data20, String>("theater"));
        address.setCellValueFactory(new PropertyValueFactory<Data20, String>("address"));
        company.setCellValueFactory(new PropertyValueFactory<Data20, String>("company"));
        pldate.setCellValueFactory(new PropertyValueFactory<Data20, String>("pldate"));
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sq0 = new String("select movName from team32.movie");
        ResultSet rs0 = st.executeQuery(sq0);
        movName.add("ALL");
        while (rs0.next()) {
            movName.add(rs0.getObject("movName").toString());
        }

        Statement stname = init.conn.createStatement();
        String sqname = new String("select username from team32.UserLogin");
        ResultSet rsname = st.executeQuery(sqname);
        rsname.next();
        String cusUsername = rsname.getObject("username").toString();  //  change to the login type

        String sq1 = new String("select creditCardNum from customercreditcard where username = \"" + cusUsername + "\"");
        ResultSet rs1 = st.executeQuery(sq1);
        while (rs1.next()) {
            cn.add(rs1.getObject("creditCardNum").toString());
        }
        movieName.setItems(movName);
        cardnumber.setItems(cn);
    }

    public void filterAction() throws Exception {
        list = FXCollections.observableArrayList();
        count = 0;
        mName = movieName.getValue();
        cName = companyName.getValue();
        cityName = city.getText();
        sName = state.getValue();
        lowPlDate = String.valueOf(minDate.getValue());
        upPlDate = String.valueOf(maxDate.getValue());
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        //String manUsername = "georgep";
        ResultSet rsMoviePlay = procedures.customer_filter_mov(init.conn, mName, cName, cityName, sName, lowPlDate, upPlDate);
        while (rsMoviePlay.next()) {
            count++;
            String totalAddress = new String(rsMoviePlay.getObject("thStreet").toString() + "," +
                    rsMoviePlay.getObject("thCity").toString() + "," + rsMoviePlay.getObject("thState").toString() + " " +
                    rsMoviePlay.getObject("thZipCode").toString());
            Data20 d1 = new Data20(rsMoviePlay.getObject("movName").toString(), rsMoviePlay.getObject("thName").toString(),
                    totalAddress, rsMoviePlay.getObject("comName").toString(), rsMoviePlay.getObject("movPlayDate").toString());
            list.add(d1);
        }
        //rs=f();
        //list.add(rs.getObject); loop, need to count the total number of elements in the list

        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < count; ++i) {
            list.get(i).getMovie().setToggleGroup(group);
        }
        tableview.setItems(list);
        init.conn.close();
    }

    public void viewAction() throws Exception {
        cardN = cardnumber.getValue();
        //list.get(index).getMovie().setToggleGroup(group);
        //check which radio button is selected:
        //list.get(index).getMovie().isSelected();
        //System.out.println(count);
        for (int i = 0; i < count; ++i) {
            if (list.get(i).getMovie().isSelected()) {
                StoredProcedure procedures = new StoredProcedure();
                DataOperation init = new DataOperation();
                init.connectDatabase();
                //in order to get release date
                Statement st = init.conn.createStatement();
                String tempmovName = list.get(i).getMovie().getText();
                String sqReleaseDate = new String("select movReleaseDate from team32.movie where movName =" + "\"" + tempmovName + "\"");
                //System.out.println(sqReleaseDate);
                ResultSet rsReleaseDate = st.executeQuery(sqReleaseDate);
                rsReleaseDate.next();
                String movReleaseDate = rsReleaseDate.getObject("movReleaseDate").toString();
                System.out.println(movReleaseDate);
                //use stored procedure
                procedures.customer_view_mov(init.conn, cardN, tempmovName, movReleaseDate, list.get(i).getTheater(), list.get(i).getCompany(), list.get(i).getPldate());


                //find moviename
                // find releasedate
                //

                break;
            }

        }
        //retrieve all the fields needed to pass to the backend function


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
