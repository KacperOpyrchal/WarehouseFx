package sample.Views;

import javafx.stage.Stage;

public abstract class Floatable implements View{

    protected Stage stage;

    public void withStage(Stage stage) {
        this.stage = stage;
    }

    public View getView() {
        return this;
    }
}
