package com.example.edmododemo;

import android.content.Intent;
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

public class SingleInfoFromList extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView title;
    TextView subTitle;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_info_from_list);

        instantiate();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            if(extras.getString("image")!=null)
            {
                imageView.setVisibility(View.VISIBLE);
                String imageUri = extras.getString("image");


                RequestCreator requestCreator = Picasso.with(LiferayScreensContext.getContext())
                        .load(imageUri);
                requestCreator.into(imageView);
            }


            if(extras.getString("title")!=null)
            {
                String from_text = extras.getString("title");
                title.setVisibility(View.VISIBLE);

                String colorText = "<font color='#276bb0'>Me</font>";

                title.setText(Html.fromHtml(colorText + " to " + from_text));

               // title.setText(from_text);
            }

           // String title_text = extras.getString("title");
//            title.setText(title_text.toString());

            if(extras.getString("subtitle")!=null)
            {
                String main_text = extras.getString("subtitle");
                subTitle.setVisibility(View.VISIBLE);
                subTitle.setText(main_text);
            }


            //String subtitle_text = extras.getString("subtitle");
          //  subTitle.setText(subtitle_text.toString());

        } else
            Toast.makeText(SingleInfoFromList.this, "Not Working", Toast.LENGTH_SHORT).show();

    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_single_info_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Posts");
        title = (TextView) findViewById(R.id.from_textview_single);
        subTitle = (TextView) findViewById(R.id.main_text_single);
        //editText = (EditText) findViewById(R.id.editText_activity_single_info_list);
        imageView = (ImageView) findViewById(R.id.ddl_list_image_single);

    }
}
