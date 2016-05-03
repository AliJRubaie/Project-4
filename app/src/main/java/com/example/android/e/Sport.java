package com.example.android.e;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.EventsAdapter;
import database.DatabaseHelper;

/**
 * Created by Admin on 4/1/2016.
 */
public class Sport  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport);
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Events where Category='Sport'", null);
        int count = c.getCount();
        if (count > 0) {
            ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
            c.moveToFirst();
            do {
                Restaurant r = new Restaurant();
                r.setAddress(c.getString(2));
                r.setName(c.getString(1));
                r.setId(c.getLong(0));
                restaurants.add(r);
            } while (c.moveToNext());

            ListView listView = (ListView) findViewById(R.id.sport_list_view);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Restaurant item = (Restaurant) view.getTag();
                    Intent intent =new Intent(Sport.this,OpenEventActivity.class);
                    intent.putExtra("Id",item.getId());

                    startActivity(intent);
                }
            });
            EventsAdapter adapter = new EventsAdapter(getApplicationContext(), 0, R.layout.resource_template, restaurants);
            listView.setAdapter(adapter);
        }
    }
}
