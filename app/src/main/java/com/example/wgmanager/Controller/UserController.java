package com.example.wgmanager.Controller;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.View.IView;

public class UserController implements Controller {

    //Giuliano

    IView View;
    //CurrentUser hält alle Daten zur Laufzeit
    private CurrentUser currentUser;

    public UserController(IView view) {
        super();
        this.View = view;
    }

    //Hier wird eine Instanz von CurrentUser erzeugt. Die Instanz ist überall gleich!
    public String getCurrentUserName() {
        currentUser = CurrentUser.getInstance();
        return currentUser.retrieveUser().getUsername();


    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        View.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView() {

    }

}
