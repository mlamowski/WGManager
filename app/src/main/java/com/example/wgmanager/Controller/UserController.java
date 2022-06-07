package com.example.wgmanager.Controller;

import android.content.Context;
import android.widget.Toast;

import com.example.wgmanager.Model.CurrentUser;
import com.example.wgmanager.View.IView;
import com.example.wgmanager.View.LoginActivity;
import com.example.wgmanager.View.MainActivity;

public class UserController implements IController {

    //Giuliano

    IView View;

    //CurrentUser hält alle Daten zur Laufzeit
    private CurrentUser currentUser;

    SessionService sessionService;


    public UserController(IView view, Context context) {
        this.View = view;
        sessionService = new SessionService(context);
        currentUser = CurrentUser.getInstance();


    }

    //Hier wird eine Instanz von CurrentUser erzeugt. Die Instanz ist überall gleich!
    public String getCurrentUserName() {
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

    public void checkPasswordOnChange(String toString, String toString1, String toString2) {

        if(toString.equals(toString1)) {

            if(toString.equals(currentUser.retrieveUser().getPassword())) {
                currentUser.updatePassword(toString2);
                loadNewPage(MainActivity.class);
                View.showUserDetails("PW wurde geändert, neues PW ist " + currentUser.retrieveUser().getPassword());

                return;
            }

        }
        View.showUserDetails("Hat nicht funktioniert");

    }

    public void checkUsernameOnChange(String toString) {
        currentUser.updateUsername(toString);
        loadNewPage(MainActivity.class);
        View.showUserDetails("Username wurde geändert, neuer Username ist " + currentUser.retrieveUser().getUsername());

        return;
    }
}
