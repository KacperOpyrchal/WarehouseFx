package sample.Presenters;

import sample.Data.Builders.CredentialsBuilder;
import sample.Data.DatabaseWrapper;
import sample.Data.GlobalStage;
import sample.Data.Users.User;
import sample.Data.Users.UserImp;
import sample.Views.LoginView;
import sample.Views.RegisterView;
import sample.Views.WelcomeView;

public class LoginPresenter {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        DatabaseWrapper.loadAllUsers();
    }

    public void login(String username, String password) {
        CredentialsBuilder builder = new CredentialsBuilder();
        User user = new UserImp(builder.setUsername(username).setPassword(password).build());

        if(DatabaseWrapper.verifyUser(user)) {
            loginView.setVisibilityOfValidationMessage(false);
            GlobalStage.getGlobalStage().introduceNewScene(new WelcomeView());
        } else {
            loginView.setVisibilityOfValidationMessage(true);
        }
    }

    public void register() {
        RegisterView registerView = new RegisterView();

        GlobalStage.getGlobalStage().introduceNewScene(registerView);
    }
}
