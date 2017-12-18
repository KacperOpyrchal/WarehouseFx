package sample.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Controller;
import sample.Data.AccountType;
import sample.Views.NavigationView;
import sample.Views.View;

import java.util.ArrayList;
import java.util.Arrays;

import static sample.Data.AccountType.*;

public class SceneProvider {

    public static NavigationView navigationView = new NavigationView();

    public static Label label(String text) {
        return new Label(text);
    }

    public static TextField textField() {
        return new TextField();
    }

    public static PasswordField passwordField() {
        return new PasswordField();
    }

    public static Button button(String text) {
        Button btn = new Button(text);
        btn.setId("glass-grey");
        return btn;
    }

    public static Button submitButton(String text) {
        Button btn = new Button(text);
        btn.setId("round-red");
        return btn;
    }
    public static Spinner<AccountType> accountTypeSpinner() {
        ObservableList<AccountType> types = FXCollections.observableArrayList(STANDARD, WORKER, ADMIN);
        SpinnerValueFactory<AccountType> factory = new SpinnerValueFactory.ListSpinnerValueFactory<AccountType>(types);
        Spinner spinner = new Spinner();
        spinner.setValueFactory(factory);

        return spinner;
    }

    public static GridPane gridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        return gridPane;
    }

    public static Scene generalUseScene(View view) {
        navigationView.updateStack(view);
        return generalReuseScene(view);
    }

    public static Scene generalReuseScene(View view) {
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(navigationView.getPane(), view.getPane());
        Scene scene = new Scene(vBox, 500, 500);
        String css = Controller.class.getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        vBox.setId("pane");
        return scene;
    }
}
