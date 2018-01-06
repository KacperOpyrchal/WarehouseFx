package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.Data.AccountType;
import sample.Data.Builders.CredentialsBuilder;
import sample.Data.Builders.UserDataBuilder;
import sample.Data.GlobalStage;
import sample.Presenters.RegisterPresenter;
import sample.Tools.SceneProvider;

import static sample.Tools.SceneProvider.*;

public class RegisterView implements View{

    private TextField name = textField();
    private TextField surname = textField();
    private TextField username = textField();
    private TextField password = passwordField();
    private TextField repeatPassword = passwordField();
    private Spinner<AccountType> accountTypeSpinner = accountTypeSpinner();
    private Button registerBtn = submitButton("Create new account");

    private Label wrongLabel = label("");

    private RegisterPresenter presenter = new RegisterPresenter(this);

    @Override
    public GridPane getPane() {
        setUpListeners();
        wrongLabel.setId("red");
        GridPane gridPane = gridPane();
        gridPane.addColumn(0, label("Name:"), label("Surname:"),
                label("Username:"), label("Password:"),
                label("Repeat Password"), label("Account Type:"), wrongLabel);
        gridPane.addColumn(1, name, surname, username, password, repeatPassword, accountTypeSpinner, registerBtn);
        return gridPane;
    }

    @Override
    public void setUpListeners() {
        registerBtn.setOnAction((ActionEvent event) -> {
            if(presenter.verifyPasswords(password.getText(), repeatPassword.getText())) {
                CredentialsBuilder credentialsBuilder = new CredentialsBuilder();
                UserDataBuilder userDataBuilder = new UserDataBuilder();
                if(presenter.createAccount(credentialsBuilder
                        .setUsername(username.getText())
                        .setPassword(password.getText())
                        .setAccuntType(accountTypeSpinner.getValue())
                        .build(),
                        userDataBuilder
                                .setName(name.getText())
                                .setSurname(surname.getText())
                                .build())) {

                    GlobalStage.getGlobalStage().introduceNewScene(new Pair<>(new WelcomeView(), "Welcome"));
                } else {
                    wrongLabel.setText("Username already exists!");
                }
            } else {
                wrongLabel.setText("Passwords are different!");
            }
        });
    }

}
