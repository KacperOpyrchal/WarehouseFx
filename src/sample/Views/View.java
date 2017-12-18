package sample.Views;

import javafx.scene.layout.Pane;

public interface View {

    Pane getPane();

    void setUpListeners();
}
