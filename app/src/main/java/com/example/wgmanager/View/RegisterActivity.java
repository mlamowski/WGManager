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


public class RegisterActivity extends AppCompatActivity implements ILoginView{

    EditText username, password;
    Button registerButton;

    UserAuthenticationController userAuthenticationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userAuthenticationController = new UserAuthenticationController(this);

        username = (EditText) findViewById(R.id.usernameViewReg);
        password = (EditText) findViewById(R.id.passwordViewReg);

        registerButton = (Button) findViewById(R.id.button_register_reg);

        Intent intent = getIntent();
        String usernameString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        username.setText(usernameString, TextView.BufferType.EDITABLE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAuthenticationController.onRegister(username.getText().toString(), password.getText().toString());
                userAuthenticationController.updateView();
                //TODO Controller aufrufen für Seitenwechsel

            }
        });

    }

    @Override
    public void showUserDetails(String user) {
        Toast.makeText(RegisterActivity.this, user, Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadNewActivity() {
        //TODO zur Startseite
    }
}