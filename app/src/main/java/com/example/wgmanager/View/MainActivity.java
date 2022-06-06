package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.R;


public class MainActivity extends AppCompatActivity implements IView{
    //Giuliano

    Button button;
    Button logout_button;
    Button userPage;
    Button groupPage;

    TextView userName_view;

    //HomeActivity hat Controller
    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName_view = (TextView) findViewById(R.id.username_textview);

        //BUTTONS
        button = (Button) findViewById(R.id.button);
        userPage = (Button) findViewById(R.id.button_user);
        groupPage = (Button) findViewById(R.id.button_grroup);
        logout_button = (Button) findViewById(R.id.logout_btn);

        //Controller wird erstellt
        userController = new UserController(this, this);

        userName_view.setText(userController.getCurrentUserName());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.loadNewPage(CalendarView.class);

                //Beispielfunktion von Controller wird aufgerufen
                //userController.updateView();
            }
        });

        userPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.loadNewPage(UserActivity.class);
            }
        });

        groupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.loadNewPage(GroupActivity.class);
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userController.logout();
            }
        });

    }

    //Funktion, die von Controller aufgerufen werden soll, um View upzudaten
    @Override
    public void showUserDetails(String user) {
        Toast.makeText(MainActivity.this, userController.getCurrentUserName(), Toast.LENGTH_LONG).show();
    }

    //Funktion, die von Controller aufgerufen werden soll, um neue Seite zu laden
    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}