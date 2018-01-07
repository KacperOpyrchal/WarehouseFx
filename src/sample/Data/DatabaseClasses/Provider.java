package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.pair;
import static sample.Tools.SceneProvider.pairList;

public class Provider implements Updatable {

    private int id;
    private String companyName;
    private List<Product> products;
    private List<Warehouse> warehouses;
    private List<Item> list = null;

    public Provider() {
    }

    public Provider(String companyName, int id, List<Product> products, List<Warehouse> warehouses) {
        this.companyName = companyName;
        this.id = id;
        this.products = products;
        this.warehouses = warehouses;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        companyName = values.get(1);

        if(list != null) {
            list.get(0).updateItem(companyName);
        }
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID",id + ""), pair("Company Name", companyName));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(companyName, () -> companyName.toString()));
        list.add(new MenuItem("Products", () -> "".toString()));
        list.add(new MenuItem("Warehouses", ()->"".toString()));
        return list;
    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + companyName);
        for (Product product : products) {
            printWriter.print(product.getId() + ", ");
        }
        printWriter.println();
        for (Warehouse warehouse : warehouses) {
            printWriter.print(warehouse.getId() + ", ");
        }
        printWriter.println();
        printWriter.flush();
    }
}
