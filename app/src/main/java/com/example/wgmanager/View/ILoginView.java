package com.example.wgmanager.View;

import com.example.wgmanager.Controller.UserAuthenticationController;

public interface ILoginView {

    void showUserDetails(String message);

    void loadNewActivity(Class activityClass);

}
