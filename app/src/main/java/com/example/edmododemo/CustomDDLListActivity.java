package com.example.edmododemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;


/**
 * @author Javier Gamarra
 */
public class CustomDDLListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.ddl_list_custom);


        DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) findViewById(R.id.custom_ddl_list_screenlet_trial);
        ddlListScreenlet.loadPage(0);
    }
}
