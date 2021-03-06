package com.chen.cay.vmovie.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.chen.cay.vmovie.R;
import com.chen.cay.vmovie.base.BaseActivity;
import com.chen.cay.vmovie.databinding.ActivityNavAboutBinding;
import com.chen.cay.vmovie.util.PerfectClickListener;
import com.chen.cay.vmovie.view.webviwe.WebViewActivity;

public class NavAboutActivity extends BaseActivity<ActivityNavAboutBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_about);
        showContentView();
        setTitle("关于云阅");


        // 直接写在布局文件里会很耗内存
        Glide.with(this).load(R.drawable.ic_cloudreader).into(bindingView.ivIcon);
        bindingView.tvGankio.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        bindingView.tvGankio.getPaint().setAntiAlias(true);//抗锯齿
        bindingView.tvDouban.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        bindingView.tvDouban.getPaint().setAntiAlias(true);//抗锯齿

        initListener();
    }

    private void initListener() {
        bindingView.tvGankio.setOnClickListener(listener);
        bindingView.tvDouban.setOnClickListener(listener);
//        bindingView.tvAboutStar.setOnClickListener(listener);
        bindingView.tvAboutStar.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Uri issuesUrl = Uri.parse("https://github.com/youlookwhat/CloudReader");
                Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
                startActivity(intent);
            }
        });
        bindingView.tvFunction.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Uri issuesUrl = Uri.parse("http://cay.me/2016/12/30/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97-%E4%BA%91%E9%98%85/");
                Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
                startActivity(intent);
            }
        });

//        bindingView.tvFunction.setOnClickListener(listener);
        bindingView.tvNewVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtil.showToast("已是最新版本~");
                Uri issuesUrl = Uri.parse("https://fir.im/friendvideo");
                Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
                startActivity(intent);
            }
        });
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            String url = null;
            switch (v.getId()) {
                case R.id.tv_gankio:
                    url = "http://gank.io/api";
                    break;
                case R.id.tv_douban:
                    url = "https://developers.douban.com/wiki/?title=terms";
                    break;
                case R.id.tv_about_star:
                    url = "https://github.com/youlookwhat/CloudReader";
                    break;
                case R.id.tv_function:// 更新日志
                    url = "http://cay.me/2016/12/30/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97-%E4%BA%91%E9%98%85/";
                    break;
            }
            WebViewActivity.loadUrl(v.getContext(), url, "加载中...");
        }
    };

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, NavAboutActivity.class);
        mContext.startActivity(intent);
    }
}
