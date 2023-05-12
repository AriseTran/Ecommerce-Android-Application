package com.example.ecommerceapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.data.DataDao;
import com.example.ecommerceapplication.data.UserDatabase;
import com.example.ecommerceapplication.model.User;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;

    private DataDao dataDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this, MainActivity.class)));

        dataDao = Room.databaseBuilder(this, UserDatabase.class, "User").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(v -> {
            String userName = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String passwordConf = editTextCnfPassword.getText().toString().trim();
            Boolean isAdmin = userName.startsWith("admin");

            if (!password.isEmpty() && !passwordConf.isEmpty() && password.equals(passwordConf) && !userName.isEmpty()) {
                User user = new User(userName,password,isAdmin);
                dataDao.insert(user);
                Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(moveToLogin);

            } else {
                Toast.makeText(RegisterActivity.this, "Username not valid or Password is not matching", Toast.LENGTH_SHORT).show();
            }
        });
    }
}