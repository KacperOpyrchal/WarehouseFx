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

public class Product implements Updatable {
    private int id;
    private String name;
    private double price;
    private double weight;
    private int amount;
    private int sectionID;
    private List<Provider> providers;
    private List<Item> list = null;

    public Product() {
    }

    public Product(int id, String name, double price, double weight, int amount, int section, List<Provider> providers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sectionID = section;
        this.providers = providers;
    }

    public static void createTable() {
        String sql = "CREATE TABLE PRODUCTS(" +
                " ID INT PRIMARY KEY NOT NULL, " +
                " NAME TEXT NOT NULL, " +
                " PRICE REAL NOT NULL, " +
                " WEIGHT REAL NOT NULL, " +
                " AMOUNT INT NOT NULL, " +
                " SECTION INT NOT NULL);";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Product> getTable() throws Exception {
        String query = "SELECT * FROM PRODUCTS";
        List<Product> list = new ArrayList<>();
        ResultSet cursor = SQLiteJDBC.proceedQuery(query);
        while ( cursor.next() ) {
            list.add(new Product(cursor.getInt("ID"), cursor.getString("NAME"), cursor.getDouble("PRICE"), cursor.getDouble("WEIGHT"), cursor.getInt("AMOUNT"), cursor.getInt("SECTION"), null));
        }
        return list;
    }

    @Override
    public void addToDatabase() {
        String sql = "INSERT INTO PRODUCTS VALUES( " +
                id + ", '" +
                name + "', " +
                price + ", " +
                weight + ", " +
                amount + ", " +
                sectionID + ");";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSections() {
        return sectionID;
    }

    public void setSections(int section) {
        this.sectionID = section;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        price = Double.parseDouble(values.get(2));
        weight = Double.parseDouble(values.get(3));
        amount = Integer.parseInt(values.get(4));

        String sql = "UPDATE PRODUCTS SET " +
                "NAME = '" + name + "', " +
                "PRICE = " + price + ", " +
                "WEIGHT = " + weight + ", " +
                "AMOUNT = " + amount + " WHERE ID = " + id + ";";
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
                pair("Price", price + ""),
                pair("Weight", weight + ""),
                pair("Amount", amount + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        list.add(new MenuItem("Providers", ()->"".toString()));
        return list;

    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + name +
                ", " + price +
                ", " + weight +
                ", " + amount +
                ", " + sectionID);
        for (Provider provider: providers) {
            printWriter.print(provider.getId() + ", ");
        }
        printWriter.println();
        printWriter.flush();
    }
}
