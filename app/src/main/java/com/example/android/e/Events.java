package com.example.android.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 3/30/2016.
 */
public class Events extends Activity implements View.OnClickListener {
  TextView kids,party,nightlife,sport,geeks,charity;
    ImageView kidsimg, partyimg, nightlifeimg, sportimg, geeksimg, charityimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        kids = (TextView) findViewById(R.id.kidsBTN);
        kids.setOnClickListener(this);

        party = (TextView) findViewById(R.id.partiesBTN);
        party.setOnClickListener(this);

        charity = (TextView) findViewById(R.id.charityBTN);
        charity.setOnClickListener(this);

        nightlife = (TextView) findViewById(R.id.nightlifeBTN);
        nightlife.setOnClickListener(this);

        geeks = (TextView) findViewById(R.id.geeksBTN);
        geeks.setOnClickListener(this);

        sport = (TextView) findViewById(R.id.sportsAndOutdoorsBTN);
        sport.setOnClickListener(this);

        sportimg= (ImageView) findViewById(R.id.sportsAndOutdoorsBTNS);
        sportimg.setOnClickListener(this);

        geeksimg= (ImageView) findViewById(R.id.geeksBTNS);
        geeksimg.setOnClickListener(this);

        charityimg= (ImageView) findViewById(R.id.charityBTNS);
        charityimg.setOnClickListener(this);

        nightlifeimg= (ImageView) findViewById(R.id.nightlifeBTNS);
        nightlifeimg.setOnClickListener(this);

        kidsimg= (ImageView) findViewById(R.id.kidsBTNS);
        kidsimg.setOnClickListener(this);

        partyimg= (ImageView) findViewById(R.id.partiesBTNS);
        partyimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Events.this,Parties.class);
                startActivity(intent);
            }
        });

    }


    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.kidsBTN:
            Intent intentKids=new Intent(Events.this,Kids.class);
            startActivity(intentKids);
            break;
            case R.id.sportsAndOutdoorsBTN:
                Intent intentSports=new Intent(Events.this,Sport.class);
                startActivity(intentSports);
                break;
            case R.id.partiesBTN:
                Intent intentParty=new Intent(Events.this,Parties.class);
                startActivity(intentParty);
                break;
            case R.id.nightlifeBTN:
                Intent intentNightlife=new Intent(Events.this,Nightlife.class);
                startActivity(intentNightlife);
                break;
            case R.id.geeksBTN:
                Intent intentGeeks=new Intent(Events.this,Geeks.class);
                startActivity(intentGeeks);
                break;
            case R.id.charityBTN:
                Intent intentCharity=new Intent(Events.this,Charity.class);
                startActivity(intentCharity);
                break;
            case R.id.kidsBTNS:
                Intent intentKidsimg=new Intent(Events.this,Kids.class);
                startActivity(intentKidsimg);
                break;
            case R.id.sportsAndOutdoorsBTNS:
                Intent intentSportsimg=new Intent(Events.this,Sport.class);
                startActivity(intentSportsimg);
                break;
            case R.id.partiesBTNS:
                Intent intentPartyimg=new Intent(Events.this,Parties.class);
                startActivity(intentPartyimg);
                break;
            case R.id.nightlifeBTNS:
                Intent intentNightlifeimg=new Intent(Events.this,Nightlife.class);
                startActivity(intentNightlifeimg);
                break;
            case R.id.geeksBTNS:
                Intent intentGeeksimg=new Intent(Events.this,Geeks.class);
                startActivity(intentGeeksimg);
                break;
            case R.id.charityBTNS:
                Intent intentCharityimg=new Intent(Events.this,Charity.class);
                startActivity(intentCharityimg);
                break;

        }
    }
}