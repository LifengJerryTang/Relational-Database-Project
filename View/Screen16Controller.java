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

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen16Controller {

    @FXML
    private Button backButton;
    @FXML
    private Label name;
    @FXML
    private Label employees;

    @FXML
    private TableView<Data16> tableview;
    @FXML
    private TableColumn<Data14, String> namecolumn;
    @FXML
    private TableColumn<Data14, String> managercolumn;
    @FXML
    private TableColumn<Data14, String> citycolumn;
    @FXML
    private TableColumn<Data14, String> statecolumn;
    @FXML
    private TableColumn<Data14, String> capacitycolumn;
    private ObservableList<Data16> list = FXCollections.observableArrayList();
    private String tempName;

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public Label getName() {
        return name;
    }

    public void setNameLabel(String name) {
        this.name.setText(name);
    }

    public void setEmployeesLabel(String employees) {
        this.employees.setText(employees);
    }

    public void setList(ObservableList<Data16> listPara) {
        this.list = listPara;
    }

    public void initialize() throws Exception {
        StoredProcedure procedures = new StoredProcedure();
        DataOperation init = new DataOperation();
        init.connectDatabase();
        Statement st = init.conn.createStatement();
        String sql0 = new String("SELECT * FROM team32.screen16comName");
        ResultSet rs0 = st.executeQuery(sql0);
        rs0.next();
        setNameLabel(rs0.getObject("comName").toString());
        ResultSet empName = procedures.admin_view_comDetail_emp(init.conn, rs0.getObject("comName").toString());
        String totalName = new String();
        int count0 = 0;
        while (empName.next()) {
            count0++;
            totalName = totalName + empName.getObject("empFirstname").toString() + " " + empName.getObject("empLastname").toString() + ", ";
            if (count0 == 4) {
                totalName = totalName + "\r";
                count0 = 0;
            }

        }
        //System.out.println(totalName);
        setEmployeesLabel(totalName);
        ResultSet rsth = procedures.admin_view_comDetail_th(init.conn, rs0.getObject("comName").toString());
        while (rsth.next()) {
            Data16 d1 = new Data16(rsth.getObject("thName").toString(), rsth.getObject("thManagerUsername").toString(),
                    rsth.getObject("thCity").toString(), rsth.getObject("thState").toString(),rsth.getObject("thCapacity").toString());
            list.add(d1);
        }
        namecolumn.setCellValueFactory(new PropertyValueFactory<Data14, String>("tName"));
        managercolumn.setCellValueFactory(new PropertyValueFactory<Data14, String>("manager"));
        citycolumn.setCellValueFactory(new PropertyValueFactory<Data14, String>("city"));
        statecolumn.setCellValueFactory(new PropertyValueFactory<Data14, String>("state"));
        capacitycolumn.setCellValueFactory(new PropertyValueFactory<Data14, String>("capacity"));


        tableview.setItems(list);
    }

    public void goBackToManageCompany(ActionEvent event) throws IOException {
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
