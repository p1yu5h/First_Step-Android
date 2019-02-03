package com.firststep.www.firststep;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;
    //Tab3 tab3 = new Tab3();
    Tab2 tab2 = new Tab2();
    Tab1 tab1 = new Tab1();
    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return tab1;
            case 1:
                return  tab2;
            //case 2:
               // return  tab3;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNoOfTabs;
    }

    public Tab1 getTab1() {
        return tab1;
    }

    public Tab2 getTab2() {
        return tab2;
    }

}