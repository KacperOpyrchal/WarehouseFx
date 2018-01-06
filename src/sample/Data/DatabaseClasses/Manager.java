package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.pair;
import static sample.Tools.SceneProvider.pairList;

public class Manager implements Updatable {
    private List<Section> sections;
    private int id;
    private String name;
    private String surname;
    private double salary;
    private List<Item> list = null;

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
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        surname = values.get(2);
        salary = Integer.parseInt(values.get(3));

        if(list != null) {
            list.get(0).updateItem(name);
        }
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""), pair("Name", name), pair("Surname", surname), pair("Salary", salary + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        return list;
    }
}
