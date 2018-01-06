package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseWrapper;
import sample.Data.GlobalStage;
import sample.Data.DatabaseClasses.Warehouse;
import sample.Tools.SceneProvider;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class WelcomeView implements View{

    private Label welcome = label("");
    private Button logOut = button("Log out");

    @Override
    public Pane getPane() {
        setUpListeners();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        List<Warehouse> list = DatabaseWrapper.loadAllWarehouses();
        GeneralTableView<Warehouse> generalTableView = new GeneralTableView<>(list,
                label("ID"), label("Name"), label("Capacity"));

        vBox.getChildren().addAll(welcome, generalTableView.getPane(), logOut);

        return vBox;
    }

    @Override
    public void setUpListeners() {
        logOut.setOnAction(event -> GlobalStage.getGlobalStage().introduceNewScene(new Pair<>(new LoginView(), "Login")));
    }
}
