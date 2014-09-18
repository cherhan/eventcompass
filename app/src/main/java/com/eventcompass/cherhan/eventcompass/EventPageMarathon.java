package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class EventPageMarathon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_page_marathon);

        //Drawer Content Events

        final ImageView btnCreateEvent = (ImageView)findViewById(R.id.btnCreateEvent);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createEventIntent = new Intent(EventPageMarathon.this, CreateEventActivity.class);
                startActivity(createEventIntent);
            }
        });

        final ImageView btnBrowse = (ImageView)findViewById(R.id.btnBrowseEvents);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseIntent = new Intent(EventPageMarathon.this, HomeActivity.class);
                startActivity(browseIntent);
            }
        });

        final ImageView btnFeedback = (ImageView)findViewById(R.id.btnFeedback);

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedbackIntents = new Intent(EventPageMarathon.this, EventFeedbackActivity.class);
                startActivity(feedbackIntents);
            }
        });

        final ImageView btnMyEvents = (ImageView)findViewById(R.id.btnMyTickets);

        btnMyEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EventsIntents = new Intent(EventPageMarathon.this, MyTicketsActivity.class);
                startActivity(EventsIntents);
            }
        });

        //Goto Profile

        final ImageView bnrProfile = (ImageView)findViewById(R.id.bannerProfile);
        bnrProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(EventPageMarathon.this, ProfilePageActivity.class);
                startActivity(profileIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event_page_marathon, menu);
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
