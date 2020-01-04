package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller2 implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button useronly;
    @FXML
    private Button cusonly;
    @FXML
    private Button manageronly;
    @FXML
    private Button mancus;

    public void handlebuttonaction(ActionEvent event) throws IOException{
        Stage stage = null;
        Parent myNewscene = null;
        System.out.println(event.getSource());
        if (event.getSource() == useronly) {
            stage = (Stage) useronly.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen3.fxml"));
        } else if (event.getSource() == back) {
            stage = (Stage) back.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen1.fxml"));
        } else if (event.getSource() == cusonly) {
            stage = (Stage) cusonly.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen4.fxml"));
        } else if (event.getSource() == manageronly) {
            stage = (Stage) manageronly.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        } else if (event.getSource() == mancus) {
            stage = (Stage) mancus.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen6.fxml"));
        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

