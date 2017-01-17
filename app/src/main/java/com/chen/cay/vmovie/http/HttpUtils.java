package com.chen.cay.vmovie.http;

import android.content.Context;

/**
 * Created by Cay on 2017/1/18.
 */
public class HttpUtils {
    private static HttpUtils sHttpUtils;
    private Context context;

    public static HttpUtils getInstance() {
        if (sHttpUtils == null) {
            sHttpUtils = new HttpUtils();
        }
        return sHttpUtils;
    }
    public void setContext(Context context) {
        this.context = context;
    }
}
