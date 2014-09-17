package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.os.Bundle;

public class CreateEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setIcon(R.drawable.ic_phantom);
    }

}
