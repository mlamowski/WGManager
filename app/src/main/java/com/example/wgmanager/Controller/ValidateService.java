package com.example.wgmanager.Controller;

public class ValidateService {


    //Fürs erste simple Abfrage, später muss mit Datenbank abgeglichen werden
    public boolean validateLogin(String username, String password) {


        if(username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validateRegister(String username, String password) {


        if(username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }



}
