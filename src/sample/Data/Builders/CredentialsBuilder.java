package sample.Data.Builders;

import sample.Data.AccountType;
import sample.Data.Credentials;

public class CredentialsBuilder {

    Credentials credentials;

    public CredentialsBuilder() {
        credentials = new Credentials();
    }

    public CredentialsBuilder setUsername(String username) {
        credentials.setUsername(username);
        return this;
    }

    public CredentialsBuilder setPassword(String password) {
        credentials.setPassword(password);
        return this;
    }

    public CredentialsBuilder setAccuntType(AccountType accuntType) {
        credentials.setAccountType(accuntType);
        return this;
    }

    public Credentials build() {
        return credentials;
    }
}
