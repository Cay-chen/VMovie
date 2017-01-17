package com.chen.cay.vmovie.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Cay on 2017/1/18.
 */
public class ImgLoadUtil {
    /**
     * 加载圆角图
     */
    public static void displayCircle(ImageView imageView, int imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }
}
