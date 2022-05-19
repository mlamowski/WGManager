package com.example.wgmanager.Controller;

import com.example.wgmanager.Model.User;
import com.example.wgmanager.View.ICalendarView;
import com.example.wgmanager.View.IHomeview;

public class EventController {

    //Charly

    private User user;
    private ICalendarView calView;

    //User Daten werden noch nicht automatisch hinzugefügt. Du musst erstmal mit Dummy Daten arbeiten, ich mach das noch.

    public EventController(ICalendarView calView) {
        this.calView = calView;
    }

    //Greift auf Funktion von View zu.
    public void loadNewPage(Class activityClass) {
        calView.loadNewActivity(activityClass);
    }

    //Greift auf Funktion von View zu.

    public void updateView() {

    }
}
