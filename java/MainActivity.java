package com.ivangretic.swiping_quotes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.pager);
/** set the adapter for ViewPager */
        mViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager()));
    }

    public void myface(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ivan.gretic"));
        startActivity(browserIntent);
    }

    public void hugs(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://discussions.udacity.com/t/need-a-hug-make-your-own-card/211329"));
        startActivity(browserIntent);
    }


    /** Defining a FragmentPagerAdapter class for controlling the fragments to be shown when user swipes on the screen. */
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {
                return new intro();
            } else if (position == 1) {
                return new SampleFragment();
            } else if (position == 2) {
                return new SampleFragmentTwo();
            } else if (position == 3) {
                return new SampleFragmentThree();
            } else if (position == 4){
                return new SampleFragmentFour();
            }
            else return new SampleFragmentFive();
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }

    }

}
