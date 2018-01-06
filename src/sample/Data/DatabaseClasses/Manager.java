package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Updatable {
    private List<Section> sections;
    private String name;
    private String surname;
    private int id;
    private double salary;

    public Manager() {
    }

    public Manager(List<Section> sections, String name, String surname, int id, double salary) {
        this.sections = sections;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void update(List<String> values) {

    }

    @Override
    public List<Item> toItemsList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        return list;
    }
}
