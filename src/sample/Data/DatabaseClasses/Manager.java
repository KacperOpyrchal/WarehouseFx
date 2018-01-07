package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.SQLiteJDBC;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.pair;
import static sample.Tools.SceneProvider.pairList;

public class Manager implements Updatable {
    private int id;
    private String name;
    private String surname;
    private double salary;
    private int sectionID;
    private List<Item> list = null;

    public Manager() {
    }

    public Manager(int section, String name, String surname, int id, double salary) {
        this.sectionID = section;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
    }

    public static void createTable() {
        String sql = "CREATE TABLE MANAGERS (" +
                " ID INT PRIMARY KEY NOT NULL, " +
                " NAME NEXT NOT NULL, " +
                " SURNAME TEXT NOT NULL, " +
                " SALARY REAL NOT NULL, " +
                " SECTION INT NOT NULL);";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Manager> getTable() throws Exception {
        String query = "SELECT * FROM MANAGERS";
        List<Manager> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Manager(cursor.getInt("SECTION"), cursor.getString("NAME"), cursor.getString("SURNAME"), cursor.getInt("ID"), cursor.getDouble("SALARY")));
        }
        return list;
    }

    @Override
    public void addToDatabase() {
        String sql = "INSERT INTO MANAGERS(ID, NAME, SURNAME, SALARY, SECTION) VALUES (" +
                id + ", '" +
                name + "', '" +
                surname + "', " +
                salary + ", " +
                sectionID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSections(int section) {
        this.sectionID = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        surname = values.get(2);
        salary = Integer.parseInt(values.get(3));

        if(list != null) {
            list.get(0).updateItem(name);
        }

        String sql = "UPDATE MANAGERS SET " +
                " NAME = '" + name + "', " +
                " SURNAME = '" + surname + "', " +
                " SALARY = " + salary + " WHERE ID = " + id + ";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""), pair("Name", name), pair("Surname", surname), pair("Salary", salary + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        return list;
    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + name +
                ", " + surname +
                ", " + salary +
                ", " + sectionID);
        printWriter.flush();
    }
}
