package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import team42.parse.classes.EventArrayAdapter;
import team42.parse.classes.ParseEvent;

public class LocationMKActivity extends Activity {
    EventArrayAdapter adapter;
    ParseEvent[] eventArray;
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ImageButton btnShowMap;
    RelativeLayout fMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_mk_slideup);
        Parse.initialize(this, "700oQj0ihCIOlknbt5XoG63xLW5RnuhkVk8UJdbc", "Bbu65C3VMer6CPs30O1ro1vcOwaBytQ49Jwi2ubY");


        new GetEventAsyncTask().execute();

        //gps button should show the map, replaces the image with the map

        final ImageButton btnBack = (ImageButton)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(LocationMKActivity.this, HomeActivity.class);
                startActivity(backIntent);
            }
        });

        //Launches Search
        final ImageButton btnSearch = (ImageButton)findViewById(R.id.ivSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SearchIntent = new Intent(LocationMKActivity.this, SearchActivity.class);
                startActivity(SearchIntent);
            }
        });

        //Drawer Content Events

        final ImageView btnCreateEvent = (ImageView)findViewById(R.id.btnCreateEvent);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createEventIntent = new Intent(LocationMKActivity.this, CreateEventActivity.class);
                startActivity(createEventIntent);
            }
        });

        final ImageView btnBrowse = (ImageView)findViewById(R.id.btnBrowseEvents);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseIntent = new Intent(LocationMKActivity.this, HomeActivity.class);
                startActivity(browseIntent);
            }
        });

        final ImageView btnMyEvents = (ImageView)findViewById(R.id.btnMyTickets);

        btnMyEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EventsIntents = new Intent(LocationMKActivity.this, MyTicketsActivity.class);
                startActivity(EventsIntents);
            }
        });

        //Goto Profile

        final ImageView bnrProfile = (ImageView)findViewById(R.id.bannerProfile);
        bnrProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(LocationMKActivity.this, ProfilePageActivity.class);
                startActivity(profileIntent);
            }
        });



    }

    private class GetEventAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(LocationMKActivity.this);

            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");

            mProgressDialog.setIndeterminate(false);

            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Event");
            query.orderByAscending("StartDate");

            try {
                ob = query.find();

            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listView3);
            // Pass the results into an ArrayAdapter
            adapter = new EventArrayAdapter(LocationMKActivity.this, R.layout.list_item_event, ob);

            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();

            // // Capture button clicks on ListView items
            // listview.setOnItemClickListener(new OnItemClickListener() {
            // @Override
            // public void onItemClick(AdapterView<?> parent, View view,
            // int position, long id) {
            // // Send single item click data to SingleItemView Class
            // Intent i = new Intent(MainActivity.this,
            // SingleItemView.class);
            // // Pass data "name" followed by the position
            // i.putExtra("name", ob.get(position).getString("name")
            // .toString());
            // // Open SingleItemView.java Activity
            // startActivity(i);
            // }
            // });
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.location_mk, menu);
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
