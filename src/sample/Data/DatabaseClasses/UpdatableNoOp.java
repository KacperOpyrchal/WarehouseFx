package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UpdatableNoOp implements Updatable {
    @Override
    public void update(List<String> values) {

    }

    @Override
    public List<Pair<String, String>> getUpdatableList() {
        return new ArrayList<>();
    }

    @Override
    public List<Item> toItemsList() {
        return new ArrayList<>();
    }

    @Override
    public void addToDatabase(List<String> values) {

    }

    @Override
    public void deleteFromDatabase() {

    }

    @Override
    public int getID() {
        return -1;
    }
}
