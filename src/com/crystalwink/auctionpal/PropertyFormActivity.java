/*
 * <b>Description:
 * @TODO Update description for PropertyFormActivity.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           PropertyFormActivity.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.io.File;

import com.crystalwink.auctionpal.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyFormActivity.
 */
public class PropertyFormActivity extends Activity {
	
	/** The Constant LOG_TAG. */
	private static final String LOG_TAG = "PropertyFormActivity";

	/** The property button. */
	private Button propertyButton;

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.propertyforsale);

//			this.propertyButton = (Button) this.findViewById(R.id.button_property_details);
//			this.propertyButton.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					// finish();
//				}
//			});

		} catch (Exception e) {
			Log.e(LOG_TAG, "onCreate() failed to start activity.", e);
			Toast.makeText(this, "No handler onCreate()" + e, Toast.LENGTH_LONG)
					.show();
		}
	}


    // Send a simple plain text email (no contents supplied)
    /**
     * Send simple email.
     *
     * @param button the button
     */
    public void sendSimpleEmail(View button) {
        try {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            startActivity(emailIntent);
        } catch (Exception e) {
            Log.e(LOG_TAG, "sendSimpleEmail() failed to start activity.", e);
            Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Send plain text email.
     *
     * @param button the button
     */
    public void sendPlainTextEmail(View button) {
        try {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

            String aEmailList[] = { getResources().getString(
                    R.string.email_address) };
            String aEmailCCList[] = { getResources().getString(
                    R.string.email_address_cc) };
            String aEmailBCCList[] = { getResources().getString(
                    R.string.email_address_bcc) };

            emailIntent
                    .putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
            emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
            emailIntent.putExtra(android.content.Intent.EXTRA_BCC,
                    aEmailBCCList);
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                    getResources().getString(R.string.email_subject));

            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    getResources().getString(R.string.email_message));

            startActivity(emailIntent);
        } catch (Exception e) {
            Log.e(LOG_TAG, "sendPlainTextEmail() failed to start activity.", e);
            Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Choose email.
     *
     * @param button the button
     */
    public void chooseEmail(View button) {

        try {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            startActivity(Intent.createChooser(emailIntent,
                    "Send your email in:"));
        } catch (Exception e) {
            Log.e(LOG_TAG, "chooseEmail() failed to start activity.", e);
            Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Send picture message.
     *
     * @param button the button
     */
    public void sendPictureMessage(View button) {
        try {
            Intent picMessageIntent = new Intent(
                    android.content.Intent.ACTION_SEND);
            picMessageIntent.setType("image/jpeg");
            File downloadedPic = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "q.jpeg");

            picMessageIntent.putExtra(Intent.EXTRA_STREAM, Uri
                    .fromFile(downloadedPic));

            startActivity(Intent.createChooser(picMessageIntent, getResources()
                    .getString(R.string.chooser_pic)));
        } catch (Exception e) {
            Log.e(LOG_TAG, "sendPictureMessage() failed to start activity.", e);
            Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
        }
    }
    
    
    /**
     * Launch form.
     *
     * @param button the button
     */
    public void launchForm(View button) {

        Intent launchEmailFormActivity = new Intent(this, EmailFormActivity.class); 
        startActivity(launchEmailFormActivity);

    }

}