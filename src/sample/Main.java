package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Views.LoginView;
import sample.Views.View;

import static sample.Data.GlobalStage.getGlobalStage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        getGlobalStage().initStage(primaryStage);
        primaryStage.setTitle("Projekt na wzorce czy cos");
        View loginView = new LoginView();
        getGlobalStage().introduceNewScene(loginView);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
