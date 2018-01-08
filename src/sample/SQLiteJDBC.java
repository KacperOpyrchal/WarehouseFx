package sample;

import sample.Data.DatabaseClasses.*;
import sample.Data.Users.UserImp;

import java.sql.*;

public class SQLiteJDBC {
    private static final String sqlite = "jdbc:sqlite:database.db";
    public static void main( String args[] ) {
        try {
            //SQLiteJDBC.initDemoDatabase();
            //SQLiteJDBC.dropAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
 }

    public static ResultSet proceedQuery(String query) throws Exception {
        Connection connection = DriverManager.getConnection(sqlite);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static void proceedUpdate(String query) throws Exception {
        Connection connection = DriverManager.getConnection(sqlite);
        Statement statement  = connection.createStatement();
        statement.execute(query);
    }

    public static void initDemoDatabase() throws SQLException {
        int size = 7;
        UserImp.createTable();

        Employee.createTable();
        for(int i = 0; i < size; i++) {
            Employee sample = new Employee(("Name" + i), ("Surname" + i), i * 1000.0, i, "standard", i, i);
            sample.addToDatabase();
        }

        Equipment.createTable();
        for(int i = 0; i < size; i++) {
            Equipment sample = new Equipment(("Name" + i), i, i);
            sample.addToDatabase();
        }

        Manager.createTable();
        for(int i = 0; i < size; i++) {
            Manager sample = new Manager(i, ("Name" + i), ("Surname" + i), i, i * 1000.0);
            sample.addToDatabase();
        }

        Product.createTable();
        for(int i = 0; i < size; i++) {
            Product sample = new Product(i, ("Name" + i), i * 13.4, i * 11.1, i*10, i, null);
            sample.addToDatabase();
        }

        Provider.createTable();
        for(int i = 0; i < size; i++) {
            Provider sample = new Provider(("Company" + i), i, null, null);
            sample.addToDatabase();
        }

        Section.createTable();
        for(int i = 0; i < size; i++) {
            Section sample = new Section(i, ("Section" + i), i, i, null, null, null);
            sample.addToDatabase();
        }

        Warehouse.createTable();
        for(int i = 0; i < size; i++) {
            Warehouse sample = new Warehouse(i, ("Warehouse" + i), i*25, i, null, null);
            sample.addToDatabase();
        }
    }

    public static void dropAll() throws Exception {
        String[] tables = {"EMPLOYEES", "EQUIPMENT", "MANAGERS", "PRODUCTS", "PROVIDERS", "SECTIONS", "WAREHOUSES", "USERS"};
        for (String table : tables) {
            SQLiteJDBC.proceedUpdate(("DROP TABLE " + table + ";"));
        }
    }
}
