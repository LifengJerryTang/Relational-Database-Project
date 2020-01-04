package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.RadioButton;

public class Data14 {
    private RadioButton name;
    private SimpleStringProperty city;
    private SimpleStringProperty theater;
    private SimpleStringProperty employee;

    public Data14(String buttonName, String city, String theater, String employee) {
        this.name = new RadioButton(buttonName);
        this.city = new SimpleStringProperty(city);
        this.theater = new SimpleStringProperty(theater);
        this.employee = new SimpleStringProperty(employee);
    }

    public RadioButton getName() {
        return name;
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public String getTheater() {
        return theater.get();
    }

    public SimpleStringProperty theaterProperty() {
        return theater;
    }

    public String getEmployee() {
        return employee.get();
    }

    public SimpleStringProperty employeeProperty() {
        return employee;
    }
}
