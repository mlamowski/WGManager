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

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText username, password;
    Button loginButton, registerButton;
    TextView userDetails;
    UserAuthenticationController userAuthenticationController;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameView);
        password = (EditText) findViewById(R.id.passwordView);

        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (Button) findViewById(R.id.button_register);

        userDetails = (TextView) findViewById(R.id.userDetailsView);

        userAuthenticationController = new UserAuthenticationController(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAuthenticationController.onLogin(username.getText().toString(), password.getText().toString(), HomeActivity.class);
                userAuthenticationController.updateView();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userAuthenticationController.ToRegister(RegisterActivity.class);
            }
        });

    }

    @Override
    public void showUserDetails(String message) {
        Toast.makeText(MainActivity.this, "Anmeldung erfolgreich", Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadNewActivity(Class activityClass) {
        //TODO : Ziel Activity übergeben.
        Intent intent = new Intent(this, activityClass);
        String usernameForRegister = username.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, usernameForRegister);
        startActivity(intent);
    }
}