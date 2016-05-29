package com.wild.swimming.australia;

import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity implements HomeFragment.OnFragmentInteractionListener {

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private static final String TAB_4_TAG = "tab_4";
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Custom Action Bar
        //ActionBar mActionBar = getSupportActionBar();
        //mActionBar.setDisplayShowTitleEnabled(false);
        InitView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void InitView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(setIndicator(MainActivity.this, mTabHost.newTabSpec(TAB_1_TAG),
                R.drawable.tab_indicator_gen, "Home", R.drawable.home_icon), Tab1Container.class, null);
        mTabHost.addTab(setIndicator(MainActivity.this, mTabHost.newTabSpec(TAB_2_TAG),
                R.drawable.tab_indicator_gen, "Map", R.drawable.home_icon), Tab2Container.class, null);
        mTabHost.addTab(setIndicator(MainActivity.this, mTabHost.newTabSpec(TAB_3_TAG),
                R.drawable.tab_indicator_gen, "Detail", R.drawable.home_icon), Tab3Container.class, null);
        mTabHost.addTab(setIndicator(MainActivity.this, mTabHost.newTabSpec(TAB_4_TAG),
               R.drawable.tab_indicator_gen, "Comment", R.drawable.home_icon), Tab3Container.class, null);
    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();

        if (currentTabTag.equals(TAB_1_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_1_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_2_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_2_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_3_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_3_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_4_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_4_TAG)).popFragment();
        }

        if (!isPopFragment) {
            finish();
        }
    }

    private TabSpec setIndicator(Context ctx, TabSpec spec,
                                 int resid, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        v.setBackgroundResource(resid);
        TextView tv = (TextView) v.findViewById(R.id.txt_tabtxt);
        ImageView img = (ImageView) v.findViewById(R.id.img_tabtxt);

        tv.setText(string);
        img.setBackgroundResource(genresIcon);
        return spec.setIndicator(v);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
