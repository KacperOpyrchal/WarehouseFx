package sample.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Tools.Item;
import sample.Tools.SceneProvider;

import java.util.List;

import static sample.Tools.SceneProvider.*;

class GeneralTableView implements View {

    private List<List<Item>>  items;

    private GridPane gridPane = gridPane();

    public GeneralTableView(List<List<Item>>  items) {
        this.items = items;
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

            gridPane.add(generateDeleteButton(row), column, row);
        }

    }

    private Button generateDeleteButton(int row) {
        Button button = SceneProvider.submitButton("Delete");
        button.setOnAction(e -> {
            items.get(row).get(0).deleteValue();
            for(Item item : items.get(row)) {
                item.getButton().setText("");
                item.getButton().setVisible(false);
                item.getButton().setManaged(false);
                button.setVisible(false);
                button.setManaged(false);
            }
        });

        return button;
    }
}
