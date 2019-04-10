package com.jpm.inmobi.ads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.inmobi.ads.InMobiBanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //to show banner
        InMobiBanner bannerAd = (InMobiBanner) findViewById(R.id.banner);
    }
}
