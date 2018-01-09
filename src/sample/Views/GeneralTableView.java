package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseClasses.Updatable;
import sample.Data.GlobalStage;
import sample.Tools.Action;
import sample.Tools.Item;
import sample.Tools.SceneProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static sample.Tools.SceneProvider.*;

class GeneralTableView<T extends Updatable> implements View {

    private List<List<Item>> fields;
    private List<T> items;
    private List<Label> labels;

    private Button logOut = button("Log out");

    private GridPane gridPane = gridPane();

    private Action reload;

    public GeneralTableView(List<T>  items, Label... labels) {
        this.labels = Arrays.asList(labels);
        this.items = items;
        this.fields = new ArrayList<>();
        for(T t : items) {
            this.fields.add(t.toItemsList());
        }
        fillGrid();
        setUpListeners();
    }

    public void reload(List<T>  items, Label... labels) {
        this.labels = Arrays.asList(labels);
        this.items = items;
        this.fields = new ArrayList<>();
        for(T t : items) {
            this.fields.add(t.toItemsList());
        }
        fillGrid();
        setUpListeners();

    }

    public void withReload(Action reload) {
        this.reload = reload;
    }

    @Override
    public Pane getPane() {
        setUpListeners();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        gridPane.setVgap(2);
        gridPane.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(15);
        hBox.getChildren().addAll(generateCreateButton(), logOut);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(scrollPane, hBox);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    @Override
    public void setUpListeners() {
        logOut.setOnAction(event -> GlobalStage.getGlobalStage().introduceNewScene(new Pair<>(new LoginView(), "Login")));
    }

    private void fillGrid() {
        for(int i = 0; i < labels.size(); ++i) {
            gridPane.add(labels.get(i), i, 0);
        }

        for (int row = 1; row < fields.size(); ++row) {
            int column = 0;
            for (; column < fields.get(row).size(); ++column) gridPane.add(fields.get(row).get(column).getButton(), column, row);

            Button editButton = generateEditButton(row);
            gridPane.add(editButton, column, row);
            gridPane.add(generateDeleteButton(row, editButton), column+1, row);
        }

    }

    private Button generateCreateButton() {
        Button button = SceneProvider.greenButton("Create");
        button.setOnAction(e -> {
            CreateView createView = new CreateView(items.get(items.size() - 1), reload);
            GlobalStage.getGlobalStage().introduceNewStage(new Pair<>(createView, "Create"));
        });

        return button;
    }

    private Button generateEditButton(int row) {
        Button button = SceneProvider.greenButton("Edit");
        button.setOnAction(e -> {
            EditView editView = new EditView(items.get(row), reload);
            GlobalStage.getGlobalStage().introduceNewStage(new Pair<>(editView, "Edit"));
        });

        return button;
    }

    private Button generateDeleteButton(int row, Button editButton) {
        Button button = SceneProvider.redButton("Delete");
        button.setOnAction(e -> {
            fields.get(row).get(0).delete();
            for(Item item : fields.get(row)) {
                item.getButton().setText("");
                item.getButton().setVisible(false);
                item.getButton().setManaged(false);
            }
            items.get(row).deleteFromDatabase();
            editButton.setVisible(false);
            editButton.setManaged(false);
            button.setVisible(false);
            button.setManaged(false);
        });

        return button;
    }
}
