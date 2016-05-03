package com.example.android.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Admin on 3/29/2016.
 */
public class HomePage extends Activity implements View.OnClickListener {
    TextView event, notification, createEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        event= (TextView) findViewById(R.id.eventBTN);
        event.setOnClickListener(this);

        createEvent=(TextView) findViewById(R.id.createEventBTN);
        createEvent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eventBTN:{
                Intent i = new Intent (HomePage.this , Events.class);
                startActivity(i);
                    break;
                }
            case R.id.createEventBTN:{
                Intent k=new Intent(HomePage.this, CreateEvent.class);
                startActivity(k);
                break;
            }
        }
    }

}
