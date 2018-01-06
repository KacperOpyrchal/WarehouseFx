package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseClasses.Manager;
import sample.Data.GlobalStage;
import sample.Data.DatabaseClasses.Warehouse;
import sample.Tools.Item;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class WelcomeView implements View{

    private Label welcome = label("");
    private Button logOut = button("Log out");

    private List<Warehouse> list = new ArrayList<>();

    @Override
    public Pane getPane() {
        setUpListeners();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        fillList();
        GeneralTableView<Warehouse> generalTableView = new GeneralTableView<>(list);
        vBox.getChildren().addAll(welcome, generalTableView.getPane(), logOut);

        return vBox;
    }

    private void fillList() {
        String[] strs = {"dfsdf", "safdjsadj", "magazynek", "penis",
                "chsfd", "asf", "hghf", "kupa",
                "ssx", "efjsadj", "cebula i chrzan", "kdjfds",
                "safdjsretjhadj", "blabla", "jj", "jsadj",
                "saf", "safdjsadj", "magazynkgo", "safdjsadj",
                "saaaa", "plmjf", "jakismagazyn"};

        for(int i = 0; i < 20; ++i) {
            Warehouse warehouse = new Warehouse(i,strs[i], i, new Manager(), new ArrayList<>(), new ArrayList<>());
            list.add(warehouse);
        }
    }

    @Override
    public void setUpListeners() {
        logOut.setOnAction(event -> GlobalStage.getGlobalStage().introduceNewScene(new Pair<>(new LoginView(), "Login")));
    }
}
