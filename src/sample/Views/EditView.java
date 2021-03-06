package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseClasses.Updatable;
import sample.Tools.Action;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class EditView extends Floatable {

    private List<TextField> fields = new ArrayList<>();
    private GridPane panes = gridPane();

    private Button updateButton = submitButton("Update");

    private Updatable updatable;

    private Action reload;

    public EditView(Updatable updatable, Action reload) {
        this.updatable = updatable;
        this.reload = reload;

        int i = 0;
        for(Pair<String, String> str : updatable.getUpdatableList()) {
            TextField textField = textField(str.snd);
            fields.add(textField);
            panes.addRow(i, new Label(str.fst), textField);
            if(i == 0) {
                textField.setDisable(true);
            }

            i++;
        }
    }



    private void update() {
        List<String> values = new ArrayList<>();

        for(TextField field : fields) {
            values.add(field.getText());
        }

        updatable.update(values);
        stage.close();
        reload.call();
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