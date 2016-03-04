package com.example.edmododemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;

import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.base.list.BaseListScreenlet;
import com.liferay.mobile.screens.context.LiferayServerContext;
import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
import com.liferay.mobile.screens.ddl.model.Record;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class pollDDLList extends AppCompatActivity implements BaseListListener<Record> {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_ddllist);

        DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) findViewById(R.id.poll_custom_ddl_list_screenlet);
        ddlListScreenlet.setListener(this);
        ddlListScreenlet.loadPage(0);
        instantiate();


    }
    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_poll_ddl_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Poll");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }







    @Override
    public void onListPageFailed(BaseListScreenlet source, int page, Exception e) {

    }

    @Override
    public void onListPageReceived(BaseListScreenlet source, int page, List<Record> entries, int rowCount) {

    }

    @Override
    public void onListItemSelected(Record element, View view) {

        Intent i = new Intent(pollDDLList.this, PollSingleItemFromList.class);
        Log.d("subha", "Working Main");

        try {
            if (element.getServerValue("Send_to___") != null) {
                String sendTo = (String) element.getServerValue("Send_to___");
                i.putExtra("sendTo",sendTo);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (element.getServerValue("Type_your_question_here___") != null) {
                String question = (String) element.getServerValue("Type_your_question_here___");
                i.putExtra("question",question);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Answer__1") != null) {
                String answer1 = (String) element.getServerValue("Answer__1");
                i.putExtra("answer1",answer1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Answer__2") != null) {
                String answer2 = (String) element.getServerValue("Answer__2");
                i.putExtra("answer2",answer2);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Answer__3") != null) {
                String answer3 = (String) element.getServerValue("Answer__3");
                i.putExtra("answer3",answer3);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Answer__4") != null) {
                String answer4 = (String) element.getServerValue("Answer__4");
                i.putExtra("answer4",answer4);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



      /*  try {
            if (element.getServerValue("Documents_note") != null) {

                JSONObject imagePath = new JSONObject((String) element.getServerValue("Documents_note"));
                String uri = LiferayServerContext.getServer() + "/documents/" + LiferayServerContext.getGroupId() + "/" + imagePath.getString("uuid");


              *//*  Intent i = new Intent(MainActivity.this, SingleInfoFromList.class);
                i.putExtra("image",uri);
                startActivity(i);*//*
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
        }*/
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
