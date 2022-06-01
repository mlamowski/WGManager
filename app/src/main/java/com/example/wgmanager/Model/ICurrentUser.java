package com.example.wgmanager.Model;

public interface ICurrentUser {

    public User retrieveUser();

    public void updateUser();

    public void createUser(String username, String password);
}
