package com.example.ecommerceapplication.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PRODUCT_TABLE")
public class Products {
    @PrimaryKey(autoGenerate = true)
     int pId;
    private String pname;
    private String description;
    private String category;
    private String price;
    private String image;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pid=" + pId +
                ", pname='" + pname + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
