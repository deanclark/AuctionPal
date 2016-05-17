/*
 * <b>Description:
 * 
 * To provide guidance to a potential property buyer given known monetary value or asking price of a 
 * property and using statistical information to provide a guide to the offer or bidding process.  
 * Basic mortgage calculator functionality will be provided with the addition of a historical 
 * comparison against similar properties within the same geographical location taking into account 
 * house price inflation will be used as a guide to maximum offer price.  
 * Rental income potential will be calculated using current interest rates, loan-to-value, monthly 
 * rental value and expected occupancy percentage.
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
 * The Class AuctionPalActivity.
 */
public class AuctionPalActivity extends Activity {

//	private AdView adView; 
	  
	/** The Constant LOG_TAG. */
	private static final String LOG_TAG = "AuctionPalActivity";

	/** The mortgage interest pcm. */
	static float mortgageInterestPCM = 0;
	// Test Property Class
	/** The new property. */
	static PropertyForSale newProperty = PropertyForSale.getInstance();

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

		//Remove title bar 
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		//Remove notification bar 
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// setContentView(R.layout.propertyforsale);
		//setContentView(R.layout.admob);
		setContentView(R.layout.res_layout_main);
		// setContentView(R.layout.offer_increments_suggestion);
		// setContentView(R.layout.main);

	    // Create the adView
//		final String MY_AD_UNIT_ID = getResources().getString(R.string.admob_unit_id); // AdMob publisher ID "a14d7f7d2180609";
		//adView = new AdView(this, AdSize.BANNER, MY_AD_UNIT_ID);  
		
	    // Lookup your LinearLayout assuming it’s been given     
		// the attribute android:id="@+id/mainLayout"     
		//LinearLayout layout = (LinearLayout)findViewById(R.id.ScrollViewResLayoutMain);
		
		// Add the adView to it     
		//layout.addView(adView);
		
		// Initiate a generic request to load it with an ad     
		//adView.loadAd(new AdRequest()); 
		
		
		updateCalculations();

		// Create Text Change Listeners for input editText boxes
		// editTextAskingPrice
		EditText askingPrice = (EditText) findViewById(R.id.editTextAskingPrice);
		askingPrice.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {// TODO Auto-generated
														// method stub
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) { // TODO Auto-generated method stub
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// update calculations using new data
				updateCalculations();
			}
		});

		// update stamp duty calculations when first time buyer checkbox changes
		CheckBox firstTimeBuyerFlag = (CheckBox) findViewById(R.id.checkBoxFirstTimeBuyer);
		firstTimeBuyerFlag
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// update stamp duty calculations when first time buyer
						// checkbox changes
						updateStampDuty();
					}
				});

		// update stamp duty calculations when disadvantaged Area checkbox
		// changes
		CheckBox disadvantagedAreaFlag = (CheckBox) findViewById(R.id.checkBoxDisadvantagedArea);
		disadvantagedAreaFlag
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// update stamp duty calculations when disadvantaged
						// area checkbox changes
						updateStampDuty();
					}
				});

		// Create Text Change Liteners for input editText boxes
		// editTextAskingPrice
		EditText loanToValuePercentage = (EditText) findViewById(R.id.editTextLoanToValuePercentage);
		loanToValuePercentage.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {// TODO Auto-generated
														// method stub
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) { // TODO Auto-generated method stub
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// update calculations using new data
				updateCalculations();
			}
		});

		// Create Text Change Liteners for input editText boxes
		// editTextAskingPrice
		EditText mortgageInterestRate = (EditText) findViewById(R.id.editTextMortgageInterestRate);
		mortgageInterestRate.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {// TODO Auto-generated
														// method stub
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) { // TODO Auto-generated method stub
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// update calculations using new data
				updateCalculations();
			}
		});
	}

//	  @Override   
//	  public void onDestroy() 
//	  {     
//		  if (adView != null) 
//		  {       
//			  adView.destroy();     
//		  }     
//	  super.onDestroy();   
//	  } 
	  
	  
	  
	// Use LTV to determine required deposit from asking price
	/**
	 * Update deposit value.
	 */
	public void updateDepositValue() {
		EditText askingPrice = (EditText) findViewById(R.id.editTextAskingPrice);
		EditText loanToValue = (EditText) findViewById(R.id.editTextLoanToValuePercentage);
		EditText depositValue = (EditText) findViewById(R.id.editTextDepositValue);

		float fAskingPrice = Float.parseFloat(askingPrice.getText().toString());
		float fLoanToValue = Float.parseFloat(loanToValue.getText().toString());
		float fDepositValue = 0; //

		if (fAskingPrice > 0 && fLoanToValue >= 0) {
			fDepositValue = Float.parseFloat(askingPrice.getText().toString())
					* (Float.parseFloat(loanToValue.getText().toString()) / 100);
			// depositValue.setText(Float.toString(fDepositValue));

			depositValue
					.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(
							7, 2) });
			depositValue.setText(String.format("%.2f", fDepositValue));
		}
	}

	// Use LTV to determine required loan amount relative to asking price
	/**
	 * Update mortgage loan value.
	 */
	public void updateMortgageLoanValue() {
		EditText askingPrice = (EditText) findViewById(R.id.editTextAskingPrice);
		EditText loanToValue = (EditText) findViewById(R.id.editTextLoanToValuePercentage);
		EditText depositValue = (EditText) findViewById(R.id.editTextDepositValue);
		EditText mortgageLoanValue = (EditText) findViewById(R.id.editTextMortgageLoanValue);

		float fAskingPrice = Float.parseFloat(askingPrice.getText().toString());
		float fLoanToValue = Float.parseFloat(loanToValue.getText().toString());
		float fDepositValue = Float.parseFloat(depositValue.getText()
				.toString());
		float fMortgageLoanValue = Float.parseFloat(mortgageLoanValue.getText()
				.toString());

		if (fAskingPrice > 0 && fLoanToValue >= 0) {
			fMortgageLoanValue = Float.parseFloat(askingPrice.getText()
					.toString()) - fDepositValue;
			// mortgageLoanValue.setText(Float.toString(fMortgageLoanValue));

			mortgageLoanValue
					.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(
							7, 2) });
			mortgageLoanValue
					.setText(String.format("%.2f", fMortgageLoanValue));
		}
	}

	// Determine monthly interest from loan amount and interest rate
	/**
	 * Update monthly interest.
	 */
	public void updateMonthlyInterest() {
		EditText mortgageLoanValue = (EditText) findViewById(R.id.editTextMortgageLoanValue);
		EditText mortgageInterestRate = (EditText) findViewById(R.id.editTextMortgageInterestRate);
		EditText monthlyInterest = (EditText) findViewById(R.id.editTextMonthlyInterest);

		float fMortgageLoanValue = Float.parseFloat(mortgageLoanValue.getText()
				.toString());
		float fMortgageInterestRate = Float.parseFloat(mortgageInterestRate
				.getText().toString());
		float fMonthlyInterest = 0;

		if (fMortgageLoanValue > 0 && fMortgageInterestRate > 0) {
			fMonthlyInterest = ((Float.parseFloat(mortgageLoanValue.getText()
					.toString()) / 100) * Float.parseFloat(mortgageInterestRate
					.getText().toString())) / 12;

			monthlyInterest.setText((Float.toString(fMonthlyInterest)));

			// NumberFormat currency = NumberFormat.getCurrencyInstance();
			// monthlyInterest.setText(currency.format(fMonthlyInterest));
			// monthlyInterest.setFilters(new InputFilters[] {new
			// DecimalDigitsInputFilter(5,2)});

			mortgageInterestPCM = fMonthlyInterest;

			monthlyInterest
					.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(
							7, 2) });
			monthlyInterest.setText(String.format("%.2f", mortgageInterestPCM));
		}
	}

	/**
	 * Update stamp duty cost and percentage.
	 */
	public void updateStampDuty() {
		CheckBox firstTimeBuyerFlag = (CheckBox) findViewById(R.id.checkBoxFirstTimeBuyer);
		CheckBox disadvantagedAreaFlag = (CheckBox) findViewById(R.id.checkBoxDisadvantagedArea);
		StampDuty.setFirstTimeBuyer(firstTimeBuyerFlag.isChecked());
		StampDuty.setDeprivedArea(disadvantagedAreaFlag.isChecked());
		EditText askingPrice = (EditText) findViewById(R.id.editTextAskingPrice);

		// prevent force close when asking price not set
		if (askingPrice.getText().toString().length() != 0)
		{
			double stampDutyDue = StampDuty.getStampDutyLandTax(Double
					.parseDouble(askingPrice.getText().toString()));
			TextView stampDutytext = (TextView) findViewById(R.id.textViewStampDutyLandTax);
	
			stampDutytext
					.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(7,
							2) });
			stampDutytext.setText(String.format(
					"Stamp Duty Land Tax  %.0f%%   £%.2f",
					StampDuty.getStampDutyLandTaxPercentage(Double
							.parseDouble(askingPrice.getText().toString())),
					stampDutyDue));
		}
	}

	/**
	 * Update calculations.
	 */
	public void updateCalculations() {
		EditText askingPrice = (EditText) findViewById(R.id.editTextAskingPrice);
		EditText loanToValue = (EditText) findViewById(R.id.editTextLoanToValuePercentage);
		EditText mortgageInterestRate = (EditText) findViewById(R.id.editTextMortgageInterestRate);
		CheckBox firstTimeBuyerFlag = (CheckBox) findViewById(R.id.checkBoxFirstTimeBuyer);
		CheckBox disadvantagedAreaFlag = (CheckBox) findViewById(R.id.checkBoxDisadvantagedArea);

		if (askingPrice.getText().toString().length() == 0)
			askingPrice.setError("Asking price is required!"); // Asking price
																// is required!

		else if (loanToValue.getText().toString().length() == 0)
			loanToValue.setError("LTV is required!"); // LTV is required!

		else if (mortgageInterestRate.getText().toString().length() == 0)
			mortgageInterestRate.setError("Interest Rate is required!"); // Interest
																			// rate
																			// is
																			// required!

		else {

			newProperty.setAskingPrice(Float.parseFloat(askingPrice.getText()
					.toString())); // TODO add input option to GUI
			StampDuty.setDeprivedArea(disadvantagedAreaFlag.isChecked()); // tickbox
																			// from
																			// GUI
			StampDuty.setFirstTimeBuyer(firstTimeBuyerFlag.isChecked()); // tickbox
																			// from
																			// GUI
			newProperty.setVendor(PropertyForSale.VendorType.privateOwned); // TODO
																			// remove
																			// hard
																			// code
			newProperty.setAgent(PropertyForSale.AgentType.agent); // TODO
																	// remove
																	// hard code
			// outputTextArea.append( "Property Info - vendor " +
			// newProperty.getVendorTypeName() + "\n" );
			// outputTextArea.append( "Asking Price: £" +
			// newProperty.getAskingPrice() + "  Maximum Offer: £" +
			// newProperty.getMaximumOffer() + "\n" );
			// outputTextArea.append( "Asking Price(Stamp Duty Land Tax): £" +
			// StampDuty.getStampDutyLandTax(newProperty.getAskingPrice()) +
			// "  Maximum Offer: £" +
			// StampDuty.getStampDutyLandTax(newProperty.getMaximumOffer()) +
			// "\n" );
			// outputTextArea.append( "FirstTimeBuyer: " +
			// (StampDuty.isFirstTimeBuyer() ? "YES" : "NO") +
			// "  Deprived Area : " + (StampDuty.isDisadvantagedArea() ? "YES" :
			// "NO") + "\n" );

			// update depositValue using LTV
			updateDepositValue();

			// update mortgageLoanValue using LTV
			updateMortgageLoanValue();

			// update monthly interest using new data
			updateMonthlyInterest();

			// update stamp duty cost and percentage
			updateStampDuty();

		}
	}

	/**
	 * Show offer increment panel.
	 * 
	 * @param button
	 *            the button
	 */
	public void showOfferIncrementPanel(View button) {
		try {

			Intent launchOfferIncrementFormActivity = new Intent(this,
					OfferIncrementFormActivity.class);
			// OfferIncrementFormActivity temp = new
			// OfferIncrementFormActivity();
			// launchOfferIncrementFormActivity.setClass((OfferIncrementFormActivity)
			// temp, OfferIncrementFormActivity.class);
			// launchOfferIncrementFormActivity.setClass((new
			// com.crystalwink.auctionpal.).new OfferIncrementFormActivity.this,
			// OfferIncrementFormActivity.class);
			startActivity(launchOfferIncrementFormActivity);
			// finish();

		} catch (Exception e) {
			Log.e(LOG_TAG,
					"showOfferIncrementPanel() failed to start activity.", e);
			Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
		}

	}

	/**
	 * Show rental information panel.
	 * 
	 * @param button
	 *            the button
	 */
	public void showRentalInformationPanel(View button) {
		try {

			Intent launchRentalInformationFormActivity = new Intent(this,
					RentalInformationFormActivity.class);
			startActivity(launchRentalInformationFormActivity);

		} catch (Exception e) {
			Log.e(LOG_TAG,
					"showRentalInformationPanel() failed to start activity.", e);
			Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
		}

	}

	/**
	 * Show property form panel.
	 * 
	 * @param button
	 *            the button
	 */
	public void showPropertyFormPanel(View button) {
		try {

			Intent launchPropertyFormActivity = new Intent(this,
					PropertyFormActivity.class);
			startActivity(launchPropertyFormActivity);

		} catch (Exception e) {
			Log.e(LOG_TAG, "showPropertyFormPanel() failed to start activity.",
					e);
			Toast.makeText(this, "No handler", Toast.LENGTH_LONG).show();
		}

	}
}