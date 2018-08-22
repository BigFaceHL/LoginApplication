package com.example.administrator.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.loginapplication.global.Constant;
import com.example.administrator.loginapplication.model.Result;
import com.example.administrator.loginapplication.model.User;
import com.example.administrator.loginapplication.util.HttpUtil;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";
    /***
     * 登录按钮
     */
    private Button btnLogin;
    /**
     * 用户名输入框
     */
    private EditText etUserName;
    /**
     * 密码输入框
     */
    private EditText etPassword;

    private HttpUtil mHttpUtil = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mHttpUtil = HttpUtil.getInstance();
        initView();
    }

    /**
     * 初始化view
     */
    public void initView() {
        //初始化控件
        btnLogin = findViewById(R.id.btnLogin);
        etUserName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);

        //设置点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用登录方法
                login(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
                Result result=new Result("200",new User("001","helan"));
                String json=new GsonBuilder().create().toJson(result,Result.class);
                Log.e("12392",json);


            }
        });


    }

    /**
     * @param userName
     * @param password
     */
    public void login(final String userName, final String password) {
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            //请求网络数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.e("LoginActivity", "跳转");
                    startNewActivity(mHttpUtil.post(Constant.LOGIN, userName, password));
//                    startNewActivity("");

                }
            }).start();

        } else {
            Toast.makeText(LoginActivity.this, "用户名和密码不正确", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 跳转至主页
     * @param data
     */
    public void startNewActivity(String data) {
        Log.e("LoginActivity", "跳转");
       String  data1="{\"code\":\"200\",\"info\":{\"id\":\"001\",\"userName\":\"helan\"}}";
        Result  result=new GsonBuilder().create().fromJson(data1, Result.class);
        User mUser=result.getInfo();
        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("username",mUser.getUserName());
        startActivity(intent);
        finish();
    }


}
