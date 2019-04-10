package com.jpm.inmobi.ads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.inmobi.ads.InMobiBanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(this);

        //to show banner
        InMobiBanner bannerAd = (InMobiBanner) findViewById(R.id.banner);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Toast...", Toast.LENGTH_LONG).show();
    }
}
