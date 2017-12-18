package sample.Tools;

import sample.Data.AccountType;

public interface Strategy {

    AccountType getAccountType();

    boolean verify();
}
