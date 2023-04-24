package com.example.ecommerceapplication.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ecommerceapplication.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO getUserDao();
}
