package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserAuthenticationController;
import com.example.wgmanager.R;


public class RegisterActivity extends AppCompatActivity implements IView {

    EditText username, password;
    Button registerButton;

    UserAuthenticationController userAuthenticationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userAuthenticationController = new UserAuthenticationController(this, this);

        username = (EditText) findViewById(R.id.usernameViewReg);
        password = (EditText) findViewById(R.id.passwordViewReg);

        registerButton = (Button) findViewById(R.id.button_register_reg);

        Intent intent = getIntent();
        String usernameString = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);

        username.setText(usernameString, TextView.BufferType.EDITABLE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAuthenticationController.onRegister(username.getText().toString(), password.getText().toString(), MainActivity.class);
                //userAuthenticationController.updateView();

            }
        });

    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}