package com.example.wgmanager.Controller;

import android.content.Intent;

import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.IHomeview;
import com.example.wgmanager.View.MainActivity;
import com.example.wgmanager.View.RegisterActivity;

public class UserController {

    //Giuliano

    private User user;
    private IHomeview homeView;

    //User Daten werden noch nicht automatisch hinzugefügt. Du musst erstmal mit Dummy Daten arbeiten, ich mach das noch.

    public UserController(IHomeview view) {
        super();
        this.homeView = view;
    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        homeView.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView() {

    }

}
