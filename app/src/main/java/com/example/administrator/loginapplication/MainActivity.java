package com.example.administrator.loginapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.loginapplication.listener.MyOnClickListener;
import com.example.administrator.loginapplication.receiver.MyReceiver;

public class MainActivity extends AppCompatActivity {
    private MyReceiver mBroadcastReceiver;
    private Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        stopBtn.setOnClickListener(new MyOnClickListener());


    }
    //定义一个内部类,实现View.OnClickListener接口,并重写onClick()方法
    class  BtnClickListener  implements  View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            // do something
        }
    }
    //自定义一个方法,传入一个view组件作为参数
    public void myclick (View source)
    {
        Toast.makeText(getApplicationContext(), "按钮被点击了", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        // 1. 实例化BroadcastReceiver子类 &  IntentFilter
        mBroadcastReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();

        // 2. 设置接收广播的类型
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        // 3. 动态注册：调用Context的registerReceiver（）方法
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }
}
