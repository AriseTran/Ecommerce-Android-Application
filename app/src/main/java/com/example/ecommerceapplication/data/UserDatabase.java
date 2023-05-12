package com.example.ecommerceapplication.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ecommerceapplication.model.User;



@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "User.db";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String PRODUCT_TABLE = "PRODUCT_TABLE";

    private static volatile UserDatabase instance;
    private static final Object LOCK = new Object();
    public abstract DataDao getUserDao();
    public synchronized static UserDatabase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME).build();
                }
            }

        }
        return instance;
    }
}
