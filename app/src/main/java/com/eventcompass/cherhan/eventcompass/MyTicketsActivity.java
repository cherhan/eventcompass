package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.os.Bundle;

public class MyTicketsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tickets);

        getActionBar().setIcon(R.drawable.ic_phantom);
    }

}
