package sample.Data.DatabaseClasses;

import sample.Tools.Item;

import java.util.List;

public interface Updatable {

    void update(List<String> values);

    List<Item> toItemsList();
}
