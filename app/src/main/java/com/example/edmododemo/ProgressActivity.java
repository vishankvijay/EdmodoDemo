package com.example.edmododemo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {

    private Toolbar toolbar_progress;
    private Context context;
    private ViewPager viewPager_progress;
    private TabLayout tabLayout_progress;
    private ArrayList<Fragment> list_progress;
    String[] tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        instantiate();
        ViewAdapter adapter = new ViewAdapter(getSupportFragmentManager());
        viewPager_progress.setAdapter(adapter);
        tabLayout_progress.setTabsFromPagerAdapter(adapter);

        tabLayout_progress.setupWithViewPager(viewPager_progress);
        viewPager_progress.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_progress));

    }



    private void instantiate() {
        toolbar_progress = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_progress);
        getSupportActionBar().setTitle("Progress");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = ProgressActivity.this;
        viewPager_progress = (ViewPager) findViewById(R.id.view_pager_progress);
        tabLayout_progress = (TabLayout) findViewById(R.id.tab_layout_progress);

        list_progress = new ArrayList<>();
        list_progress.add(new Communities_Following_Fragment());
        list_progress.add(new Communities_Discover_Fragment());

        tabName = getResources().getStringArray(R.array.progress_tabs);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.progress_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.progress_notification:
                startActivity(new Intent(ProgressActivity.this , NotificationActivity.class));


                break;

        }


        return super.onOptionsItemSelected(item);
    }


    class ViewAdapter extends FragmentStatePagerAdapter {
        public ViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_progress.get(position);
        }

        @Override
        public int getCount() {
            return list_progress.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabName[position];
        }
    }
}
