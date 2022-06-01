package com.example.wgmanager.Controller;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.View.IView;

public class EventController implements IController {

    //Charly

    private IView View;
    //CurrentUser hält alle Daten zur Laufzeit
    private CurrentUser currentUser;


    public EventController(IView View) {
        this.View = View;
    }

    //Hier wird eine Instanz von CurrentUser erzeugt. Die Instanz ist überall gleich!
    public String getCurrentUser() {
        currentUser = CurrentUser.getInstance();
        return currentUser.retrieveUser().getUsername();


    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        View.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView(String message) {

    }
}
