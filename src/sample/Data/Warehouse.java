package sample.Data;

import sample.Tools.Action;
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
    private int headmasterId;

    public Warehouse(int id, String name, int groupId, int capacity, int value, int headmasterId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.capacity = capacity;
        this.value = value;
        this.headmasterId = headmasterId;
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

    public int getHeadmasterId() {
        return headmasterId;
    }

    public void setHeadmasterId(int headmasterId) {
        this.headmasterId = headmasterId;
    }

    public List<Item> toItemList() {
        List<Item> list = new ArrayList<>();
        list.add(new MenuItem(id+"", () -> id = 0));
        list.add(new MenuItem(name, () -> name = ""));
        list.add(new MenuItem(groupId+"", () -> groupId = 0));
        list.add(new MenuItem(capacity+"", () -> capacity = 0));
        list.add(new MenuItem(value+"", () -> value = 0));
        list.add(new MenuItem(headmasterId+"", () -> headmasterId = 0));
        return list;
    }
}