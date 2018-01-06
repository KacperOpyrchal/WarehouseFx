package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Provider implements Updatable{

    private String companyName;
    private int id;
    private List<Product> products;
    private List<Warehouse> warehouses;

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

    }

    @Override
    public List<Item> toItemsList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(companyName, () -> companyName.toString()));
        list.add(new MenuItem("Products", () -> "".toString()));
        list.add(new MenuItem("Warehouses", ()->"".toString()));
        return list;
    }
}
