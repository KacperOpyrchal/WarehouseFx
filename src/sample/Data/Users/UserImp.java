package sample.Data.Users;

import sample.Data.AccountType;
import sample.Data.Credentials;

public class UserImp implements User {

    Credentials credentials;
    UserData userData;

    public UserImp(Credentials credentials) {
        this.credentials = credentials;
    }

    public UserImp(Credentials credentials, UserData userData) {
        this.credentials = credentials;
        this.userData = userData;
    }

    @Override
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public UserData getUserData() {
        return userData;
    }

    @Override
    public AccountType getAccountType() {
        return credentials.getAccountType();
    }
}
