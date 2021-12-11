package sample;

import javafx.beans.property.SimpleStringProperty;

public class Data18 {
    private SimpleStringProperty movie;
    private SimpleStringProperty duration;
    private SimpleStringProperty release;
    private SimpleStringProperty play;

    public Data18(String movieName, String duration, String releaseDate, String playDate) {
        this.movie = new SimpleStringProperty(movieName);
        this.duration = new SimpleStringProperty(duration);
        this.release = new SimpleStringProperty(releaseDate);
        this.play = new SimpleStringProperty(playDate);
    }

    public String getMovie() {
        return movie.get();
    }

    public SimpleStringProperty movieProperty() {
        return movie;
    }

    public String getDuration() {
        return duration.get();
    }

    public SimpleStringProperty durationProperty() {
        return duration;
    }

    public String getRelease() {
        return release.get();
    }

    public SimpleStringProperty releaseProperty() {
        return release;
    }

    public String getPlay() {
        return play.get();
    }

    public SimpleStringProperty playProperty() {
        return play;
    }
}
