package sample.Tools;

import sample.Data.AccountType;

public class StandardStrategy implements Strategy {
    @Override
    public AccountType getAccountType() {
        return AccountType.STANDARD;
    }

    @Override
    public boolean verify() {
        // to-do
        return true;
    }
}
