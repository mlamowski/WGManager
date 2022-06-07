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
        //Lade gesuchten User aus DB
        return user;
    }

    public void updateUser() {
        //Aktueller User geupdatet
    }


    //Für Login, Group hat einen fiktiven GroupName
    @Override
    public void createUserFromData(String username, String password, String groupName) {
        user = new User(username, password, groupName);

    }

    //Für Registrierung, Group = null
    @Override
    public void createNewUser(String username, String password) {
        user = new User(username, password);
    }

    public void updatePassword(String password) {
        user.setPassword(password);
    }

    public void updateUsername(String username) {
        user.setUsername(username);
    }


}
