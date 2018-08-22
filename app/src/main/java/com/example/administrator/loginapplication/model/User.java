package com.example.administrator.loginapplication.model;

/**
 * Created by HL on 2018/4/16.
 */

public class User {
    /***user id */
    private String id;

    /***user name */
    private String userName;

    public User() {
    }

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
