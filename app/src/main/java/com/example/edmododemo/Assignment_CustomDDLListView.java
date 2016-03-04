package com.example.edmododemo;

        import android.content.Context;
        import android.util.AttributeSet;

        import com.liferay.mobile.screens.base.list.BaseListScreenletView;
        import com.liferay.mobile.screens.ddl.list.DDLListScreenlet;
        import com.liferay.mobile.screens.ddl.model.Record;

        import java.util.List;

/**
 * Created by 1305166 on 15-01-2016.
 */


/**
 * @author Javier Gamarra
 */
public class Assignment_CustomDDLListView extends
        BaseListScreenletView<Record, Assignment_CustomDDLListAdapter.ImageViewHolder, Assignment_CustomDDLListAdapter> {


    public Assignment_CustomDDLListView(Context context) {
        super(context);
    }


    public Assignment_CustomDDLListView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }


    public Assignment_CustomDDLListView(Context context, AttributeSet attributes, int defaultStyle) {
        super(context, attributes, defaultStyle);
    }


    @Override
    public void showFinishOperation(int page, List<Record> entries, int rowCount) {
        DDLListScreenlet screenlet = (DDLListScreenlet) getParent();


        getAdapter().setLabelFields(screenlet.getLabelFields());


        super.showFinishOperation(page, entries, rowCount);
    }


    @Override
    protected Assignment_CustomDDLListAdapter createListAdapter(int itemLayoutId, int itemProgressLayoutId) {
        return new Assignment_CustomDDLListAdapter(itemLayoutId, itemProgressLayoutId, this);
    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.assignment_ddl_list_custom_row_layout;
    }


    @Override
    protected int getItemProgressLayoutId() {
        return com.liferay.mobile.screens.viewsets.R.layout.list_item_progress_material;
    }
}


