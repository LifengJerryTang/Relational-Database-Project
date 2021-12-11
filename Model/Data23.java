package sample;

import javafx.beans.property.SimpleStringProperty;

public class Data23 {
    private SimpleStringProperty theater;
    private SimpleStringProperty address;
    private SimpleStringProperty company;
    private SimpleStringProperty visitdate;

    public Data23(String theater, String address, String company, String visitdate) {
        this.theater = new SimpleStringProperty(theater);
        this.address = new SimpleStringProperty(address);
        this.company = new SimpleStringProperty(company);
        this.visitdate = new SimpleStringProperty(visitdate);
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

    public String getVisitdate() {
        return visitdate.get();
    }

    public SimpleStringProperty visitdateProperty() {
        return visitdate;
    }
}
