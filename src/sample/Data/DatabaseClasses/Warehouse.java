package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private int id;
    private String name;
    private int groupId;
    private int capacity;
    private int value;
    private Manager manager;
    private List<Provider> providers;
    private List<Section> sections;

    public Warehouse(int id, String name, int groupId, int capacity, int value, Manager manager) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.capacity = capacity;
        this.value = value;
        this.manager = manager;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Item> toItemList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(id+"", () -> id = 0));
        list.add(new MenuItem(name, () -> name = ""));
        list.add(new MenuItem(groupId+"", () -> groupId = 0));
        list.add(new MenuItem(capacity+"", () -> capacity = 0));
        list.add(new MenuItem(value+"", () -> value = 0));
        list.add(new MenuItem(manager +"", () -> manager = new Manager()));
        return list;
    }
}