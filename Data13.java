package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.RadioButton;

public class Data13 {
    private RadioButton username;
    private SimpleStringProperty creditcount;
    private SimpleStringProperty usertype;
    private SimpleStringProperty status;

    public Data13(String buttonName, String creditcount, String usertype, String status) {
        this.username = new RadioButton(buttonName);
        this.creditcount = new SimpleStringProperty(creditcount);
        this.usertype = new SimpleStringProperty(usertype);
        this.status = new SimpleStringProperty(status);
    }

    public RadioButton getUsername() {
        return username;
    }

    public String getCreditcount() {
        return creditcount.get();
    }

    public SimpleStringProperty creditcountProperty() {
        return creditcount;
    }

    public String getUsertype() {
        return usertype.get();
    }

    public SimpleStringProperty usertypeProperty() {
        return usertype;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
