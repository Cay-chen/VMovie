package com.chen.cay.vmovie.util;

import android.content.res.Resources;

import com.chen.cay.vmovie.app.CloudReaderApplication;

/**
 * Created by Cay on 2017/1/18.
 */
public class CommonUtils {
    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }
    public static Resources getResoure() {
        return CloudReaderApplication.getInstance().getResources();
    }
}
