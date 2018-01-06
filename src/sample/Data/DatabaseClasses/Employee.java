package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class Employee implements Updatable {
    private int id;
    private String name;
    private String surname;
    private String position;
    private double salary;
    private Section section;
    private Manager manager;
    private List<Item> list = null;

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
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        surname = values.get(2);
        position = values.get(3);
        salary = Double.parseDouble(values.get(4));

        if(list != null) {
            list.get(0).updateItem(name);
        }
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""),
                pair("Name", name),
                pair("Surname", surname),
                pair("Position", position + ""),
                pair("Salary", salary + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Manager", () -> "".toString()));
        return list;
    }
}
