package com.example.wgmanager.Controller;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.IView;

public class UserController {

    //Giuliano

    IView homeView;
    //CurrentUser hält alle Daten zur Laufzeit
    private CurrentUser currentUser;

    public UserController(IView view) {
        super();
        this.homeView = view;
    }

    //Hier wird eine Instanz von CurrentUser erzeugt. Die Instanz ist überall gleich!
    public String getCurrentUser() {
        currentUser = CurrentUser.getInstance();
        return currentUser.retrieveUser();


    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        homeView.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView() {

    }

}
