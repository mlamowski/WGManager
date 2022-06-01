package com.example.wgmanager.Controller;

import android.content.Context;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.MainActivity;
import com.example.wgmanager.View.IView;

public class UserAuthenticationController implements Controller {

    private IView view;
    private CurrentUser currentUser;

    public UserAuthenticationController(IView view) {
        this.view = view;
    }

    public void onLogin(String username, String password, Class activityClass) {
        //TODO: validate
        //TODO: Create SessionManager und übergib User

        currentUser = CurrentUser.getInstance();
        currentUser.createUser(username, password);
        loadNewPage(activityClass);

    }

    public void ToRegister(Class activityClass) {

        loadNewPage(activityClass);
    }

    public void onRegister(String username, String password, Class activityClass) {
        //TODO: validate
        //TODO: Create SessionManager und übergib User

        currentUser = CurrentUser.getInstance();
        currentUser.createUser(username, password);
        loadNewPage(activityClass);

    }

    public void updateView() {
        view.showUserDetails(currentUser.retrieveUser().getUsername());
    }

    public void loadNewPage(Class activityClass) {
        view.loadNewActivity(activityClass);
    }
}
