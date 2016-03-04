package com.example.edmododemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.User;

public class LoginActivity extends AppCompatActivity implements LoginListener {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        instantiate();

        LoginScreenlet loginScreenlet = (LoginScreenlet) findViewById(R.id.login);
        loginScreenlet.setListener(this);
    }

    private void instantiate() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public void onLoginSuccess(User user)
    {
        //startActivity(new Intent(LoginActivity.this , Try.class));

        startActivity(new Intent(LoginActivity.this , MainActivity.class));
        //Toast.makeText(LoginActivity.this, "ok", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginFailure(Exception e) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoginActivity.this, FirstActivity.class));
        overridePendingTransition(R.anim.slide_in_right, 0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_activity_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
