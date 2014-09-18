package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventFeedbackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_feedback);

        final Button btnSubmit = (Button)findViewById(R.id.button);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent isubmit = new Intent(EventFeedbackActivity.this, EventFeedbackSent.class);
                startActivity(isubmit);
            }
        });
    }
}
