package com.example.wgmanager.Controller;

import android.content.Intent;

import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.HomeActivity;
import com.example.wgmanager.View.ILoginView;
import com.example.wgmanager.View.MainActivity;
import com.example.wgmanager.View.RegisterActivity;

public class UserAuthenticationController {

    ILoginView view;

    public User user;
    private UserController userController;

    public UserAuthenticationController(ILoginView view) {
        this.view = view;
    }


    public void onLogin(String username, String password, Class activityClass) {
        //TODO: validate
        user = new User(username, password);
        //userController = new UserController(user);
        loadNewPage(activityClass);

    }

    public void ToRegister(Class activityClass) {

        loadNewPage(activityClass);
    }

    public void onRegister(String username, String password, Class activityClass) {
        //TODO: validate
        user = new User(username, password);
        //TODO: Update Model --> Singleton
        //userController = new UserController(user);
        loadNewPage(HomeActivity.class);

    }

    public void updateView() {

        view.showUserDetails(user.getUsername());
    }

    public void loadNewPage(Class activityClass) {
        view.loadNewActivity(activityClass);
    }
}
