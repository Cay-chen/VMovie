package com.chen.cay.vmovie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chen.cay.vmovie.databinding.ActivityMainBinding;
import com.chen.cay.vmovie.util.CommonUtils;
import com.chen.cay.vmovie.util.ImgLoadUtil;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private NavigationView mNavigationView;
    private ActivityMainBinding mainBinding;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // mainBinding.setAppTitle("haha");
        initViews();
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this, drawerLayout, CommonUtils.getColor(R.color.colorTheme));

        initDrawerLayout();//Nav布局
        initListener();
    }

    private void initViews() {
        mNavigationView = mainBinding.navView;
        llTitleMenu = mainBinding.include.llTitleMenu;
        drawerLayout = mainBinding.drawerLayout;
    }

    private void initListener() {
        llTitleMenu.setOnClickListener(this);

    }

    /**
     * inflateHeaderView 进来的布局要宽一些
     */
    private void initDrawerLayout() {
        mNavigationView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = mNavigationView.getHeaderView(0);
//        LinearLayout viewById1 = (LinearLayout) headerView.findViewById(R.id.ll_header_bg);
//        viewById1.setBackground();
        ImageView ivAvatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
        ImgLoadUtil.displayCircle(ivAvatar, R.drawable.ic_avatar);
        LinearLayout llNavHomepage = (LinearLayout) headerView.findViewById(R.id.ll_nav_homepage);
        LinearLayout llNavScanDownload = (LinearLayout) headerView.findViewById(R.id.ll_nav_scan_download);
        LinearLayout llNavDeedback = (LinearLayout) headerView.findViewById(R.id.ll_nav_deedback);
        LinearLayout llNavAbout = (LinearLayout) headerView.findViewById(R.id.ll_nav_about);
        llNavHomepage.setOnClickListener(this);
        llNavScanDownload.setOnClickListener(this);
        llNavDeedback.setOnClickListener(this);
        llNavAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title_menu:
                // 开启菜单
                drawerLayout.openDrawer(GravityCompat.START);
                // 关闭
                //drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
