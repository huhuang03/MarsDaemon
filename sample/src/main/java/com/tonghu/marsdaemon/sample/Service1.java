package com.tonghu.marsdaemon.sample;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Service1 extends Service {
    private static final String PROCESS_NAME = "com.tonghu.marsdaemon.sample";
    private Handler mHandler = new Handler();
    public Service1() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!checkRunning()) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Service1.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
                }
            }
        }, 0, 3 * 1000);
    }

    private boolean checkRunning() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();

        //利用一个增强for循环取出手机里的所有进程
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            //通过比较进程的唯一标识和包名判断进程里是否存在该App
            if (PROCESS_NAME.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
