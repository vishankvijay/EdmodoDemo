package com.example.edmododemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.base.list.BaseListScreenlet;
import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
import com.liferay.mobile.screens.ddl.model.Record;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment implements BaseListListener<Record> {


    public AssignmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_assignment, container, false);



        View rootView = inflater.inflate(R.layout.fragment_assignment, container, false);

        DDLListScreenlet ddlListScreenlet = (DDLListScreenlet) rootView.findViewById(R.id.assignment_custom_ddl_list_screenlet);
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
        startActivity(new Intent(getContext() , Assignment_single_info_from_list.class));

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
