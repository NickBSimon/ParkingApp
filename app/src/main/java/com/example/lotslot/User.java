package com.example.lotslot;

public class User {

    public String email, username, password;

    int occupying;

    public User(){


    }

    public User(String email, String username, String password){
        this.email = email;
        this.password = password;
        this.username = username;
        occupying = -1;
    }
}
