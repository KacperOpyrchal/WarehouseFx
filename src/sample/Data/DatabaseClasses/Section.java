package sample.Data.DatabaseClasses;

import java.util.List;

public class Section {
    private int id;
    private String name;
    private Manager manager;
    private List<Product> products;
    private List<Employee> employees;
    private List<Equipment> equipment;

    public Section() {
    }

    public Section(int id, String name, Manager manager, List<Product> products, List<Employee> employees, List<Equipment> equipment) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.products = products;
        this.employees = employees;
        this.equipment = equipment;
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
}
