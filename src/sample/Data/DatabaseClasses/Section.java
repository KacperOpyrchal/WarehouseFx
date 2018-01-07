package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class Section implements Updatable {
    private int id;
    private String name;
    private Manager manager;
    private Warehouse warehouse;
    private List<Product> products;
    private List<Employee> employees;
    private List<Equipment> equipment;
    private List<Item> list = null;

    public Section() {
    }

    public Section(int id, String name, Manager manager, Warehouse warehouse, List<Product> products, List<Employee> employees, List<Equipment> equipment) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.warehouse = warehouse;
        this.products = products;
        this.employees = employees;
        this.equipment = equipment;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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
                ", " + manager.getId() +
                ", " + warehouse.getId());
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
