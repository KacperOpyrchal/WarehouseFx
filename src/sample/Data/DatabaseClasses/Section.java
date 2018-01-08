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

public class Section implements Updatable {
    private int id;
    private String name;
    private int managerID;
    private int warehouseID;
    private List<Product> products;
    private List<Employee> employees;
    private List<Equipment> equipment;
    private List<Item> list = null;

    public Section() {
    }

    public Section(int id, String name, int manager, int warehouse, List<Product> products, List<Employee> employees, List<Equipment> equipment) {
        this.id = id;
        this.name = name;
        this.managerID = manager;
        this.warehouseID = warehouse;
        this.products = products;
        this.employees = employees;
        this.equipment = equipment;
    }

    public static void createTable() {
        String sql = "CREATE TABLE SECTIONS( " +
                " ID INT PRIMARY KEY NOT NULL, " +
                " NAME TEXT NOT NULL, " +
                " MANAGER INT NOT NULL, " +
                " WAREHOUSE INT NOT NULL);";

        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Section> getTable() throws Exception {
        String query = "SELECT * FROM SECTIONS";
        List<Section> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Section(cursor.getInt("ID"), cursor.getString("NAME"), cursor.getInt("MANAGER"), cursor.getInt("WAREHOUSE"), null, null, null));
        }
        return list;
    }

    @Override
    public void addToDatabase() {
        String sql = "INSERT INTO SECTIONS(ID, NAME, MANAGER, WAREHOUSE) VALUES ( " +
                id + ", '" +
                name + "', " +
                managerID + ", " +
                warehouseID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFromDatabase() {
        UpdatableWrapper.deleteFromDatabase("SECTIONS", id);
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
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

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);

        if(list != null) {
            list.get(0).updateItem(name);
        }

        String sql = "UPDATE SECTIONS SET NAME = '" + name + "' WHERE ID = " + id + ";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""), pair("Name", name));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Warehouse", () -> "".toString()));
        list.add(new MenuItem("Products", () -> "".toString()));
        list.add(new MenuItem("Employees", () -> "".toString()));
        list.add(new MenuItem("Equipment", () -> "".toString()));
        return list;
    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + name +
                ", " + managerID +
                ", " + warehouseID);
        for (Product product : products) {
            printWriter.print(product.getId() + ", ");
        }
        printWriter.println();
        for (Employee employee : employees) {
            printWriter.print(employee.getId() + ", ");
        }
        printWriter.println();
        for (Equipment equipment : equipment) {
            printWriter.print(equipment.getId() + ", ");
        }
        printWriter.println();
        printWriter.flush();
    }
}
