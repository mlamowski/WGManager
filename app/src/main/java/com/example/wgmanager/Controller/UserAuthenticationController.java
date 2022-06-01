package com.example.wgmanager.Controller;

import android.content.Context;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.View.MainActivity;
import com.example.wgmanager.View.IView;

public class UserAuthenticationController implements IController {

    private IView view;
    private CurrentUser currentUser = CurrentUser.getInstance();
    private ValidateService validateService = new ValidateService();
    private SessionService sessionService;

    public UserAuthenticationController(IView view, Context context) {
        this.view = view;
        sessionService = new SessionService(context);
    }

    public void onLogin(String username, String password, Class activityClass, Context context) {
        if(validateService.validateLogin(username, password)) {

            //TODO: Nicht neu erstellen, sondern nach usernamen suchen.
            currentUser.createUser(username, password);

            sessionService.saveSession(currentUser.retrieveUser());

            loadNewPage(activityClass);
            updateView("Anmeldung erfolgreich, willkommen " + currentUser.retrieveUser().getUsername());
        } else {
            updateView("Anmeldung nicht erfolgreich, probiere es erneut");
        }

    }

    public void ToRegister(Class activityClass) {

        loadNewPage(activityClass);
    }

    public void onRegister(String username, String password, Class activityClass) {
        if(validateService.validateRegister(username, password)) {

            currentUser.createUser(username, password);
            sessionService.saveSession(currentUser.retrieveUser());
            loadNewPage(activityClass);
            updateView("Registrierung erfolgreich, willkommen " + currentUser.retrieveUser().getUsername());
        } else {
            updateView("Registrierung nicht erfolgreich, probiere es erneut");
        }
    }

    public void checkSession() {
        String username = sessionService.getSession();

        if(username != null) {
            //TODO: Nicht neu erstellen, sondern nach usernamen suchen.
            currentUser.createUser(username, "password");
            loadNewPage(MainActivity.class);
        }
    }

    public void updateView(String message) {
        view.showUserDetails(message);
    }

    public void loadNewPage(Class activityClass) {
        view.loadNewActivity(activityClass);
    }


}
