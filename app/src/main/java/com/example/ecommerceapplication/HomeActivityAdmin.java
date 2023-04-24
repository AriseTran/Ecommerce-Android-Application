package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerceapplication.model.User;

public class HomeActivityAdmin extends AppCompatActivity {
    TextView tvUser;
    User user;
    Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.tvUser);
        buttonLogout = findViewById(R.id.buttonLogOut);
        if (user != null) {
            tvUser.setText("WELCOME " + user.getUsername());
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivityAdmin.this, MainActivity.class));
            }
        });
    }

}