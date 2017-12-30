package sample.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.GlobalStage;
import sample.Data.Warehouse;
import sample.Tools.Item;
import sample.Tools.SceneProvider;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class WelcomeView implements View{

    private Label welcome = label("");
    private Button logOut = button("Log out");

    private List<List<Item>> list = new ArrayList<>();

    @Override
    public Pane getPane() {
        setUpListeners();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        fillList();
        GeneralTableView generalTableView = new GeneralTableView(list);
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
            Warehouse warehouse = new Warehouse(i,strs[i], i, i, i, i);
            list.add(warehouse.toItemList());
        }
    }

    @Override
    public void setUpListeners() {
        logOut.setOnAction(event -> GlobalStage.getGlobalStage().introduceNewScene(new LoginView()));
    }
}
