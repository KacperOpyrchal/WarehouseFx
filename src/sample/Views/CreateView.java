package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Data.DatabaseClasses.Updatable;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.submitButton;
import static sample.Tools.SceneProvider.textField;

public class CreateView implements View {

    private List<TextField> fields = new ArrayList<>();
    private GridPane panes = new GridPane();

    private Button updateButton = submitButton("Update");

    private List<Updatable> updatable;

    Stage stage;

    public CreateView(List<Updatable> updatable) {
        this.updatable = updatable;

        int i = 0;
        for(Pair<String, String> str : updatable.get(0).getUpdatableList()) {
            TextField textField = textField();
            fields.add(textField);
            panes.addRow(i, new Label(str.fst), textField);
            if(i == 0) {
                textField.setDisable(true);
            }

            i++;
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void update() {
        List<String> values = new ArrayList<>();

        for(TextField field : fields) {
            values.add(field.getText());
        }

//        updatable.update(values);

        stage.close();
    }

    @Override
    public Pane getPane() {
        setUpListeners();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(panes);
        vBox.getChildren().add(updateButton);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    @Override
    public void setUpListeners() {
        updateButton.setOnAction(e -> {
            update();
        });
    }

}
