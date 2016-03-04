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

public class communitiesActivity extends AppCompatActivity {

    private Toolbar toolbar_communities;
    private Context context;
    private ViewPager viewPager_communities;
    private TabLayout tabLayout_communities;
    private ArrayList<Fragment> list_communities;
    String[] tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communities);
        instantiate();
        ViewAdapter adapter = new ViewAdapter(getSupportFragmentManager());
        viewPager_communities.setAdapter(adapter);
        tabLayout_communities.setTabsFromPagerAdapter(adapter);

        tabLayout_communities.setupWithViewPager(viewPager_communities);
        viewPager_communities.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_communities));

    }



    private void instantiate() {
        toolbar_communities = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_communities);
        getSupportActionBar().setTitle("Communities");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = communitiesActivity.this;
        viewPager_communities = (ViewPager) findViewById(R.id.view_pager_communities);
        tabLayout_communities = (TabLayout) findViewById(R.id.tab_layout_communities);

        list_communities = new ArrayList<>();
        list_communities.add(new Communities_Following_Fragment());
        list_communities.add(new Communities_Discover_Fragment());

        tabName = getResources().getStringArray(R.array.group_tabs);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.communities_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.communities_notification:
                startActivity(new Intent(communitiesActivity.this , NotificationActivity.class));


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
            return list_communities.get(position);
        }

        @Override
        public int getCount() {
            return list_communities.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabName[position];
        }
    }
}
