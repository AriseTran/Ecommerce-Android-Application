package com.example.ecommerceapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.model.User;

public class HomeActivity extends AppCompatActivity {
    TextView tvUser;
    Button buttonLogout;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.tvUser);
        buttonLogout = findViewById(R.id.buttonLogOut);

        if (user != null) {
            tvUser.setText("Hi " + user.getUsername());
        }

        buttonLogout.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, MainActivity.class)));
    }
}