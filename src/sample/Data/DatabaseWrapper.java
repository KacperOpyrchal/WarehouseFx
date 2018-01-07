package sample.Data;

import sample.Data.Builders.CredentialsBuilder;
import sample.Data.Builders.UserDataBuilder;
import sample.Data.DatabaseClasses.Manager;
import sample.Data.DatabaseClasses.Warehouse;
import sample.Data.Users.User;
import sample.Data.Users.UserData;
import sample.Data.Users.UserImp;

import java.util.ArrayList;
import java.util.List;

import static sample.Data.AccountType.*;

public class DatabaseWrapper {

    private static List<User> users = new ArrayList<>();

    public static boolean verifyUser(User user) {
        Credentials credentials = user.getCredentials();
        for(User u : users) {
            if(u.getCredentials().getUsername().equals(credentials.getUsername())) {
                if(u.getCredentials().getPassword().equals(credentials.getPassword())) {
                    user.setCredentials(u.getCredentials());
                    return true;
                }
                else return  false;
            }
        }

        return false;
    }

    public static boolean checkUsernameIsAvailable(String username) {
        for(User u : users) {
            if(u.getCredentials().getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static void addNewUser(Credentials credentials, UserData userData) {
        users.add(new UserImp(credentials, userData));
    }

    public static void loadAllUsers() {
        CredentialsBuilder builder = new CredentialsBuilder();
        users.add(new UserImp(builder.setUsername("Janush")
                .setPassword("janush123")
                .setAccuntType(STANDARD)
                .build()));
        users.add(new UserImp(builder.setUsername("Admin")
                .setPassword("admin123")
                .setAccuntType(ADMIN)
                .build()));
        users.add(new UserImp(builder.setUsername("Jan")
                .setPassword("123")
                .setAccuntType(WORKER)
                .build()));
    }

    public static List<Warehouse> loadAllWarehouses() {

        List<Warehouse> list = new ArrayList<>();

        String[] strs = {"Magazyn warzyw", "Magazyn Owocow", "Magazyn Owocow 2", "Magazyn Samochodowy",
                "Magazyn ksiazek", "Magazyn mebli", "Magazyn dzikow", "Magazyn mikelow",
                "Magazyn komputerow", "Magazyn gier"};

        for(int i = 0; i < strs.length; ++i) {
            Warehouse warehouse = new Warehouse(i,strs[i], i, new Manager(), new ArrayList<>(), new ArrayList<>());
            list.add(warehouse);
        }

        return list;
    }

}
