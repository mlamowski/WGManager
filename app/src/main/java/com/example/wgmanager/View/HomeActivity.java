package com.example.wgmanager.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.wgmanager.R;


public class HomeActivity extends AppCompatActivity implements IHomeview{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}