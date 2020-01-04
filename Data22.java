package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.RadioButton;

public class Data22 {
    private RadioButton thbutton;
    private SimpleStringProperty address;
    private SimpleStringProperty company;

    public Data22(String buttonName, String address, String company) {
        this.thbutton = new RadioButton(buttonName);
        this.address = new SimpleStringProperty(address);
        this.company = new SimpleStringProperty(company);
    }

    public RadioButton getThbutton() {
        return thbutton;
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public String getCompany() {
        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }
}
