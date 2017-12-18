package sample.Presenters;

import sample.Data.Credentials;
import sample.Data.DatabaseWrapper;
import sample.Data.Users.User;
import sample.Data.Users.UserData;
import sample.Views.RegisterView;

public class RegisterPresenter {

    private RegisterView view;

    public RegisterPresenter(RegisterView registerView) {
        view = registerView;
    }

    public boolean createAccount(Credentials credentials, UserData data) {

        if(DatabaseWrapper.checkUsernameIsAvailable(credentials.getUsername())) {
            DatabaseWrapper.addNewUser(credentials, data);
            return true;
        }

        return false;
    }

    public boolean verifyPasswords(String password, String passwordRepeat) {
        if(password.equals(passwordRepeat)) return true;
        else return false;
    }
}
