package com.jparrack.catchat.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.jparrack.catchat.fragment.ChatFragment;
import com.jparrack.catchat.fragment.EmptyFragment;
import com.jparrack.catchat.fragment.StoriesFragment;

/**
 * Created by jparrack on 3/3/17
 */

public class MainViewAdapter extends FragmentStatePagerAdapter {

    public MainViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return ChatFragment.create();
            case 1:
                return EmptyFragment.create();
            case 2:
                return StoriesFragment.create();
        };

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
