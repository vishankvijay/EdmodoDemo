package com.example.edmododemo;

import android.content.Intent;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.LiferayServerContext;
import com.liferay.mobile.screens.ddl.model.Record;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.json.JSONException;
import org.json.JSONObject;

public class FirstActivity extends AppCompatActivity {

    Button button_create_account;
    Button button_login;
    Toolbar toolbar;
    LinearLayout layout_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        instantiate();

        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this , LoginActivity.class));
                overridePendingTransition(R.anim.slide_in_left, 0);
            }
        });

        button_create_account = (Button) findViewById(R.id.button_create_account);
        button_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this , SignUpActivity.class));
            }
        });
    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_first);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome");
        //layout_animation = (LinearLayout) findViewById(R.id.layout_animation);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
        {
            TranslateAnimation animate = new TranslateAnimation(button_login.getWidth(), 0, 0, 0);
            animate.setDuration(650);
            animate.setFillAfter(true);
            button_login.startAnimation(animate);
        }
    }
}
