package com.diemthithu.doctruyen.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter  extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList =new ArrayList<>();
    private List<String> titleList =new ArrayList<>();
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }
    public void add(Fragment fragment, String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    //tra ve vi tri cu title
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
