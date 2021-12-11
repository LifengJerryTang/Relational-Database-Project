package sample;

import javafx.beans.property.SimpleStringProperty;
public class Data21 {
   private SimpleStringProperty movie;
   private SimpleStringProperty theater;
   private SimpleStringProperty company;
   private  SimpleStringProperty cardNum;
   private  SimpleStringProperty viewDate;

   public Data21(String movie1, String theater1, String company1, String cardNum1, String viewDate1) {
       this.movie = new SimpleStringProperty(movie1);
       this.theater = new SimpleStringProperty(theater1);
       this.company = new SimpleStringProperty(company1);
       this.cardNum = new SimpleStringProperty(cardNum1);
       this.viewDate = new SimpleStringProperty(viewDate1);

   }

    public String getMovie() {
        return movie.get();
    }

    public SimpleStringProperty movieProperty() {
        return movie;
    }

    public String getTheater() {
        return theater.get();
    }

    public SimpleStringProperty theaterProperty() {
        return theater;
    }

    public String getCompany() {
        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }

    public String getCardNum() {
        return cardNum.get();
    }

    public SimpleStringProperty cardNumProperty() {
        return cardNum;
    }

    public String getViewDate() {
        return viewDate.get();
    }

    public SimpleStringProperty viewDateProperty() {
        return viewDate;
    }
}
