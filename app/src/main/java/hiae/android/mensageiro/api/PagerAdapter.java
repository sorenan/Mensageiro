package hiae.android.mensageiro.api;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hiae.android.mensageiro.controller.Tab1_Fragment;
import hiae.android.mensageiro.controller.Tab2_Fragment;
import hiae.android.mensageiro.controller.Tab3_Fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);

        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab1_Fragment tab1 = new Tab1_Fragment();
                return tab1;
            case 1:
                Tab2_Fragment tab2 = new Tab2_Fragment();
                return tab2;
            case 2:
                Tab3_Fragment tab3 = new Tab3_Fragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}