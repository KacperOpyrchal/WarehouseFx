package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.pair;
import static sample.Tools.SceneProvider.pairList;

public class Product implements Updatable {
    private int id;
    private String name;
    private double price;
    private double weight;
    private int amount;
    private Section section;
    private List<Provider> providers;
    private List<Item> list = null;

    public Product() {
    }

    public Product(int id, String name, double price, double weight, int amount, Section section, List<Provider> providers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.section = section;
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

    public Section getSections() {
        return section;
    }

    public void setSections(Section section) {
        this.section = section;
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
        id = Integer.parseInt(values.get(0));
        name = values.get(1);
        price = Double.parseDouble(values.get(2));
        weight = Double.parseDouble(values.get(3));
        amount = Integer.parseInt(values.get(4));
    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return pairList(pair("ID", id + ""),
                pair("Name", name),
                pair("Price", price + ""),
                pair("Weight", weight + ""),
                pair("Amount", amount + ""));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Sections", () -> "".toString()));
        list.add(new MenuItem("Providers", ()->"".toString()));
        return list;

    }

    @Override
    public void writeToFile(PrintWriter printWriter) {
        printWriter.println(id +
                ", " + name +
                ", " + price +
                ", " + weight +
                ", " + amount +
                ", " + section.getId());
        for (Provider provider: providers) {
            printWriter.print(provider.getId() + ", ");
        }
        printWriter.println();
        printWriter.flush();
    }
}
