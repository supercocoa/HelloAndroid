package com.helloandroid.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Bind(R.id.tabs) TabLayout tabs;

    @Bind(R.id.pager) ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        pager.setAdapter(mainPageAdapter);
        pager.setOffscreenPageLimit(mainPageAdapter.getCount());

        tabs.setupWithViewPager(pager);

    }


    private class MainPageAdapter extends FragmentStatePagerAdapter {

        MainPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new TypeFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("position", position);

            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return Config.TYPE_LIST.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Config.TYPE_LIST[position].TITLE;
        }
    }
}
