package com.example.android.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.EventsAdapter;
import database.DatabaseHelper;

/**
 * Created by Admin on 4/1/2016.
 */
public class Charity extends Activity {
    private static final String EVENTS ="Events" ;
    Button Clear, deletebtn;
    CreateEvent.RestaurantAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charity);
        final Context context=this;


        final DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        final SQLiteDatabase db = helper.getReadableDatabase();


     //   final Button deletebtn = (Button) findViewById(R.id.deletebtn);




        Cursor c = db.rawQuery("SELECT * FROM Events where Category='Charity'", null);
         int  count = c.getCount();
        if (count > 0) {
            final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
            c.moveToFirst();
            do {
                Restaurant r = new Restaurant();
                r.setAddress(c.getString(2));
                r.setName(c.getString(1));
                r.setId(c.getLong(0));
                restaurants.add(r);
            } while (c.moveToNext());

            final ListView listView = (ListView) findViewById(R.id.charity_list_view);
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, final long id) {
                    final AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                    alertdialog.setTitle("Options");
                    alertdialog.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Charity.this.finish();
                        }
                    });
                           alertdialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int id) {
                                  helper.getWritableDatabase();

                                   db.delete(EVENTS, String.valueOf(id),null);
                                   //db.execSQL("DELETE FROM Events where Name='Ali'",null);
                                   String title;
                                    //int iD= listView.getId();

                                    // listView.
                                   // title = listView.get(position).getTitle();

                                 //  helper.removeSingleContact(iD);

                                   //Update your ArrayList
                                  //helper.getAllContacts();

                                   //Notify your ListView adapter

                                   //adapter.setNotifyOnChange(true);
                                    //listView.removeFooterView(view);
                                   dialog.cancel();
                               }

                           }) ;
                    AlertDialog alertDialog = alertdialog.create();

                    // show it
                    alertDialog.show();
                    return true;
                }

            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Restaurant item = (Restaurant) view.getTag();
                    Intent intent = new Intent(Charity.this, OpenEventActivity.class);
                    intent.putExtra("Id", item.getId());

                    startActivity(intent);
                }
            });
            EventsAdapter adapter = new EventsAdapter(getApplicationContext(), 0, R.layout.resource_template, restaurants);
            listView.setAdapter(adapter);



        }



    }

   /* public void onClick(View v) {
        switch (v.getId()){
            case R.id.deletebtn:

                    break;
        }


    }
*/

}


