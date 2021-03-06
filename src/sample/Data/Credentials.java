package sample.Data;

public class Credentials {
    private String username;
    private String password;
    private AccountType accountType;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
        this.accountType = AccountType.STANDARD;
    }

    public Credentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
