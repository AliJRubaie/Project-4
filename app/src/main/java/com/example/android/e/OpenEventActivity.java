package com.example.android.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import database.DatabaseHelper;

public class OpenEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_event);
        long eventId = getIntent().getLongExtra("Id", 0);
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Events where Id=" + eventId, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            Restaurant r = new Restaurant();
            r.setAddress(c.getString(2));
            r.setId(c.getLong(0));
            r.setName(c.getString(1));

            TextView name, desc;
            name = (TextView) findViewById(R.id.event_name);
            desc = (TextView) findViewById(R.id.event_description);
            name.setText(r.getName());
            desc.setText(r.getAddress());
        }
    }
}
