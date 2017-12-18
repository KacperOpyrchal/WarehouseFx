package sample.Views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.Presenters.LoginPresenter;

import static sample.Tools.SceneProvider.*;

public class LoginView implements View {

    private TextField login =  new TextField();
    private TextField password = new PasswordField();

    private Button logInBtn = button("Log in");
    private Button registerBtn = submitButton("Sign in");

    private Label validCredentialsLabel = label("Invalid login or password! Try again");

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    public LoginView() {
        setUpListeners();
    }

    @Override
    public VBox getPane() {
        setVisibilityOfValidationMessage(false);
        validCredentialsLabel.setId("red");

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(getMainContentPane(), validCredentialsLabel, registerBtn);
        vbox.setAlignment(Pos.CENTER);

        return vbox;
    }

    private GridPane getMainContentPane() {
       GridPane gridPane = gridPane();
       gridPane.addColumn(1, login, password, logInBtn);
       gridPane.addColumn(0, label("Login"), label("Password"));

       return gridPane;
    }

    @Override
    public void setUpListeners() {
        logInBtn.setOnAction(event -> {
            loginPresenter.login(login.getText(), password.getText());
        });

        registerBtn.setOnAction(event -> loginPresenter.register());
    }

    public void setVisibilityOfValidationMessage(boolean visibility) {
        validCredentialsLabel.setVisible(visibility);
    }

}
