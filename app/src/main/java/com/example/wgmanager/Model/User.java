package com.example.wgmanager.Model;

public class User {

    private String email; //HALLO GEHT DAS, zweiter Test
    private String username;
    private String password;

    public User(String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //TESTTESTTEST

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
