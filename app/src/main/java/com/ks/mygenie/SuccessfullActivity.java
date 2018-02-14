package com.ks.mygenie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SuccessfullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull);

        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

                startActivity(new Intent(SuccessfullActivity.this, MainActivity.class));
                // If you want to call Activity then call from here for 5 seconds it automatically call and your image disappear....
            }
        }, 5000);
    }
}
