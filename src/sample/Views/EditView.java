package sample.Views;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.Data.DatabaseClasses.Updatable;

public class EditView implements View{

    public void withUpdatable(Updatable updatable) {

    }

    @Override
    public Pane getPane() {
        HBox hBox = new HBox();

        return hBox;
    }

    @Override
    public void setUpListeners() {
        // no-op
    }
}
