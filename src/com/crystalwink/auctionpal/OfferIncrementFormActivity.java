/*
 * <b>Description:
 * @TODO Update description for OfferIncrementFormActivity.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           OfferIncrementFormActivity.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.util.Vector;

import com.crystalwink.auctionpal.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class OfferIncrementFormActivity.
 */
public class OfferIncrementFormActivity extends Activity {
	
	/** The Constant LOG_TAG. */
	private static final String LOG_TAG = "OfferIncrementFormActivity";
	
	/** The Constant MAX_OFFER_LINES_SUPPORTED. */
	private static final int MAX_OFFER_LINES_SUPPORTED = 8;
	
	/** The offer increments button. */
	private Button offerIncrementsButton;
	 
	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.offer_increments_suggestion);
			//this.requestWindowFeature(Window.FEATURE_NO_TITLE);  // hide application title

       	 int numberOfOfferSteps = 8;
       	 Vector<Double> incrementsVector = AuctionPalActivity.newProperty.getRecomendedOfferIncrements(numberOfOfferSteps, false);  // steps, (t)linear/(f)descending
            TextView stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine1);

            
            // CLEAR ALL OFFER AMOUNTS
          	 for (int ii=0; ii<MAX_OFFER_LINES_SUPPORTED; ii++){
                 	switch(ii)
                 	{
                 	case 0: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine1);
                 	break;
                 	case 1: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine2);
                 	break;
                 	case 2: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine3);
                 	break;
                 	case 3: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine4);
                 	break;
                 	case 4: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine5);
                 	break;
                 	case 5: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine6);
                 	break;
                 	case 6: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine7);
                 	break;
                 	case 7: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine8);
                 	break;
                 	}
                 stampDutytext.setText("");
           	 }
            
            
          	 // Update new offer amounts based on current asking price
          	 for (int ii=0; ii<incrementsVector.size(); ii++){
             	switch(ii)
             	{
             	case 0: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine1);
             	break;
             	case 1: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine2);
             	break;
             	case 2: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine3);
             	break;
             	case 3: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine4);
             	break;
             	case 4: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine5);
             	break;
             	case 5: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine6);
             	break;
             	case 6: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine7);
             	break;
             	case 7: stampDutytext  = (TextView)findViewById(R.id.offerIncrementLine8);
             	break;
             	}
             	stampDutytext.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(7, 2)}); 
             	stampDutytext.setText(String.format("%d.    £%.2f     %.2f%%    £%.2f", ii, incrementsVector.get(ii), StampDuty.getStampDutyLandTaxPercentage(incrementsVector.get(ii)), StampDuty.getStampDutyLandTax(incrementsVector.get(ii)))); 
                //stampDutytext.setText(ii+1 + ".    £" + Double.toString(incrementsVector.get(ii)) + "    " + StampDuty.getStampDutyLandTaxPercentage(incrementsVector.get(ii)) + "%    £" + StampDuty.getStampDutyLandTax(incrementsVector.get(ii)) );

          	 }
           

			
			
		} catch (Exception e) {
			Log.e(LOG_TAG, "onCreate() failed to start activity.", e);
			Toast.makeText(this, "No handler onCreate()" + e, Toast.LENGTH_LONG)
					.show();
		}
	}

}