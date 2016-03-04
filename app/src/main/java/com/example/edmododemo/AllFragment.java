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
public class AllFragment extends Fragment implements BaseListListener<Record> {


    public AllFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_all, container, false);

        DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) rootView.findViewById(R.id.custom_ddl_list_screenlet);
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


        Intent i = new Intent(getContext() , SingleInfoFromList.class);
        Log.d("subha", "Working Main");


        try {
            if (element.getServerValue("Documents___") != null) {

                JSONObject imagePath = new JSONObject((String) element.getServerValue("Documents___"));
                String uri = LiferayServerContext.getServer() + "/documents/" + LiferayServerContext.getGroupId() + "/" + imagePath.getString("uuid");


               // Intent i = new Intent(MainActivity.this, SingleInfoFromList.class);
                i.putExtra("image", uri);
                // startActivity(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Send_to___") != null) {
                String title = (String) element.getServerValue("Send_to___");
                i.putExtra("title",title);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (element.getServerValue("Type_your_note_here___") != null) {
                Object value = element.getServerValue("Type_your_note_here___");
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
