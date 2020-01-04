package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen9Controller {

    @FXML
    private Button theaterOverview;
    @FXML
    private Button scheduleMovie;
    @FXML
    private Button exploreTheater;
    @FXML
    private Button visitHistory;
    @FXML
    private Button back;

    public void scheduleMovie(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == scheduleMovie) {
            stage = (Stage) scheduleMovie.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen19.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }


    public void exploreTheater(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == exploreTheater) {
            stage = (Stage) exploreTheater.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen22.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }
    public void visitHistory(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == visitHistory) {
            stage = (Stage) visitHistory.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen23.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }

    public void theaterOverview(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == theaterOverview) {
            stage = (Stage) theaterOverview.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("screen18.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }
    public void backToLogin(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == back) {
            stage = (Stage) back.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen1.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }

}




