package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;
import sample.Tools.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class Equipment implements Updatable {
    private int id;
    private String name;
    private Section section;
    private List<Item> list = null;

    public Equipment() {
    }

    public Equipment(String name, int id, Section section) {
        this.name = name;
        this.id = id;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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
        return pairList( pair("ID", id + ""), pair("Name", name));
    }

    @Override
    public List<Item> toItemsList() {
        list = new ArrayList<>();
        list.add(new MenuItem(name, () -> name.toString()));
        list.add(new MenuItem("Section", () -> "".toString()));
        return list;
    }
}
