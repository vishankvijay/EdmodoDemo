package com.example.edmododemo;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edmododemo.actionBarDropDown.SpinnerNavItem;
import com.example.edmododemo.actionBarDropDownAdapter.TitleNavigationAdapter;
import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.base.list.BaseListScreenlet;
import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.LiferayServerContext;
import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
import com.liferay.mobile.screens.ddl.model.Record;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ActionBar.OnNavigationListener, BaseListListener<Record> {

    private Toolbar toolbar;
    private Context context;
    private TextView textView_user_name;
    private TextView textView_user_email;
    private TextView text;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private FragmentTransaction fragmentManager;

    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;
    // Navigation adapter
    private TitleNavigationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*setContentView(R.layout.ddl_list_custom);*/


        /*DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) findViewById(R.id.custom_ddl_list_screenlet);
        ddlListScreenlet.setListener(this);
        ddlListScreenlet.loadPage(0);*/

        instantiate();

        AllFragment all_fragment = new AllFragment();
        fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.add(R.id.main_layout_fragment , all_fragment , "allFragment");
        fragmentManager.commit();

        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        /*text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This is a simple toast", Toast.LENGTH_SHORT).show();
            }
        });*/

        String user_first_name = SessionContext.getCurrentUser().getFirstName();
        String user_second_name = SessionContext.getCurrentUser().getLastName();
        String user_email = SessionContext.getCurrentUser().getEmail();


        View view = navigationView.inflateHeaderView(R.layout.drawer_header);
        textView_user_name = (TextView) view.findViewById(R.id.textView_user_name);
        textView_user_name.setText(user_first_name + "" + user_second_name);

        textView_user_email = (TextView) view.findViewById(R.id.textView_user_email);
        textView_user_email.setText(user_email);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_activity_menu, menu);
/*
        Spinner spinner = (Spinner)menu.findItem(R.id.my_menu).getActionView();
*/
       /* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
            }
        });*/

    /*    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.main_search:
                break;

            case R.id.add:
                addAlertDialog();
                break;

            case R.id.main_notifications:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    private void addAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setItems(R.array.Note_array, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                switch (item) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, NoteActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, PollActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this, AssignmentActivity.class));
                        break;
                }

                //Toast.makeText(MainActivity.this, "Name: " + item, Toast.LENGTH_SHORT).show();
                //showToast("Name: " + items[item]);
                dialog.dismiss();

            }
        }).show();
    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Posts");

        // Hide the action bar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Enabling Spinner dropdown navigation
        getSupportActionBar().setNavigationMode(getSupportActionBar().NAVIGATION_MODE_LIST);

        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("All"));
        navSpinner.add(new SpinnerNavItem("Assignments"));
        navSpinner.add(new SpinnerNavItem("Polls"));


        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);

        // assigning the spinner navigation
        getSupportActionBar().setListNavigationCallbacks(adapter, this);

        context = MainActivity.this;
        //text = (TextView) toolbar.findViewById(R.id.sample_text);
        navigationView = (NavigationView) findViewById(R.id.main_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_0:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;

            case R.id.item_1:
                startActivity(new Intent(MainActivity.this, GroupsActivity.class));
                break;
            case R.id.item_2:
                startActivity(new Intent(MainActivity.this, communitiesActivity.class));
                break;

            case R.id.item_3:
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
                break;

            case R.id.item_4:
                SessionContext.logout();
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                finish();
                break;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
       // Toast.makeText(MainActivity.this, "" + itemPosition, Toast.LENGTH_SHORT).show();

        switch (itemPosition)
        {
            case 0 :
                if(fragmentManager!=null)
                {
                    AllFragment allFragment = new AllFragment();
                    fragmentManager = getSupportFragmentManager().beginTransaction();
                    fragmentManager.replace(R.id.main_layout_fragment, allFragment );
                    fragmentManager.commit();
                }
                break;

            case 1 :
                if(fragmentManager!=null)
                {
                    AssignmentFragment assignmentFragment = new AssignmentFragment();
                    fragmentManager = getSupportFragmentManager().beginTransaction();
                    fragmentManager.replace(R.id.main_layout_fragment, assignmentFragment);
                    fragmentManager.commit();
                }
                break;

            case 2 :
                if(fragmentManager!=null)
                {
                PollsFragment pollsFragment = new PollsFragment();
                fragmentManager = getSupportFragmentManager().beginTransaction();
                fragmentManager.replace(R.id.main_layout_fragment, pollsFragment);
                fragmentManager.commit();
                }

                break;

        }
        return false;
    }

    @Override
    public void onListPageFailed(BaseListScreenlet source, int page, Exception e) {

    }

    @Override
    public void onListPageReceived(BaseListScreenlet source, int page, List<Record> entries, int rowCount) {

    }

    @Override
    public void onListItemSelected(Record element, View view) {

        Intent i = new Intent(MainActivity.this, SingleInfoFromList.class);
        Log.d("subha", "Working Main");


        try {
            if (element.getServerValue("Documents_note") != null) {

                JSONObject imagePath = new JSONObject((String) element.getServerValue("Documents_note"));
                String uri = LiferayServerContext.getServer() + "/documents/" + LiferayServerContext.getGroupId() + "/" + imagePath.getString("uuid");


              /*  Intent i = new Intent(MainActivity.this, SingleInfoFromList.class);
                i.putExtra("image",uri);
                startActivity(i);*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Text") != null) {
                String title = (String) element.getServerValue("Text");
                i.putExtra("title",title);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Text_Box2097") != null) {
                Object value = element.getServerValue("Text_Box2097");
                if (value != null) {
                    String subtitle = value.toString();
                    i.putExtra("subtitle",subtitle);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Toast.makeText(this, " "+text, Toast.LENGTH_SHORT).show();
                startActivity(i);





    }

    @Override
    public void loadingFromCache(boolean success) {

    }

    @Override
    public void retrievingOnline(boolean triedInCache, Exception e) {

    }

    @Override
    public void storingToCache(Object object) {

    }
}

