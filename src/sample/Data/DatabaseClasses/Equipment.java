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

public class Equipment implements Updatable {
    private int id;
    private String name;
    private int sectionID;
    private List<Item> list = null;

    public Equipment() {
    }

    public Equipment(String name, int id, int sectionID) {
        this.name = name;
        this.id = id;
        this.sectionID = sectionID;
    }

    public static void createTable() {
        String sql = "CREATE TABLE EQUIPMENT (" +
                " ID INT PRIMARY KEY NOT NULL, " +
                " NAME TEXT NOT NULL, " +
                " SECTION INT NOT NULL);";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Equipment> getTable() throws Exception {
        String query = "SELECT * FROM EQUIPMENT";
        List<Equipment> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Equipment(cursor.getString("NAME"), cursor.getInt("ID"), cursor.getInt("SECTION")));
        }
        return list;
    }

    @Override
    public void addToDatabase(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        sectionID = 0;

        String sql = "INSERT INTO EQUIPMENT(ID, NAME, SECTION) VALUES (" +
                id + ", '" +
                name + "', " +
                sectionID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFromDatabase() {
        UpdatableWrapper.deleteFromDatabase("EQUIPMENT", id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);

        if(list != null) {
            list.get(0).updateItem(name);
        }

        String sql = "UPDATE EQUIPMENT SET NAME = '" + name  + "' WHERE ID = "  + id + ";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList( pair("ID", id + ""), pair("Name", name));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(id+""));
        list.add(new MenuItem(name));
        list.add(new MenuItem("Section"));
        return list;
    }

    @Override
    public int getID() {
        return id;
    }
}
