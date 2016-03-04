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

public class GroupsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Context context;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> list;
    String[] tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        instantiate();
        ViewAdapter adapter = new ViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setTabsFromPagerAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }



    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Groups");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = GroupsActivity.this;
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        list = new ArrayList<>();
        list.add(new GroupFragment());
        list.add(new FragmentGroupsJoined());
        list.add(new GroupFragment());

        tabName = getResources().getStringArray(R.array.group_tabs);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.groups_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.group_notification:
                startActivity(new Intent(GroupsActivity.this , NotificationActivity.class));

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
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabName[position];
        }
    }
}
