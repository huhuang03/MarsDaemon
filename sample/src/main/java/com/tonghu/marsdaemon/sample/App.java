package com.tonghu.marsdaemon.sample;

import android.content.Context;
import android.util.Log;

import com.tonghu.marsdaemon.DaemonApplication;
import com.tonghu.marsdaemon.DaemonConfigurations;

/**
 * create by th on 20/7/2018
 */
public class App extends DaemonApplication {

    @Override
    protected DaemonConfigurations getDaemonConfigurations() {
        DaemonConfigurations.DaemonConfiguration configuration1 = new DaemonConfigurations.DaemonConfiguration("com.marswin89.marsdaemon.demo:process1", Service1.class.getCanonicalName(), Receiver1.class.getCanonicalName());
        DaemonConfigurations.DaemonConfiguration configuration2 = new DaemonConfigurations.DaemonConfiguration("com.marswin89.marsdaemon.demo:process2", Service2.class.getCanonicalName(), Receiver2.class.getCanonicalName());
        DaemonConfigurations.DaemonListener listener = new DaemonConfigurations.DaemonListener() {
            @Override
            public void onPersistentStart(Context context) {
                Log.i("tonghu", "onPersistentStart");
            }

            @Override
            public void onDaemonAssistantStart(Context context) {
                Log.i("tonghu", "onDaemonAssistantStart");
            }

            @Override
            public void onWatchDaemonDaed() {
                Log.i("tonghu", "onWatchDaemonDaed");
            }
        };
        //return new DaemonConfigurations(configuration1, configuration2);//listener can be null
        return new DaemonConfigurations(configuration1, configuration2, listener);
    }

}
