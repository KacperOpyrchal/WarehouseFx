package sample.Data.Builders;

import sample.Data.Users.UserData;

public class UserDataBuilder {

    UserData userData = new UserData();

    public UserDataBuilder setName(String name) {
        userData.setName(name);
        return this;
    }

    public UserDataBuilder setSurname(String surname) {
        userData.setSurname(surname);
        return this;
    }

    public UserData build() {
        return userData;
    }
}
