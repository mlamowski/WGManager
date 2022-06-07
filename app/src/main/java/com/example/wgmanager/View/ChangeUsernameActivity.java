package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.R;

public class ChangeUsernameActivity extends AppCompatActivity implements IView {

    EditText changeName;
    UserController userController;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_username);

        changeName = (EditText) findViewById(R.id.changeUserName);
        button3 = (Button) findViewById(R.id.button3);

        userController = new UserController(this, this);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.checkUsernameOnChange(changeName.getText().toString());
            }
        });
    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(ChangeUsernameActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}