package com.example.edmododemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.liferay.mobile.screens.ddl.form.DDLFormListener;
import com.liferay.mobile.screens.ddl.form.DDLFormScreenlet;
import com.liferay.mobile.screens.ddl.model.DocumentField;
import com.liferay.mobile.screens.ddl.model.Record;

import org.json.JSONObject;

public class AssignmentActivity extends AppCompatActivity implements DDLFormListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        instantiate();

        DDLFormScreenlet ddlFormScreenlet = (DDLFormScreenlet) findViewById(R.id.ddl_form_assignment);
        ddlFormScreenlet.setListener(this);
        ddlFormScreenlet.setRecordSetId(21312);
        ddlFormScreenlet.setStructureId(21308);

    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_assignment);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Assignment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onDDLFormLoaded(Record record) {

    }

    @Override
    public void onDDLFormRecordLoaded(Record record) {

    }

    @Override
    public void onDDLFormRecordAdded(Record record) {

        Toast.makeText(AssignmentActivity.this, "Poll added !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AssignmentActivity.this , MainActivity.class));

    }

    @Override
    public void onDDLFormRecordUpdated(Record record) {

    }

    @Override
    public void onDDLFormLoadFailed(Exception e) {

    }

    @Override
    public void onDDLFormRecordLoadFailed(Exception e) {

    }

    @Override
    public void onDDLFormRecordAddFailed(Exception e) {

    }

    @Override
    public void onDDLFormUpdateRecordFailed(Exception e) {

    }

    @Override
    public void onDDLFormDocumentUploaded(DocumentField documentField, JSONObject jsonObject) {

    }

    @Override
    public void onDDLFormDocumentUploadFailed(DocumentField documentField, Exception e) {

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
