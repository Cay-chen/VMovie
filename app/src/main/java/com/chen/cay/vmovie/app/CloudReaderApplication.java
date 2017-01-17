package com.chen.cay.vmovie.app;

import android.app.Application;

import com.chen.cay.vmovie.http.HttpUtils;


/**
 * Created by cay on 2016/11/22.
 */

public class CloudReaderApplication extends Application {

    private static CloudReaderApplication cloudReaderApplication;

    public static CloudReaderApplication getInstance() {
        // if语句下是不会走的，Application本身已单例
        if (cloudReaderApplication == null) {
            synchronized (CloudReaderApplication.class) {
                if (cloudReaderApplication == null) {
                    cloudReaderApplication = new CloudReaderApplication();
                }
            }
        }
        return cloudReaderApplication;
    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        cloudReaderApplication = this;
        HttpUtils.getInstance().setContext(getApplicationContext());
    }
}
