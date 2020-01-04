package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.RadioButton;

public class Data20 {
    private RadioButton movie;
    private SimpleStringProperty theater;
    private SimpleStringProperty address;
    private SimpleStringProperty company;
    private SimpleStringProperty pldate;

    public Data20( String buttonName,String theater, String address, String company,
                  String pldate) {
        this.theater = new SimpleStringProperty(theater);
        this.address = new SimpleStringProperty(address);
        this.company = new SimpleStringProperty(company);
        this.pldate = new SimpleStringProperty(pldate);
        this.movie = new RadioButton(buttonName);
    }

    public RadioButton getMovie() {
        return movie;
    }

    public String getTheater() {
        return theater.get();
    }

    public SimpleStringProperty theaterProperty() {
        return theater;
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

    public String getPldate() {
        return pldate.get();
    }

    public SimpleStringProperty pldateProperty() {
        return pldate;
    }
}
