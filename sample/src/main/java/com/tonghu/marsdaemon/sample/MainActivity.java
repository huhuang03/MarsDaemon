package com.tonghu.marsdaemon.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, Service1.class));
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                throw new RuntimeException("aa");
//            }
//        }, 3000);
    }
}
