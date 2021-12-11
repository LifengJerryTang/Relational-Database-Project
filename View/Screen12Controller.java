package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen12Controller {

    @FXML
    private Button backButton;
    @FXML
    private Button exploreTheaterButton;
    @FXML
    private Button visitHistoryButton;

    public void backToLogin(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen1.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }

    public void exploreTheater(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == exploreTheaterButton) {
            stage = (Stage) exploreTheaterButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen20.fxml"));

        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }



    public void visitHistory(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == visitHistoryButton) {
            stage = (Stage) visitHistoryButton.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen23.fxml"));

        }

        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }
}
