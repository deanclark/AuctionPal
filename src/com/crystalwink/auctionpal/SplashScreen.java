/*
 * <b>Description:
 *
 * To provide a simple splash screen to advise the user that this app is under development and to use the feedback form rather than rate the app during beta phase.
 *
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 *
 * file           AuctionPalActivity.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.io.File;
import java.util.Vector;
//import java.text.DecimalFormat;
//import java.text.NumberFormat;

//import com.crystalwink.auctionpal.*;
import com.crystalwink.auctionpal.OfferIncrementFormActivity;
import com.crystalwink.auctionpal.PropertyForSale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
//import com.google.ads.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SplashScreen.
 */
 public class SplashScreen extends Activity {

        //how long until we go to the next activity
        protected int _splashTime = 8000;

        private Thread splashTread;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
            //requestWindowFeature(Window.FEATURE_NO_TITLE);  // hide application title

            final SplashScreen sPlashScreen = this;

            // thread for displaying the SplashScreen
            splashTread = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized(this){

                                //wait 5 sec
                                wait(_splashTime);
                        }

                    } catch(InterruptedException e) {}
                    finally {
                        finish();

                        //start a new activity
                        Intent launchAuctionPalActivity = new Intent();
                        launchAuctionPalActivity.setClass(sPlashScreen, AuctionPalActivity.class);
                                startActivity(launchAuctionPalActivity);

                        //stop();
                    }
                }
            };

            splashTread.start();
        }

        //Function that will handle the touch
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                synchronized(splashTread){
                        splashTread.notifyAll();
                }
            }
            return true;
        }

}