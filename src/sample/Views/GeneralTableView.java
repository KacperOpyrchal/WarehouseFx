package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseClasses.Updatable;
import sample.Tools.Item;
import sample.Tools.SceneProvider;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

class GeneralTableView<T extends Updatable> implements View {

    private List<List<Item>>  items;

    private GridPane gridPane = gridPane();

    public GeneralTableView(List<T>  items) {
        this.items = new ArrayList<>();
        for(T t : items) {
            this.items.add(t.toItemsList());
        }
        fillGrid();
        setUpListeners();
    }

    @Override
    public Pane getPane() {
        setUpListeners();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        gridPane.setVgap(2);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(scrollPane);
        return vBox;
    }

    @Override
    public void setUpListeners() {
        // no-op
    }

    private void fillGrid() {
        for (int row = 0; row < items.size(); ++row) {
            int column = 0;
            for (; column < items.get(row).size(); ++column) gridPane.add(items.get(row).get(column).getButton(), column, row);

            Button editButton = generateEditButton(row);
            gridPane.add(editButton, column, row);
            gridPane.add(generateDeleteButton(row, editButton), column+1, row);
        }

    }

    private Button generateEditButton(int row) {
        Button button = SceneProvider.greenButton("Edit");
        button.setOnAction(e -> {

        });

        return button;
    }

    private Button generateDeleteButton(int row, Button editButton) {
        Button button = SceneProvider.redButton("Delete");
        button.setOnAction(e -> {
            items.get(row).get(0).deleteValue();
            for(Item item : items.get(row)) {
                item.getButton().setText("");
                item.getButton().setVisible(false);
                item.getButton().setManaged(false);
            }
            editButton.setVisible(false);
            editButton.setManaged(false);
            button.setVisible(false);
            button.setManaged(false);
        });

        return button;
    }
}
