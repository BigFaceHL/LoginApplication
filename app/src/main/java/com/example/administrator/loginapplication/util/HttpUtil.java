package com.example.administrator.loginapplication.util;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.administrator.loginapplication.model.Result;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by HL on 2018/2/23.
 * 网络请求类
 */

public class HttpUtil {
    private static HttpUtil httpUtil = null;

    private String result;

    public HttpUtil() {
    }

    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    /**
     * get请求
     *
     * @param userName
     * @param password
     */
    public void get(String url, String userName, String password) {
        OkHttpClient client = new OkHttpClient();

        //构造Request对象,传入Get的请求地址
        Request request = new Request.Builder().get().url(url).build();
        Call call = client.newCall(request);

        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "请求失败！");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseStr = response.body().string();
            }
        });
    }

    /**
     * post请求
     *
     * @param url
     * @param username
     * @param password
     */
    public String post(String url, String username, String password) {
        OkHttpClient okHttpClient = new OkHttpClient();


        RequestBody body = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "请求失败！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().toString();
            }
        });
        return result;
    }
}
