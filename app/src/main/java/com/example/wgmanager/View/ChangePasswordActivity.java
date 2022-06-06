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

public class ChangePasswordActivity extends AppCompatActivity implements IView {

    EditText oldPw1, oldPw2, newPassword;
    UserController userController;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldPw1 = (EditText) findViewById(R.id.editTextTextPassword);
        oldPw2 = (EditText) findViewById(R.id.editTextTextPassword2);
        newPassword = (EditText) findViewById(R.id.editTextTextPassword3);
        button2 = (Button) findViewById(R.id.button2);

        userController = new UserController(this, this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userController.checkPasswordOnChange(oldPw1.getText().toString(), oldPw2.getText().toString(), newPassword.getText().toString());

            }
        });


    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(ChangePasswordActivity.this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}