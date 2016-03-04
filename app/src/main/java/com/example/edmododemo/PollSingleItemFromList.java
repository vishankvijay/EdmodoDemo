package com.example.edmododemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PollSingleItemFromList extends AppCompatActivity {

    Toolbar toolbar;
    TextView sendTo;
    TextView question;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_single_item_from_list);


        instantiate();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            if (getIntent().hasExtra("Send_to___"))
            {
                String send = getIntent().getExtras().getString("Send_to___");

               // String from_text = extras.getString("title");
              //  title.setVisibility(View.VISIBLE);

                String colorText = "<font color='#276bb0'>Me</font>";

                sendTo.setText(Html.fromHtml(colorText + " to " + send));
                //sendTo.setText(send);
            }
            //title.setText(title_text.toString());


            if (getIntent().hasExtra("Type_your_question_here___")) {
                String ques = getIntent().getExtras().getString("Type_your_question_here___");
                question.setText(ques);
            }

            if (getIntent().hasExtra("Answer__1")) {
                String ans1 = getIntent().getExtras().getString("Answer__1");
                answer1.setVisibility(View.VISIBLE);
                answer1.setText(ans1);
            }

            if (getIntent().hasExtra("Answer__2")) {
                String ans2 = getIntent().getExtras().getString("Answer__2");
                answer2.setVisibility(View.VISIBLE);
                answer2.setText(ans2);
            }

            if (getIntent().hasExtra("Answer__3")) {
                String ans3 = extras.getString("Answer__3");
                answer3.setVisibility(View.VISIBLE);
                answer3.setText(ans3);
            }

            if (getIntent().hasExtra("Answer__4")) {
                String ans4 = getIntent().getExtras().getString("Answer__4");
                answer4.setVisibility(View.VISIBLE);
                answer4.setText(ans4);
            }

        } else
            Toast.makeText(PollSingleItemFromList.this, "Not Working", Toast.LENGTH_SHORT).show();
    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_poll_single_item_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Polls");
        sendTo = (TextView) findViewById(R.id.poll_single_item_from_textview);
        question = (TextView) findViewById(R.id.poll_single_item_question);
        answer1 = (TextView) findViewById(R.id.poll_single_item_answer1);
        answer2 = (TextView) findViewById(R.id.poll_single_item_answer2);
        answer3 = (TextView) findViewById(R.id.poll_single_item_answer3);
        answer4 = (TextView) findViewById(R.id.poll_single_item_answer4);
        //editText = (EditText) findViewById(R.id.editText_activity_single_info_list);

    }
}
