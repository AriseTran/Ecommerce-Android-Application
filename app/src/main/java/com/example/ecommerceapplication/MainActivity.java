package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapplication.data.UserDAO;
import com.example.ecommerceapplication.data.UserDatabase;
import com.example.ecommerceapplication.model.User;

public class MainActivity extends AppCompatActivity {
    UserDAO db;
    UserDatabase database;
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        database = Room.databaseBuilder(this,UserDatabase.class, "User")
                .allowMainThreadQueries().build();
        db = database.getUserDao();

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                Boolean isAdmin = username.startsWith("admin");

                User user = db.getUser(username, password, isAdmin);
                if (user != null) {
                    if(!user.getAdmin()){
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        i.putExtra("User", user);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, HomeActivityAdmin.class);
                        i.putExtra("User", user);
                        startActivity(i);
                        finish();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}