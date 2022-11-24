package com.example.UntitledTestSuite.Model;

public class AccountData {
    public String Username;
    public String Password;

    public AccountData (String username, String password){
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
