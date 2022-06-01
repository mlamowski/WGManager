package com.example.wgmanager.Controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wgmanager.Model.User;

public class SessionService {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String SHARED_PREF_NAME = "shared_prefs";
    String NAME_KEY = "name_key";


    public SessionService(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        editor.putString(NAME_KEY, user.getUsername()).commit();
    }

    public String getSession() {
        return sharedPreferences.getString(NAME_KEY, null);
        //return sharedPreferences.getInt(SESSION_KEY, -1);
    }

    public void removeSession() {
        editor.clear();
        editor.apply();
    }

}
