package com.example.edmododemo;

import android.content.Context;
import android.util.AttributeSet;

import com.liferay.mobile.screens.ddl.model.Record;
import com.liferay.mobile.screens.viewsets.westeros.ddl.list.DDLListView;

import java.util.List;

/**
 * Created by 1305166 on 20-12-2015.
 */
public class Hope extends DDLListView {
       public Hope(Context context, AttributeSet attributes, int defaultStyle) {
        super(context, attributes, defaultStyle);
    }
    public Hope(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    public Hope(Context context) {
        super(context);
    }



    @Override
    public void showFinishOperation(int page, List<Record> entries, int rowCount) {
        super.showFinishOperation(page, entries, rowCount);
    }




}
