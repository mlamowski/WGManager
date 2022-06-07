package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserController;
import com.example.wgmanager.Model.Group;
import com.example.wgmanager.Model.User;
import com.example.wgmanager.R;

public class GroupActivity extends AppCompatActivity implements IView{

    public TextView groupText;
    public TextView groupMember;
    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        userController = new UserController(this, this);

        groupMember = (TextView) findViewById(R.id.textView6);
        groupText = (TextView) findViewById(R.id.groupText);
        groupText.setText("Der name deiner Gruppe lautet: \n" + userController.getGroupName());
        groupMember.setText("In deiner Gruppe befindet sich: \n" + userController.getGroupMember());


    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(GroupActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}