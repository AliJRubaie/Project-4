package com.example.android.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PageTwo extends Activity implements View.OnClickListener {
    LinearLayout splash;
    Button signup;
    EditText userName, lastName, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);
        splash= (LinearLayout) findViewById(R.id.ttt);
        signup= (Button) findViewById(R.id.signupbt);
        signup.setOnClickListener(this);

        userName= (EditText) findViewById(R.id.usernameID);
        lastName= (EditText) findViewById(R.id.lastnameID);
        email= (EditText) findViewById(R.id.emailID);
        password= (EditText) findViewById(R.id.passwordID);

    }
    @Override
    public void onClick(View v) {
        Intent intentObj=new Intent(PageTwo.this,HomePage.class);
        startActivity(intentObj);


    }
}