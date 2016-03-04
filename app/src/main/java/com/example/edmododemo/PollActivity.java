package com.example.edmododemo;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.liferay.mobile.screens.ddl.form.DDLFormListener;
import com.liferay.mobile.screens.ddl.form.DDLFormScreenlet;
import com.liferay.mobile.screens.ddl.model.DocumentField;
import com.liferay.mobile.screens.ddl.model.Record;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.json.JSONObject;

import java.util.Calendar;

public class PollActivity extends AppCompatActivity implements DDLFormListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);

        instantiate();

        DDLFormScreenlet ddlFormScreenlet = (DDLFormScreenlet) findViewById(R.id.ddl_form_poll);
        ddlFormScreenlet.setListener(this);
        ddlFormScreenlet.setRecordSetId(21315);
        ddlFormScreenlet.setStructureId(21310);

    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_poll);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Poll");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.poll_activity_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.schedule:
                showAlertDialog();
                break;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDDLFormLoaded(Record record) {

    }

    @Override
    public void onDDLFormRecordLoaded(Record record) {

    }

    @Override
    public void onDDLFormRecordAdded(Record record) {

        Toast.makeText(PollActivity.this, "Poll added !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PollActivity.this, pollDDLList.class));
        finish();

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

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute)
    {
        Toast.makeText(PollActivity.this, "Selected Time - " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        //showAlertDialog();



    }

    private void showAlertDialog()
    {

        final CharSequence[] items = { "Select a Date", "Select a Time"};

        AlertDialog.Builder builder = new AlertDialog.Builder(PollActivity.this);
        builder.setTitle("Schedule a Post");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item)
            {

                // will toast your selection
                if(item == 0)
                {Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            PollActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "Datepickerdialog");


                }

                if(item == 1)
                {
                    Calendar now = Calendar.getInstance();
                    TimePickerDialog tpd = TimePickerDialog.newInstance(
                            PollActivity.this,
                            now.get(Calendar.HOUR_OF_DAY),
                            now.get(Calendar.MINUTE),
                            false
                    );

                    //current = "start";
                    //tpd.setThemeDark(true);
                    tpd.vibrate(true);
                    tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {

                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            Log.d("TimePicker", "Dialog was cancelled");
                        }
                    });
                    tpd.show(getFragmentManager(), "Timepickerdialog");
                }

                //dialog.dismiss();

            }
        }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth)
    {
        Toast.makeText(PollActivity.this, "Selcted Date - " + dayOfMonth + "/" + monthOfYear + "/" + year, Toast.LENGTH_SHORT).show();

    }
}
