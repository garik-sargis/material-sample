package com.gs.android.materialsample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class MainActivity extends AppCompatActivity {

    @Bind(R.id.tool_bar)
    protected Toolbar mToolbar;

    @Bind(R.id.tab_bar)
    protected TabLayout mTabBar;

    @Bind(R.id.pager)
    protected ViewPager mPager;

    @Bind(R.id.nav_drawer)
    protected DrawerLayout mNavDrawer;

    @Bind(R.id.nav_view)
    protected NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        mTabBar.setupWithViewPager(mPager);

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);

                switch (item.getItemId()) {
                    case R.id.group:
                        break;
                    case R.id.plane:
                        break;
                }

                return true;
            }
        });

        // TODO: Replace string resources
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mNavDrawer, mToolbar, R.string.app_name, R.string.app_name) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mNavDrawer.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }
}
