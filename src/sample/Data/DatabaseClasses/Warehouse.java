package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Updatable{

    private int id;
    private String name;
    private int capacity;
    private Manager manager;
    private List<Provider> providers;
    private List<Section> sections;

    public Warehouse() {
    }

    public Warehouse(int id, String name, int capacity, Manager manager, List<Provider> providers, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.manager = manager;
        this.providers = providers;
        this.sections = sections;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public List<Item> toItemsList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name = ""));
        list.add(new MenuItem("Providers", () -> capacity = 0));
        list.add(new MenuItem("Sections", () -> manager = new Manager()));
        return list;
    }

    @Override
    public void update(List<String> values) {
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        capacity = Integer.parseInt(values.get(2));
    }
}