package com.jpm.inmobi.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.sdk.InMobiSdk;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;


public class SplashScreen extends Activity implements InMobiInterstitial.InterstitialAdListener2 {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    private InMobiInterstitial mInterstitialAd;

    private boolean adLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        initSdk();


        mInterstitialAd = new InMobiInterstitial(SplashScreen.this, 1471550843414L, this);
        requestNewInterstitial();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                // Prepare an Interstitial Ad Listener

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                if (adLoaded) {
                    mInterstitialAd.show();
                } else {
                    startActivity(i);
                }


                // close this activity
                finish();

            }
        }, SPLASH_TIME_OUT);
    }

    private void initSdk() {
        JSONObject consentObject = new JSONObject();
        try {
            // Provide correct consent value to sdk which is obtained by User
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true);
            // Provide 0 if GDPR is not applicable and 1 if applicable
            consentObject.put("gdpr", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        InMobiSdk.init(this, "Insert InMobi Account ID here", consentObject);
    }

    private void requestNewInterstitial() {
        mInterstitialAd.load();
    }

    @Override
    public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {

    }

    @Override
    public void onAdReceived(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
        adLoaded = true;
    }

    @Override
    public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {

    }

    @Override
    public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {

    }

    @Override
    public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
        requestNewInterstitial();
        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {

    }
}
