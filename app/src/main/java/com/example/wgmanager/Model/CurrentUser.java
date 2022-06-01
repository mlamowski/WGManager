package com.example.wgmanager.Model;

public class CurrentUser implements ICurrentUser{

    //CurrentUser hält alle Daten zur Laufzeit.

    private User user;

    //Singleton
    private static CurrentUser instance;
    private CurrentUser() {

    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return  instance;
    }

    //Normal Object Code

    public User retrieveUser() {

        return user;
    }

    public void updateUser() {
        //Aktueller User geupdatet
    }

    public void createUser(String username, String password) {
        user = new User(username, password);
    }

}
