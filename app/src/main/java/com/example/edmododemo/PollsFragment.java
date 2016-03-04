package com.example.edmododemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.base.list.BaseListScreenlet;
import com.liferay.mobile.screens.context.LiferayServerContext;
import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
import com.liferay.mobile.screens.ddl.model.Record;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PollsFragment extends Fragment implements BaseListListener<Record> {


    public PollsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_polls, container, false);

        View rootView = inflater.inflate(R.layout.fragment_polls, container, false);

        DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) rootView.findViewById(R.id.poll_custom_ddl_list_screenlet);
        ddlListScreenlet.setListener(this);
        ddlListScreenlet.loadPage(0);
        return rootView;
    }

    @Override
    public void onListPageFailed(BaseListScreenlet source, int page, Exception e) {

    }

    @Override
    public void onListPageReceived(BaseListScreenlet source, int page, List<Record> entries, int rowCount) {

    }

    @Override
    public void onListItemSelected(Record element, View view)
    {
        Intent i = new Intent(getContext() , PollSingleItemFromList.class);
        Log.d("subha", "Working Main");


        try {
            if (element.getServerValue("Send_to___") != null) {


                i.putExtra("Send_to___", (String) element.getServerValue("Send_to___"));

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        try {
            if (element.getServerValue("Type_your_question_here___") != null) {

                i.putExtra("Type_your_question_here___",(String) element.getServerValue("Type_your_question_here___"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Answer__1") != null)
            {
                i.putExtra("Answer__1",(String) element.getServerValue("Answer__1"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            if (element.getServerValue("Answer__2") != null)
            {
                i.putExtra("Answer__2",(String) element.getServerValue("Answer__2"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            if (element.getServerValue("Answer__3") != null)
            {
                i.putExtra("Answer__3",(String) element.getServerValue("Answer__3"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            if (element.getServerValue("Answer__4") != null)
            {
                i.putExtra("Answer__4",(String) element.getServerValue("Answer__4"));

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
