package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.R;

public class NoGroupActivity extends AppCompatActivity implements IView {

    public TextView nogroupText;
    EditText groupNameChange;
    Button button4;
    UserController userController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_group);

        userController = new UserController(this, this);
        button4 = (Button) findViewById(R.id.button4);
        groupNameChange = (EditText) findViewById(R.id.groupNameChange);
        nogroupText = (TextView) findViewById(R.id.textView3);
        nogroupText.setText("Du hast noch keine Gruppe");

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.createGroup(groupNameChange.getText().toString());
            }
        });
    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(NoGroupActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}