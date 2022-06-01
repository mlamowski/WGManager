package com.example.wgmanager.Controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wgmanager.Model.User;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String SHARED_PREF_NAME = "session";
    public static final String SESSION_NAME = "session_user";

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        String userName = user.getUsername();

        editor.putString(SESSION_NAME, userName);

        editor.apply();
    }

    public String getSession() {
        return SESSION_NAME;
    }

}
