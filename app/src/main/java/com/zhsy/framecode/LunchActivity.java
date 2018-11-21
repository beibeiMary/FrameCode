package com.zhsy.framecode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lunch);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //在主线程启动handler在主线程执行
                startMainActivity();
            }
        },2000);
    }

    /**
     * 启动主页面
     */
    private void startMainActivity() {
        Intent intent = new Intent(LunchActivity.this,MainActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }
}
