package com.gs.android.materialsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SamplePagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;

    public SamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PageFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.format("Title %d", position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
