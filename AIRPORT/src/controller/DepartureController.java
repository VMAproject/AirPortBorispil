package controller;
/**
 * -- Created by Michael Verlamov -- *
 * -- Contact mail: verlamov.m@gmail.com -- *
 * -- My GitHub: https://github.com/VMAproject -- *
 **/
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import objects.TableExample;
import start.Main;

import java.io.IOException;
import java.sql.*;

public class DepartureController {
    private ObservableList<TableExample> departureList = FXCollections.observableArrayList();

    @FXML
    private TextField TextSearchDeparture; /// переменная для поля поиска
    @FXML
    private TableView tableViewDeparture;


    @FXML
    private TableColumn<TableExample, String> columnDateDeparture;
    @FXML
    private TableColumn<TableExample, String> columnTimeDeparture;
    @FXML
    private TableColumn<TableExample, String> columnFlightDeparture;
    @FXML
    private TableColumn<TableExample, String> columnFromDeparture;
    @FXML
    private TableColumn<TableExample, String> columnAirlineDeparture;
    @FXML
    private TableColumn<TableExample, String> columnTerminalDeparture;
    @FXML
    private TableColumn<TableExample, String> columnStatusDeparture;


    @FXML
    public void goMainMenu() throws IOException {
        Main.showMainMenu1();
    }
    public void goArrivals() throws IOException {
        Main.showArrivalsWindow();
    }
    @FXML
    public void initialize() {

        initData();

        columnDateDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTimeDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlightDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFromDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirlineDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminalDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatusDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewDeparture.setItems(departureList);

    } // инициализация данных

    public void initData() {
        try {
            final String URL = "jdbc:mysql://localhost:3306/Airport?useSSL=false";
            final String USERNAME = "root";
            final String PASSWORD = "root";
            final Driver driver;
            Connection connection;
            try {
                driver = new FabricMySQLDriver();
            } catch (SQLException ex) {
                System.out.println("Ошибка");
                return;
            }
            try {
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.out.println("нет регистрации");
                return;
            }
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("code.......");
            } catch (SQLException ex) {
                System.out.println("Не удалось подключиться" + ex);
                return;
            }
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            final String QUERY = "SELECT DATE,TIME,FLIGHT,DESTINATION,AIRLINE,TERMINAL,STATUS FROM departure";
            ResultSet result = statement.executeQuery(QUERY);
            while (result.next()) {
                departureList.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void searchFlightDeparture() {

        ObservableList<TableExample> departureListSearch = FXCollections.observableArrayList();

        columnDateDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTimeDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlightDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFromDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirlineDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminalDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatusDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewDeparture.setItems(departureListSearch);

        try {
            final String URL = "jdbc:mysql://localhost:3306/Airport?useSSL=false";
            final String USER_NAME = "root";
            final String PASSWORD = "root";
            final Driver driver;
            Connection connection;
            try {
                driver = new FabricMySQLDriver();
            } catch (SQLException ex) {
                System.out.println("ERROR");
                return;
            }
            try {
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.out.println("NO REGISTRATION");
                return;
            }
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("code....USE Search");
            } catch (SQLException ex) {
                System.out.println("NO Connection" + ex);
                return;
            }
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SEARCH_QUERY = "SELECT * FROM arrivals WHERE Flight ='" + TextSearchDeparture.getText() + "'";
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                departureListSearch.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } /// Кнопка для поиска

    @FXML
    public void UpdateDataDeparture() {
        ObservableList<TableExample> departureUpList = FXCollections.observableArrayList();
        columnDateDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTimeDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlightDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFromDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirlineDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminalDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatusDeparture.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));
        tableViewDeparture.setItems(departureUpList);
        try {
            final String URL = "jdbc:mysql://localhost:3306/Airport?useSSL=false";
            final String USER_NAME = "root";
            final String PASSWORD = "root";
            final Driver driver;
            Connection connection;
            try {
                driver = new FabricMySQLDriver();
            } catch (SQLException ex) {
                System.out.println("ERROR");
                return;
            }
            try {
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.out.println("NO REGISTRATION");
                return;
            }
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("code....USE Search");
            } catch (SQLException ex) {
                System.out.println("NO Connection" + ex);
                return;
            }
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SEARCH_QUERY = "SELECT DATE,TIME,FLIGHT,DESTINATION,AIRLINE,TERMINAL,STATUS FROM departure";
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {
                departureUpList.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }///  кнопка для обновленния таблицы после поиска




}
