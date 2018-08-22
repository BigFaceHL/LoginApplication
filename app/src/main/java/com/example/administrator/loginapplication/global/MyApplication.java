package com.example.administrator.loginapplication.global;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.loginapplication.model.User;

/**
 * Created by HL on 2018/4/16.
 */

public class MyApplication extends Application {

    public User mUser = null;


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void updateLoginParams(boolean userPasswordRemember, User user) {
        mUser = user;
        if (userPasswordRemember) {

        } else {

        }
    }


}
