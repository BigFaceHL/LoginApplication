package com.example.administrator.loginapplication.model;

/**
 * Created by HL on 2018/4/16.
 */

public class Result {
    private String code;

    private User info;

    public Result(String code, User info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getInfo() {
        return info;
    }

    public void setInfo(User info) {
        this.info = info;
    }
}
