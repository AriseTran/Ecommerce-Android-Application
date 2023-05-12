package com.example.ecommerceapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.data.DataDao;
import com.example.ecommerceapplication.data.UserDatabase;
import com.example.ecommerceapplication.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.ecommerceapplication.userIdKey";
    private static final String PREFERENCES_KEY = "com.example.ecommerceapplication.PRESENCES_KEY";
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;

    DataDao db;
    UserDatabase database;

    private int userId = -1;
    private SharedPreferences preferences = null;
    private User user;

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

        checkForUser();

        textViewRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterActivity.class)));

        buttonLogin.setOnClickListener(v -> {
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
        });
    }

    private void checkForUser() {
        List<User> users = db.getAllUsers();
        if(users.size() == 0){
            User defaultUser1 = new User("testuser1", "testuser1", false);
            User defaultUser2 = new User("admin2", "admin2", true);
            db.insert(defaultUser1);
            db.insert(defaultUser2);
        }
    }
}