package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * -- Created by Michael Verlamov -- *
 * -- Contact mail: verlamov.m@gmail.com -- *
 * -- My GitHub: https://github.com/VMAproject -- *
 **/

public class TableExample {

    private StringProperty date;// = new SimpleStringProperty("");
    private StringProperty time;// = new SimpleStringProperty("");
    private StringProperty flight;// = new SimpleStringProperty("");
    private StringProperty destination;// = new SimpleStringProperty("");
    private StringProperty airline;// = new SimpleStringProperty("");
    private StringProperty terminal;// = new SimpleStringProperty("");
    private StringProperty status;// = new SimpleStringProperty("");

    public TableExample(String date, String time, String flight, String destination, String airline, String terminal, String status) {
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.flight = new SimpleStringProperty(flight);
        this.destination = new SimpleStringProperty(destination);
        this.airline = new SimpleStringProperty(airline);
        this.terminal = new SimpleStringProperty(terminal);
        this.status = new SimpleStringProperty(status);
    }
    
        public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getFlight() {
        return flight.get();
    }

    public StringProperty flightProperty() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight.set(flight);
    }

    public String getFrom() {
        return destination.get();
    }

    public StringProperty fromProperty() {
        return destination;
    }

    public void setFrom(String from) {
        this.destination.set(from);
    }

    public String getAirline() {
        return airline.get();
    }

    public StringProperty airlineProperty() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline.set(airline);
    }

    public String getTerminal() {
        return terminal.get();
    }

    public StringProperty terminalProperty() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal.set(terminal);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    
    
}
