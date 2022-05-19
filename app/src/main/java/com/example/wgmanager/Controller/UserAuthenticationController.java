package com.example.wgmanager.Controller;

import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.ILoginView;
import com.example.wgmanager.View.MainActivity;
import com.example.wgmanager.View.RegisterActivity;

public class UserAuthenticationController {

    ILoginView view;

    private User user;
    private UserController userController;

    public UserAuthenticationController(ILoginView view) {
        this.view = view;
    }

    public void onLogin(String username, String password) {
        //TODO: validate
        user = new User(username, password);
        userController = new UserController(user);

    }

    public void ToRegister() {
        view.loadNewActivity();
    }

    public void onRegister(String username, String password) {
        //TODO: validate
        user = new User(username, password);
        //TODO: Update Model --> Singleton
        userController = new UserController(user);
    }

    public void updateView() {

        view.showUserDetails(user.getUsername());
    }
}
