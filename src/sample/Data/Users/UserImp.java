package sample.Data.Users;

import sample.Data.AccountType;
import sample.Data.Credentials;
import sample.Data.DatabaseClasses.Employee;
import sample.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImp implements User {

    Credentials credentials;
    UserData userData;

    public UserImp(Credentials credentials) {
        this.credentials = credentials;
    }

    public UserImp(Credentials credentials, UserData userData) {
        this.credentials = credentials;
        this.userData = userData;
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE USERS " +
                "(USERNAME TEXT PRIMARY KEY NOT NULL," +
                " PASSWORD TEXT NOT NULL, " +
                " ACCOUNT_TYPE TEXT NOT NULL);";

        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> getTable() throws Exception {
        String query = "SELECT * FROM USERS";
        List<User> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new UserImp(new Credentials (cursor.getString("USERNAME"),
                    cursor.getString("PASSWORD"))));
        }
        return list;
    }

    public void addToDatabase() {
        String sql = "INSERT INTO USERS(USERNAME, PASSWORD) VALUES (" +
                credentials.getUsername()+ ", " +
                credentials.getPassword() + ", " +
                credentials.getAccountType() + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public UserData getUserData() {
        return userData;
    }

    @Override
    public AccountType getAccountType() {
        return credentials.getAccountType();
    }
}
