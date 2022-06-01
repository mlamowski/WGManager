package com.example.wgmanager.Controller;

import android.content.Context;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.View.IView;
import com.example.wgmanager.View.LoginActivity;

public class UserController implements IController {

    //Giuliano

    IView View;

    //CurrentUser hält alle Daten zur Laufzeit
    private CurrentUser currentUser;

    SessionService sessionService;


    public UserController(IView view, Context context) {
        this.View = view;
        sessionService = new SessionService(context);

    }

    //Hier wird eine Instanz von CurrentUser erzeugt. Die Instanz ist überall gleich!
    public String getCurrentUserName() {
        currentUser = CurrentUser.getInstance();
        return currentUser.retrieveUser().getUsername();
    }

    public void logout() {
        sessionService.removeSession();
        loadNewPage(LoginActivity.class);
    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        View.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView(String message) {

    }



}
