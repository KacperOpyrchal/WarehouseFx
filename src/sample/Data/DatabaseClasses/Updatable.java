package sample.Data.DatabaseClasses;

import com.sun.tools.javac.util.Pair;
import sample.Tools.Item;

import java.io.PrintWriter;
import java.util.List;

public interface Updatable {

    void update(List<String> values);

    List<Pair<String, String>> getUpdatableList();

    List<Item> toItemsList();

    void writeToFile(PrintWriter printWriter);

    void addToDatabase();

    void deleteFromDatabase();
}
