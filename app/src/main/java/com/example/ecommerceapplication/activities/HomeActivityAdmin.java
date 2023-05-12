package com.example.ecommerceapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.model.User;

public class HomeActivityAdmin extends AppCompatActivity {
    User user;
    TextView textviewUser;
    Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        user = (User) getIntent().getSerializableExtra("User");
        textviewUser = findViewById(R.id.tvUser);
        buttonLogout = findViewById(R.id.buttonLogOut);
        if (user != null) {
            textviewUser.setText("WELCOME " + user.getUsername());
        }

        buttonLogout.setOnClickListener(view -> startActivity(new Intent(HomeActivityAdmin.this, MainActivity.class)));
    }

}