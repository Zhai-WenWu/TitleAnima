package com.example.xiangha.firstrunning;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabAdapter tabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Fl(this));
        setTab();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "menu", Toast.LENGTH_SHORT).show();
            }
        });

        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
//        collapsing_toolbar.setExpandedTitleColor(R.color.design_default_color_primary_dark);//设置还没收缩时状态下字体颜色
//        collapsing_toolbar.setCollapsedTitleTextColor(R.color.design_default_color_primary_dark );//设置收缩后Toolbar上字体的颜色
//        initView();
//        initTab();
    }

    private void setTab() {
        final Toolbar toolbar = findViewById(R.id.toolbar);

        final LinearLayout tablayout = findViewById(R.id.tablayout);
        final TextView text_jianjie = findViewById(R.id.text_jianjie);
        final TextView text_zhangjie = findViewById(R.id.text_zhangjie);
        final TextView tab_jianjie = findViewById(R.id.tab_jianjie);
        final TextView tab_kecheng = findViewById(R.id.tab_kecheng);
        final View top_item = findViewById(R.id.top_item);
        final NestedScrollView scroll_view = findViewById(R.id.scroll_view);


        final int[] location1 = new int[2];
        final int[] location2 = new int[2];

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            scroll_view.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View view, int j, int i1, int i2, int i3) {
//                    text_jianjie.getLocationOnScreen(location1);
//                    tablayout.getLocationOnScreen(location2);
//                    if (location1[1] <= location2[1] + tablayout.getHeight()) {
//                        tablayout.setVisibility(View.VISIBLE);
//                    } else {
//                        tablayout.setVisibility(View.GONE);
//                    }
//
//                }
//            });
        }

        tab_jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll_view.smoothScrollTo(0, top_item.getHeight() - tablayout.getHeight());
            }
        });

        tab_kecheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll_view.smoothScrollTo(0, top_item.getHeight() + text_jianjie.getHeight() - tablayout.getHeight());
            }
        });

    }

//    private void initView() {
//        mTabLayout = (TabLayout) findViewById(R.id.tabs);
//        mViewPager = findViewById(R.id.view_page);
//    }
//
//    private void initTab() {
//        tabAdapter = new TabAdapter(getSupportFragmentManager());
//        ItemFragment goodsRecycleFragment = new ItemFragment();
//        tabAdapter.addFragment(goodsRecycleFragment, "视频");
//        goodsRecycleFragment = new ItemFragment();
//        tabAdapter.addFragment(goodsRecycleFragment, "美食");
//
//        mViewPager.setAdapter(tabAdapter);
//        mTabLayout.setupWithViewPager(mViewPager);
//    }
}
