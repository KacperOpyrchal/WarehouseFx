package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.SQLiteJDBC;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static sample.Tools.SceneProvider.*;

public class Employee implements Updatable {
    private int id;
    private String name;
    private String surname;
    private String position;
    private double salary;
    private int sectionID;
    private int managerID;
    private List<Item> list = null;

    public Employee() {
    }

    public Employee(String name, String surname, double salary, int id, String position, int section, int manager) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.id = id;
        this.position = position;
        this.sectionID = section;
        this.managerID = manager;
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE EMPLOYEES " +
                "(ID INT PRIMARY KEY NOT NULL," +
                " NAME TEXT NOT NULL, " +
                " SURNAME TEXT NOT NULL, " +
                " POSITION TEXT NOT NULL, " +
                " SALARY REAL, " +
                " SECTION INT NOT NULL, " +
                " MANAGER INT NOT NULL);";

        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Employee> getTable() throws Exception {
        String query = "SELECT * FROM EMPLOYEES";
        List<Employee> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Employee(cursor.getString("NAME"), cursor.getString("SURNAME"), cursor.getDouble("SALARY"), cursor.getInt("ID"),
                    cursor.getString("POSITION"), cursor.getInt("SECTION"), cursor.getInt("MANAGER")));
        }
        return list;
    }

    @Override
    public void addToDatabase() {
        String sql = "INSERT INTO EMPLOYEES(ID, NAME, SURNAME, POSITION, SALARY, SECTION, MANAGER) VALUES (" +
                id + ", '" +
                name + "', '" +
                surname + "', '" +
                position + "', " +
                salary + ", " +
                sectionID + ", " +
                managerID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", '" + name +
                "', '" + surname +
                "', '" + position +
                "', " + salary +
                ", " + sectionID +
                ", " + managerID);

        printWriter.flush();
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSection() {
        return sectionID;
    }

    public void setSection(int section) {
        this.sectionID = section;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        surname = values.get(2);
        position = values.get(3);
        salary = Double.parseDouble(values.get(4));

        if(list != null) {
            list.get(0).updateItem(name);
        }

        String sql = "UPDATE EMPLOYEES SET " +
                "NAME = '" + name + "', " +
                "SURNAME = '" + surname + "', " +
                "POSITION = '" + position + "', " +
                "SALARY = " + salary + " WHERE ID = " + id + ";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""),
                pair("Name", name),
                pair("Surname", surname),
                pair("Position", position + ""),
                pair("Salary", salary + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name));
        list.add(new MenuItem("Manager"));
        return list;
    }
}
