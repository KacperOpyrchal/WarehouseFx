package sample;

import sample.Data.DatabaseClasses.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC {
    private static final String sqlite = "jdbc:sqlite:database.db";
    public static void main( String args[] ) {
        try {
            Section e = new Section(6, "plyny", 1, 1, null, null, null);
            e.addToDatabase();
            ResultSet resultSet = SQLiteJDBC.proceedQuery( "SELECT * FROM SECTIONS;" );
            while ( resultSet.next() ) {
                System.out.println(resultSet.getInt("ID") + " "  + resultSet.getString("NAME"));
            }

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
}
