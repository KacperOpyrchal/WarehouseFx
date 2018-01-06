package sample.Data.DatabaseClasses;

import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Product implements Updatable {
    private int id;
    private String name;
    private double price;
    private double weight;
    private int amount;
    private List<Section> sections;
    private List<Provider> providers;

    public Product() {
    }

    public Product(int id, String name, double price, double weight, int amount, List<Section> sections, List<Provider> providers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sections = sections;
        this.providers = providers;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void update(List<String> values) {

    }

    @Override
    public List<Item> toItemsList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        list.add(new MenuItem("Providers", ()->"".toString()));
        return list;

    }
}
