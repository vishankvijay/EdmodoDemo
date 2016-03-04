package com.example.edmododemo;

import android.content.Context;
import android.util.AttributeSet;


import com.liferay.mobile.screens.base.list.BaseListScreenletView;
import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
import com.liferay.mobile.screens.ddl.model.Record;

import java.util.List;


/**
 * @author Javier Gamarra
 */
public class CustomDDLListView extends
        BaseListScreenletView<Record, CustomDDLListAdapter.ImageViewHolder, CustomDDLListAdapter> {


    public CustomDDLListView(Context context) {
        super(context);
    }


    public CustomDDLListView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }


    public CustomDDLListView(Context context, AttributeSet attributes, int defaultStyle) {
        super(context, attributes, defaultStyle);
    }


    @Override
    public void showFinishOperation(int page, List<Record> entries, int rowCount) {
        DDLListScreenlet screenlet = (DDLListScreenlet) getParent();


        getAdapter().setLabelFields(screenlet.getLabelFields());


        super.showFinishOperation(page, entries, rowCount);
    }


    @Override
    protected CustomDDLListAdapter createListAdapter(int itemLayoutId, int itemProgressLayoutId) {
        return new CustomDDLListAdapter(itemLayoutId, itemProgressLayoutId, this);
    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.ddl_list_custom_row_layout;
    }


    @Override
    protected int getItemProgressLayoutId() {
        return com.liferay.mobile.screens.viewsets.R.layout.list_item_progress_material;
    }
}

