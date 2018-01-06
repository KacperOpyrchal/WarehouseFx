package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Updatable {
    private String name;
    private String surname;
    private double salary;
    private int id;
    private String position;
    private Section section;
    private Manager manager;

    public Employee() {
    }

    public Employee(String name, String surname, double salary, int id, String position, Section section, Manager manager) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.id = id;
        this.position = position;
        this.section = section;
        this.manager = manager;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void update(List<String> values) {

    }

    @Override
    public List<Item> toItemsList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Manager", () -> "".toString()));
        return list;
    }
}
