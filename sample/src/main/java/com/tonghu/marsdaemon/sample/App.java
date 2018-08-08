package com.tonghu.marsdaemon.sample;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

/**
 * create by th on 20/7/2018
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.i("tonghu", "thread " + t + ", has an error: " + Log.getStackTraceString(e));
                Toast.makeText(App.this, "发生异常了，系统将在2秒后重启", Toast.LENGTH_SHORT).show();
                Process.killProcess(Process.myPid());
            }
        });
    }

}
