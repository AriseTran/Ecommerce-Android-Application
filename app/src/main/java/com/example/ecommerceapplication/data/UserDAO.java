package com.example.ecommerceapplication.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ecommerceapplication.model.User;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE username = :username AND password = :password AND isAdmin = :isAdmin")
    User getUser(String username, String password, Boolean isAdmin);
}
