package sample.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.GlobalStage;
import sample.Tools.SceneProvider;

public class WelcomeView implements View{

    Label welcome = SceneProvider.label("");

    Button logOut = SceneProvider.button("Log out");

    @Override
    public Pane getPane() {
        setUpListeners();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(welcome, logOut);

        return vBox;
    }

    @Override
    public void setUpListeners() {
        logOut.setOnAction(event -> GlobalStage.getGlobalStage().introduceNewScene(new LoginView()));
    }
}
