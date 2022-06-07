package com.example.wgmanager.Model;

public interface ICurrentUser {

    public User retrieveUser();

    public void updateUser();

    public void createUserFromData(String username, String password,String groupName);
    public void createNewUser(String username, String password);

}
