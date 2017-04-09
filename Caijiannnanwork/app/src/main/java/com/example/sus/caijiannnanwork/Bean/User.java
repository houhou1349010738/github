package com.example.sus.caijiannnanwork.Bean;

/**
 * Created by sus on 2017/4/9.
 */

public class User {
    private int id;
    private int image;

    public User(int image, String name) {
        this.image = image;
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
