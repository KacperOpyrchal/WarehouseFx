package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.SQLiteJDBC;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class Warehouse implements Updatable {

    private int id;
    private String name;
    private int capacity;
    private int managerID;
    private List<Provider> providers;
    private List<Section> sections;
    private List<Item> list = null;

    public Warehouse() {
    }

    public Warehouse(int id, String name, int capacity, int manager, List<Provider> providers, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.managerID = manager;
        this.providers = providers;
        this.sections = sections;
    }

    public static void createTable() {
        String sql = "CREATE TABLE WAREHOUSES( " +
                " ID INT PRIMARY KEY NOT NULL, " +
                " NAME TEXT NOT NULL, " +
                " CAPACITY INT NOT NULL, " +
                " MANAGER INT NOT NULL);";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Warehouse> getTable() throws Exception {
        String query = "SELECT * FROM WAREHOUSES";
        List<Warehouse> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Warehouse(cursor.getInt("ID"), cursor.getString("NAME"), cursor.getInt("CAPACITY"), cursor.getInt("MANAGER"), null, null));
        }
        return list;
    }

    @Override
    public void addToDatabase(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        capacity = Integer.parseInt(values.get(2));
        managerID = 0;

        if(list != null) {
            list.get(0).updateItem(id + "");
            list.get(1).updateItem(name);
            list.get(2).updateItem(capacity + "");
        }

        String sql = "INSERT INTO WAREHOUSES(ID, NAME, CAPACITY, MANAGER) VALUES ( " +
                id + ", '" +
                name + "', " +
                capacity + ", " +
                managerID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromDatabase() {
        UpdatableWrapper.deleteFromDatabase("WAREHOUSES", id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(id+""));
        list.add(new MenuItem(name));
        list.add(new MenuItem(capacity + ""));
        list.add(new MenuItem("Providers"));
        list.add(new MenuItem("Sections"));
        return list;
    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + name +
                ", " + capacity +
                ", " + managerID);
        for (Provider provider : providers) {
            printWriter.print(provider.getId() + ", ");
        }
        printWriter.println();
        for (Section section : sections) {
            printWriter.print(section.getId() + ", ");
        }
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""), pair("Name", name), pair("Capacity", capacity + ""));
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        capacity = Integer.parseInt(values.get(2));

        if(list != null) {
            list.get(0).updateItem(id + "");
            list.get(1).updateItem(name);
            list.get(2).updateItem(capacity + "");
        }

        String sql = "UPDATE WAREHOUSES SET " +
                " NAME = '" + name + "', " +
                " CAPACITY = " + capacity + " WHERE ID = " + id +";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}