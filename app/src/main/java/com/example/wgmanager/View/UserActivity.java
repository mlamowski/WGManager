package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.R;

public class UserActivity extends AppCompatActivity implements IView {

    TextView userName_testview;

    //HomeActivity hat Controller
    UserController userController;

    Button button_changePassword;
    Button button_changeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userName_testview = (TextView) findViewById(R.id.textView2);

        button_changePassword = (Button) findViewById(R.id.button_changepw);
        button_changeName = (Button) findViewById(R.id.button_changename);

        //Controller wird erstellt
        userController = new UserController(this, this);

        userName_testview.setText("Möchtest du dein Passwort oder Username ändern? ");

        button_changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.loadNewPage(ChangePasswordActivity.class);
            }
        });

        button_changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.loadNewPage(ChangeUsernameActivity.class);
            }
        });

    }

    @Override
    public void showUserDetails(String message) {

    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}