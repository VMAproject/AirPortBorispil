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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.TableExample;
import start.Main;

import java.io.IOException;
import java.sql.*;

public class ArrivalsController {

    private ObservableList<TableExample> tableExampleList = FXCollections.observableArrayList();
    @FXML
    private TextField TextSearchArrivals;
    @FXML
    private TableView tableViewArrivals;// таблица


    @FXML
    private TableColumn<TableExample, String> columnDate;
    @FXML
    private TableColumn<TableExample, String> columnTime;
    @FXML
    private TableColumn<TableExample, String> columnFlight;
    @FXML
    private TableColumn<TableExample, String> columnFrom;
    @FXML
    private TableColumn<TableExample, String> columnAirline;
    @FXML
    private TableColumn<TableExample, String> columnTerminal;
    @FXML
    private TableColumn<TableExample, String> columnStatus;
    @FXML
    private MenuItem DateItem;


    @FXML
    public void goDeparture() throws IOException {
        Main.showDepartureWindow();
    } // методы переключения окон

    @FXML
    public void goMainMenu() throws IOException {
        Main.showMainMenu1();
    } // методы переключения окон


    @FXML
    public void initialize() {
        initData();
        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));
        tableViewArrivals.setItems(tableExampleList);
    }

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
            final String QUERY = ("SELECT DATE,TIME,FLIGHT,DESTINATION,AIRLINE,TERMINAL,STATUS FROM arrivals");
            ResultSet result = statement.executeQuery(QUERY);
            while (result.next()) {
                tableExampleList.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // отображение данных в таблице

    @FXML
    public void UpdateDataArrivals() {
        ObservableList<TableExample> tableExampleUpList = FXCollections.observableArrayList();
        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));
        tableViewArrivals.setItems(tableExampleUpList);
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
            final String SEARCH_QUERY = ("SELECT DATE,TIME,FLIGHT,DESTINATION,AIRLINE,TERMINAL,STATUS FROM arrivals");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {
                tableExampleUpList.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // обновление таблицы
    @FXML
    public void searchDateArrivals(){

        ObservableList<TableExample> tableSearchDateArrivals = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableSearchDateArrivals);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Date ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableSearchDateArrivals.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // поиск по дате прилета
    @FXML
    public void searchTimeArrivals(){
        ObservableList<TableExample> tableSearchTimeArrivals = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableSearchTimeArrivals);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Time ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableSearchTimeArrivals.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // поиск по времени прилета
    @FXML
    public void searchFlightArrivals() {

        ObservableList<TableExample> tableExampleListSearch = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableExampleListSearch);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Flight ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableExampleListSearch.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // поиск по номеру рейса
    @FXML
    public void searchFromArrivals(){
        ObservableList<TableExample> tableSearchFromArrivals = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableSearchFromArrivals);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Destination ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableSearchFromArrivals.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // поиск по городу отправления (From)
    @FXML
    public void searchAirlineArrivals(){
        ObservableList<TableExample> tableSearchAirlineArrivals = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableSearchAirlineArrivals);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Airline ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableSearchAirlineArrivals.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // поиск по авиалиниям
    @FXML
    public void searchStatusArrivals(){
        ObservableList<TableExample> tableSearchStatusArrivals = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new PropertyValueFactory<TableExample, String>("date"));
        columnTime.setCellValueFactory(new PropertyValueFactory<TableExample, String>("time"));
        columnFlight.setCellValueFactory(new PropertyValueFactory<TableExample, String>("flight"));
        columnFrom.setCellValueFactory(new PropertyValueFactory<TableExample, String>("from"));
        columnAirline.setCellValueFactory(new PropertyValueFactory<TableExample, String>("airline"));
        columnTerminal.setCellValueFactory(new PropertyValueFactory<TableExample, String>("terminal"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<TableExample, String>("status"));

        tableViewArrivals.setItems(tableSearchStatusArrivals);

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
            final String SEARCH_QUERY = (" SELECT * FROM arrivals WHERE Date ='" + TextSearchArrivals.getText() + "'");
            ResultSet result = statement.executeQuery(SEARCH_QUERY);
            while (result.next()) {

                tableSearchStatusArrivals.add(new TableExample(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } //метод для поиска по статусу

}















