package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreateEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setIcon(R.drawable.ic_phantom);
//        String[] wee = list2.toArray(new String[list2.size()]);
//
        final String[] strDate={"18 Sept 2014", "19 Sept 2014", "20 Sept 2014"};
        final String[] strTime={"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, strDate);
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, strTime);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

// Spinner spinYear = (Spinner)findViewById(R.id.spin);
        ((Spinner) findViewById(R.id.spinnerDate)).setAdapter(spinnerArrayAdapter);
        ((Spinner) findViewById(R.id.spinnerTime)).setAdapter(spinnerArrayAdapter2);

    }

}
