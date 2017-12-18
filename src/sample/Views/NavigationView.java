package sample.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.Data.GlobalStage;
import sample.Presenters.NavigationPresenter;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class NavigationView implements View {

    Button next = button("->");
    Button prev = button("<-");

    NavigationPresenter presenter = new NavigationPresenter(this);

    public NavigationView() {
        setUpListeners();
        next.setDisable(true);
        prev.setDisable(true);
    }

    @Override
    public Pane getPane() {
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(prev, next);
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.setPadding(new Insets(20));
        return hBox;
    }

    @Override
    public void setUpListeners() {
        next.setOnAction(event -> presenter.onNext());

        prev.setOnAction(event -> presenter.onPrev());
    }

    public void setDisable(boolean prevDisable, boolean nextDisable) {
        prev.setDisable(prevDisable);
        next.setDisable(nextDisable);
    }

    public void updateStack(View view) {
        presenter.updateStack(view);
    }
}
