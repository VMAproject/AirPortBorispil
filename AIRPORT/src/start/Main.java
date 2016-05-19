package start;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * -- Created by Michael Verlamov -- *
 * -- Contact mail: verlamov.m@gmail.com -- *
 * -- My GitHub: https://github.com/VMAproject -- *
 **/
public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Airport");
        this.primaryStage.getIcons().add(new Image("styleCSS/image_layer/AirportBlue2.png"));

        showMainWindow();
        showMainMenu();
        //showArrivalsWindow();
        //showDepartureWindow();
    }

    private void showMainWindow()throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/Window.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,890,650);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Airport Borispol");
        primaryStage.show();
    }

    public static void showMainMenu()throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/MainMenu.fxml"));
        BorderPane MainMenu = loader.load();
        mainLayout.setCenter(MainMenu);
    }

    public static void showArrivalsWindow()throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/ArrivalsWindow.fxml"));
        BorderPane ArrivalsWindow = loader.load();
        mainLayout.setCenter(ArrivalsWindow);
    }

    public static void showDepartureWindow()throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/DepartureWindow.fxml"));
        BorderPane DepartureLayout = loader.load();
        mainLayout.setCenter(DepartureLayout);
    }

    public static void showMainMenu1()throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/MainMenu.fxml"));
        BorderPane MainMenu = loader.load();
        mainLayout.setCenter(MainMenu);
    }

    public static void main(String[] args) {
        launch(args);


    }
}
