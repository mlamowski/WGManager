package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wgmanager.Controller.UserAuthenticationController;
import com.example.wgmanager.R;

public class LoginActivity extends AppCompatActivity implements IView {

    //Branch A --> Branch B ==> Checkout Branch B + Branch A anklicken "Merge into Current" ==> Commit & Pushen

    EditText username, password;
    Button loginButton, registerButton;
    UserAuthenticationController userAuthenticationController;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onStart() {
        super.onStart();

        userAuthenticationController.checkSession();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.usernameView);
        password = (EditText) findViewById(R.id.passwordView);

        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (Button) findViewById(R.id.button_register);

        userAuthenticationController = new UserAuthenticationController(this, this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userAuthenticationController.onLogin(username.getText().toString(), password.getText().toString(), MainActivity.class, LoginActivity.this);
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
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();

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