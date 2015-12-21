package com.gs.android.materialsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class MainActivity extends AppCompatActivity {

    @Bind(R.id.tool_bar)
    protected Toolbar mAppBar;

    @Bind(R.id.tab_bar)
    protected TabLayout mTabBar;

    @Bind(R.id.pager)
    protected ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mAppBar);

        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        mTabBar.setupWithViewPager(mPager);
    }
}
