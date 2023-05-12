package com.example.ecommerceapplication.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ecommerceapplication.model.Products;
import com.example.ecommerceapplication.model.User;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void insert(User... user);

    @Update
    void update(User...user);

    @Delete
    void delete(User...user);

    @Insert
    void insertAll(User... user);

    @Query("SELECT * FROM " + UserDatabase.USER_TABLE + " WHERE username = :username AND password = :password AND isAdmin = :isAdmin")
    User getUser(String username, String password, Boolean isAdmin);

    @Query("SELECT * FROM " + UserDatabase.USER_TABLE + " WHERE id = :userId")
    User getUserByUserId(int userId);

    @Query("SELECT * FROM " +  UserDatabase.USER_TABLE)
    List<User> getAllUsers();

//    @Insert
//    void insert(Products... products);
//
//    @Update
//    void update(Products... products);
//
//    @Delete
//    void delete(Products...products);

//    @Query("SELECT * FROM " + UserDatabase.PRODUCT_TABLE + " WHERE pId = :pId")
//    Products getProduct(int pId);

}
