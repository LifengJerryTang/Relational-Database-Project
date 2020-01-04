package sample;

import javafx.beans.property.SimpleStringProperty;

public class Data16 {
    private SimpleStringProperty tName;
    private SimpleStringProperty manager;
    private SimpleStringProperty city;
    private SimpleStringProperty state;
    private SimpleStringProperty capacity;

    public Data16(String tName, String manager, String city, String state, String capacity) {
        this.tName = new SimpleStringProperty(tName);
        this.manager = new SimpleStringProperty(manager);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.capacity = new SimpleStringProperty(capacity);
    }

    public String gettName() {
        return tName.get();
    }

    public SimpleStringProperty tNameProperty() {
        return tName;
    }

    public String getManager() {
        return manager.get();
    }

    public SimpleStringProperty managerProperty() {
        return manager;
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public String getCapacity() {
        return capacity.get();
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }
}
