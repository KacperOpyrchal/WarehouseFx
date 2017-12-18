package sample.Data.Users;

import sample.Data.AccountType;
import sample.Data.Credentials;

public interface User {

    void setCredentials(Credentials credentials);

    Credentials getCredentials();

    void setUserData(UserData userData);

    UserData getUserData();

    AccountType getAccountType();
}
