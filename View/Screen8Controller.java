package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen8Controller{

    @FXML
    private Button exploreMovie;
    @FXML
    private Button exploreTheater;
    @FXML
    private Button viewHistory;
    @FXML
    private Button back;
    @FXML
    private Button manageCompany;
    @FXML
    private Button manageUser;
    @FXML
    private Button createMovie;
    @FXML
    private Button visitHistory;
    @FXML
    private Button createTheaterButton;

    public void createMovie(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == createMovie) {
            stage = (Stage) createMovie.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen17.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }
    public void exploreMovie(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == exploreMovie) {
            stage = (Stage) exploreMovie.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen22.fxml"));

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
            myNewscene = FXMLLoader.load(getClass().getResource("Screen20.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();
    }
    public void viewHistory(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == viewHistory) {
            stage = (Stage) viewHistory.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen21.fxml"));

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

    public void manageCompany(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == manageCompany) {
            stage = (Stage) manageCompany.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen14.fxml"));

        }
        Scene scene = new Scene(myNewscene);
        stage.setScene(scene);
        stage.setTitle("Atlantic Movie");
        stage.show();

    }

    public void manageUser(ActionEvent event) throws IOException {

        Stage stage = null;

        Parent myNewscene = null;

        if (event.getSource() == manageUser) {
            stage = (Stage) manageUser.getScene().getWindow();
            myNewscene = FXMLLoader.load(getClass().getResource("Screen13.fxml"));

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





}

