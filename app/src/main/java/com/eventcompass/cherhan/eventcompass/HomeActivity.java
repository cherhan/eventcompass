package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends Activity {

    TextView txtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_slideup);

        //Should show the actual location instead of a text
        txtLocation = (TextView) findViewById(R.id.tvLocation);
        txtLocation.setText("Push to Locate");

        //On click show actual location
        final ImageButton btnLocation = (ImageButton)findViewById(R.id.ivLocation);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLocation.setText("KL Convention Center");
            }
        });

        //Launches Search
        final ImageButton btnSearch = (ImageButton)findViewById(R.id.ivSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SearchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(SearchIntent);
            }
        });

        //Launches Mont Kiara Location
        final ImageView ivMK = (ImageView)findViewById(R.id.locationMK);

        ivMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mkIntent = new Intent(HomeActivity.this, LocationMKActivity.class);
                startActivity(mkIntent);
            }
        });

        //Drawer Content Events

        final ImageView btnCreateEvent = (ImageView)findViewById(R.id.btnCreateEvent);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createEventIntent = new Intent(HomeActivity.this, CreateEventActivity.class);
                startActivity(createEventIntent);
            }
        });

        final ImageView btnMyEvents = (ImageView)findViewById(R.id.btnMyTickets);

        btnMyEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EventsIntents = new Intent(HomeActivity.this, MyTicketsActivity.class);
                startActivity(EventsIntents);
            }
        });

        //Launching settings
        final ImageButton btnSettings = (ImageButton)findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingIntent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(settingIntent);
            }
        });

        //Goto Profile

        final ImageView bnrProfile = (ImageView)findViewById(R.id.bannerProfile);
        bnrProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(HomeActivity.this, ProfilePageActivity.class);
                startActivity(profileIntent);
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
