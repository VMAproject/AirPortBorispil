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
}
