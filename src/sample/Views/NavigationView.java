package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Presenters.NavigationPresenter;

import static sample.Tools.SceneProvider.button;

public class NavigationView implements View {

    private Button next = button("->");
    private Button prev = button("<-");

    private Label title = new Label("Login");

    private NavigationPresenter presenter = new NavigationPresenter(this);

    public NavigationView() {
        setUpListeners();
        next.setDisable(true);
        prev.setDisable(true);
    }

    @Override
    public Pane getPane() {
        title.setStyle("-fx-font-size: 26px;-fx-font: oblique;");

        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);

        HBox arrows = new HBox(10);
        arrows.getChildren().addAll(prev, next);
        arrows.setAlignment(Pos.TOP_LEFT);
        arrows.setPadding(new Insets(20));

        HBox titleBox = new HBox();
        titleBox.getChildren().addAll(title);
        titleBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(arrows, titleBox);
        return root;
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

    public void updateTitle(String str) {
        title.setText(str);
    }

    public void updateStack(Pair<View, String> view) {
        presenter.updateStack(view);
    }
}
