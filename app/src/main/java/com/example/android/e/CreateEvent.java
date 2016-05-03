package com.example.android.e;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import database.DatabaseHelper;

public class CreateEvent extends Activity implements View.OnClickListener {
    ArrayList<Restaurant> model = new ArrayList<Restaurant>();
    RestaurantAdapter adapter = null;
    Button map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // it must be the same with_Layout name
        setContentView(R.layout.activity_food_trip);
        Button save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(onSave);
        ListView list = (ListView) findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter();
        list.setAdapter(adapter);
        map=(Button) findViewById(R.id.mapID);
        map.setOnClickListener( this);
    }

    // Interfaces (OnClickListener)-listen on all click events
    //
    private View.OnClickListener onSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Restaurant r = new Restaurant(); // restore Restaurant r here
            EditText name = (EditText) findViewById(R.id.field_name);
            EditText address = (EditText) findViewById(R.id.field_address);
            RadioGroup types = (RadioGroup) findViewById(R.id.rgrp_types);

            switch (types.getCheckedRadioButtonId()) {
                case R.id.rbtn_chartiy:
                    r.setType("Charity");
                    break;
                case R.id.rbtn_nightlife:
                    r.setType("Nightlife");
                    break;
                case R.id.rbtn_sport:
                    r.setType("Sport");
                    break;
                case R.id.rbtn_kids:
                    r.setType("Kids");
                    break;
                case R.id.rbtn_geeks:
                    r.setType("Geeks");
                    break;

                case R.id.rbtn_parties:
                    r.setType("Parties");
                    break;


            }
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Name", r.getName());
            values.put("Description", r.getAddress());
            values.put("Category", r.getType());

            long rowId = db.insert("Events", null, values);
            //db.insert("Events",)

            // Clear texts
            ((EditText) findViewById(R.id.field_name)).setText("");
            ((EditText) findViewById(R.id.field_address)).setText("");
            // Clear Radio Buttons
            ((RadioGroup) findViewById(R.id.rgrp_types)).clearCheck();
            // SetFocus
            ((EditText) findViewById(R.id.field_name)).requestFocus();
            // add items in LView
            adapter.add(r);
        }
    };

    @Override
    public void onClick(View v) {

        Intent map_intent=new Intent(CreateEvent.this, MapsActivity.class);
        startActivity(map_intent);

    }

    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        RestaurantAdapter() {

            super(CreateEvent.this, android.R.layout.simple_list_item_1,
                    model);


        }

        // override here
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RestaurantHolder holder = null;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
                holder = new RestaurantHolder(row);
                row.setTag(holder);
            } else {
                holder = (RestaurantHolder) row.getTag();
            }
            holder.populateFrom(model.get(position));
            return (row);
        }
    }

    class RestaurantHolder {
        private TextView name = null;
        private TextView address = null;
        private ImageView icon = null;

        RestaurantHolder(View row) {
            name = (TextView) row.findViewById(R.id.row_name);
            address = (TextView) row.findViewById(R.id.row_address);
            icon = (ImageView) row.findViewById(R.id.row_icon);
        }

        void populateFrom(Restaurant r) {
            name.setText(r.getName());
            address.setText(r.getAddress());
            if (r.getType().equals("Charity")) {
                icon.setImageResource(R.drawable.charity1);
            }
            if (r.getType().equals("Nightlife")) {
                icon.setImageResource(R.drawable.create);
            }
            if (r.getType().equals("Kids")) {
                icon.setImageResource(R.drawable.images1);
            }
            if (r.getType().equals("Sport")) {
                icon.setImageResource(R.drawable.sport);
            }
            if (r.getType().equals("Geeks")) {
                icon.setImageResource(R.drawable.geeks);

            }
            if (r.getType().equals("Parties")) {
                icon.setImageResource(R.drawable.parties);
            }
        }
    }
}