package sample;

import com.sun.tools.javac.util.Pair;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.Views.LoginView;
import sample.Views.View;

import static sample.Data.GlobalStage.getGlobalStage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        getGlobalStage().initStage(primaryStage);
        primaryStage.setTitle("Projekt");
        View loginView = new LoginView();
        getGlobalStage().introduceNewScene(new Pair<>(loginView, "Login"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }}
