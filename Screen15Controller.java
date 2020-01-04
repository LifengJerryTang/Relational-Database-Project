package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;


public class Screen15Controller {


    @FXML private TextField theaterNameField;
    @FXML private TextField streetAddressField;
    @FXML private TextField cityNameField;
    @FXML private TextField capacityField;
    @FXML private TextField zipcodeField;
    @FXML private ChoiceBox<String> companyNames;
    @FXML private ChoiceBox<String> states;
    @FXML private ChoiceBox<String> managers;
    @FXML private Button backButton;
    @FXML private Button createButton;
    private String cName;
    private ObservableList<String> list = FXCollections.observableArrayList();


    public void initialize(){
        companyNames.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try{
                    list = FXCollections.observableArrayList();
                    cName = t1;
                    StoredProcedure procedures = new StoredProcedure();
                    DataOperation init = new DataOperation();
                    init.connectDatabase();
                    Statement st = init.conn.createStatement();
                    String sq0 = new String("SELECT firstname, lastname " +
                            "from user " +
                            "where username in (SELECT username " +
                            "from manager " +
                            "where comName = \"" + cName + "\" and thName = \"\") and status = \"Approved\"");
                    System.out.println(sq0);
                    ResultSet rs0 = st.executeQuery(sq0);
                    while (rs0.next()) {
                        String totalname = new String (rs0.getObject("firstname").toString() +" "+
                                rs0.getObject("lastname").toString());
                        list.add(totalname);
                    }


                    //rs = execute sql; get fistname and lastname
                    //list.add(firstname + lastname)
                    managers.setItems(list);
                    init.conn.close();
                } catch(Exception e) {
                    System.out.println("something unknown happen");
                }

            }
        });

    }

    public void createTheater(ActionEvent e) throws Exception{
        String i_thName = theaterNameField.getText();
        String i_comName = companyNames.getValue().toString();
        String i_thStreet = theaterNameField.getText();
        String i_thCity = cityNameField.getText();
        String i_thState = states.getValue().toString();
        String i_thZipcode = zipcodeField.getText();
        String i_capacity = capacityField.getText();
        String i_managerUsername = managers.getValue().toString();
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        String arrayN[] = i_managerUsername.split(" ");
        String fisrtN = arrayN[0];
        String lastN = arrayN[1];
        //System.out.println(fisrtN + ", " + lastN);
        Statement st = init.conn.createStatement();
        String sqlusername = "select username from team32.user where firstname = \"" + fisrtN
                + "\" and lastname = \"" + lastN + "\"";
        ResultSet rsusername = st.executeQuery(sqlusername);
        rsusername.next();
        String trueusername = rsusername.getObject("username").toString();
        procedures.admin_create_theater(init.conn, i_thName,i_comName, i_thStreet,i_thCity,
                i_thState, i_thZipcode,i_capacity,trueusername);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

    }

    public void backToManageCompany(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
//        Stage stage = null;
//
//        Parent myNewscene = null;
//
//        if (event.getSource() == backButton) {
//            stage = (Stage) backButton.getScene().getWindow();
//            myNewscene = FXMLLoader.load(getClass().getResource("Screen14.fxml")); //Screen 14: Manage Company
//
//        }
//        Scene scene = new Scene(myNewscene);
//        stage.setScene(scene);
//        stage.setTitle("Atlantic Movie");
//        stage.show();
    }
}
