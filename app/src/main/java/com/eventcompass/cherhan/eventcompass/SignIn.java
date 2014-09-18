package com.eventcompass.cherhan.eventcompass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class SignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final ImageButton btnLogin = (ImageButton)findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog fbProgressDialog = new ProgressDialog(SignIn.this);
                fbProgressDialog.setMessage("Signing in...");
                fbProgressDialog.setIndeterminate(false);
                fbProgressDialog.show();
//                try {
//                    Thread.sleep(2000);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }

// Hide after some seconds
                final Handler handler  = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (fbProgressDialog.isShowing()) {
                            fbProgressDialog.dismiss();
                            Intent SearchIntent = new Intent(SignIn.this, HomeActivity.class);
                            startActivity(SearchIntent);
                        }
                    }
                };

                fbProgressDialog.setOnDismissListener(new ProgressDialog.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        handler.removeCallbacks(runnable);
                    }
                });

                handler.postDelayed(runnable, 3000);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_in, menu);
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
