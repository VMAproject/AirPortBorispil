package controller;

import javafx.fxml.FXML;
import start.Main;

import java.io.IOException;
/**
 * -- Created by Michael Verlamov -- *
 * -- Contact mail: verlamov.m@gmail.com -- *
 * -- My GitHub: https://github.com/VMAproject -- *
 **/
public class MainController{

    @FXML
    public void goArrivals()throws IOException{
        Main.showArrivalsWindow();
    }

    @FXML
    public  void goDeparture()throws IOException{
        Main.showDepartureWindow();
    }





}
