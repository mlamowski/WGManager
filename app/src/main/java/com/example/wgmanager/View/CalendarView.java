package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wgmanager.Controller.EventController;
import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.R;


public class CalendarView extends AppCompatActivity implements IView {

    //Charly

    EventController eventController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        //Controller wird erstellt
        eventController = new EventController(this);

        //Beispielfunktion von Controller wird aufgerufen
        eventController.updateView();
    }

    @Override
    public void showUserDetails(String message) {

    }

    @Override
    public void loadNewActivity(Class activityClass) {

    }
}