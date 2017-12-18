package sample.Tools;

import sample.Data.AccountType;

public class AdminStrategy implements Strategy {
    @Override
    public AccountType getAccountType() {
        return AccountType.ADMIN;
    }

    @Override
    public boolean verify() {
        // to-do
        return true;
    }
}
