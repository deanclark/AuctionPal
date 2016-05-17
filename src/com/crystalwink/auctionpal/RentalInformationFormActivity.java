/*
 * <b>Description:
 * @TODO Update description for RentalInformationFormActivity.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           RentalInformationFormActivity.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import com.crystalwink.auctionpal.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
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
 * The Class RentalInformationFormActivity.
 */
public class RentalInformationFormActivity extends Activity {
	
	/** The Constant LOG_TAG. */
	private static final String LOG_TAG = "RentalInformationFormActivity";
	
	/** The rent button. */
	private Button rentButton;
	 
	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.rental_income);
			//this.requestWindowFeature(Window.FEATURE_NO_TITLE);  // hide application title
			
			
//            this.rentButton = (Button)this.findViewById(R.id.button_rent_information);
//            this.rentButton.setOnClickListener(new OnClickListener() {
//			    @Override
//			    public void onClick(View v) {
//			      //finish();
//			    }
//			  });


	        updateRentCalculations();

	        // Create Text Change Listeners for input editText boxes
	        // editText_RentPCM
	        EditText rentPCM = (EditText)findViewById(R.id.editText_RentPCM);
	        rentPCM.addTextChangedListener(new TextWatcher()
	        {
	            public void afterTextChanged(Editable s) {// TODO Auto-generated method stub 
	            }
	            public void beforeTextChanged(CharSequence s, int start, int count, int after) { // TODO Auto-generated method stub
	            }
	            public void onTextChanged(CharSequence s, int start, int before, int count)
	            {
	                // update calculations using new data
	                updateRentCalculations();           
	            }
	        });

            // Create Text Change Listeners for input editText boxes
            // editText_RentPCM
            EditText rentalCover = (EditText)findViewById(R.id.editText_RentalCover);
            rentalCover.addTextChangedListener(new TextWatcher()
            {
                public void afterTextChanged(Editable s) {// TODO Auto-generated method stub 
                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { // TODO Auto-generated method stub
                }
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    // update calculations using new data
                    updateRentCalculations();           
                }
            });


		} catch (Exception e) {
			Log.e(LOG_TAG, "onCreate() failed to start activity.", e);
			Toast.makeText(this, "No handler onCreate() " + e, Toast.LENGTH_LONG).show();
		}
	}

    /**
     * Update updateRentCalculations.
     */
    public void updateRentCalculations() {
        EditText rentPCM  = (EditText)findViewById(R.id.editText_RentPCM);
        EditText mortgageRentalCover  = (EditText)findViewById(R.id.editText_RentalCover);
        
        if( rentPCM.getText().toString().length() == 0 )
            rentPCM.setError( "Rent PCM is required!" ); // Rent PCM is required!

        else if( mortgageRentalCover.getText().toString().length() == 0 )
            mortgageRentalCover.setError( "Rental Cover is required!" ); // Rental cover is required!
        
        else
        {
            // update RepaymentMax
            updateRepaymentMaxValue();
            
            // update IncomePotential
            updateIncomePotentialValue();
        }
    }

    /**
     * Update updateRepaymentMaxValue.
     */
    public void updateRepaymentMaxValue() {
        EditText rentPCM  = (EditText)findViewById(R.id.editText_RentPCM);
        EditText mortgageRentalCover  = (EditText)findViewById(R.id.editText_RentalCover);
        EditText mortgageRepaymentMax = (EditText)findViewById(R.id.editText_MortgageRepaymentMax);

        float fRentPCM  = Float.parseFloat(rentPCM.getText().toString());
        float fMortgageRentalCover  = Float.parseFloat(mortgageRentalCover.getText().toString());
        float fMortgageRepaymentMax = 0;  // 

        if(fRentPCM > 0 && fMortgageRentalCover >= 0)
        {
            fMortgageRepaymentMax = ((fRentPCM / fMortgageRentalCover) * 100 );
            //mortgageRepaymentMax.setText(Float.toString(fMortgageRepaymentMax));

            mortgageRepaymentMax.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(7, 2)}); 
            mortgageRepaymentMax.setText(String.format("%.2f", fMortgageRepaymentMax)); 
        }
    }
    

    /**
     * Update updateRepaymentMaxValue.
     */
    public void updateIncomePotentialValue() {
        EditText rentPCM  = (EditText)findViewById(R.id.editText_RentPCM);
        EditText mortgageRentalCover  = (EditText)findViewById(R.id.editText_RentalCover);
        EditText mortgageRepaymentMax = (EditText)findViewById(R.id.editText_MortgageRepaymentMax);
        EditText incomePotential = (EditText)findViewById(R.id.editText_IncomePotential);
        //EditText fOccupancy = (EditText)findViewById(R.id.editText_Occupancy);
        EditText monthlyInterest = (EditText)findViewById(R.id.editTextMonthlyInterest);

        float fRentPCM               = Float.parseFloat(rentPCM.getText().toString());
        float fMortgageRepaymentMax  = Float.parseFloat(mortgageRepaymentMax.getText().toString());
        float fmonthlyInterest       = AuctionPalActivity.mortgageInterestPCM; // Float.parseFloat(monthlyInterest.getText().toString());
        float fOccupancy             = 11;  // months per year occupied     
        float fIncomePotential       = 0;  // 

        if(fmonthlyInterest > 0 && fOccupancy  >= 0)   // TODO Add Occupancy months per year
        {
            fIncomePotential = ( (fRentPCM -  fmonthlyInterest ) * fOccupancy );
            //incomePotential.setText(Float.toString(fIncomePotential));

            incomePotential.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(7, 2)}); 
            incomePotential.setText(String.format("%.2f", fIncomePotential)); 
        }
        else
        {
            incomePotential.setError( "Check Property Details!" ); // Interest rate is required!
            incomePotential.setText("0");
        }
        
        // Todo: add a comment text string to explain rent from property page used to determine income rather than repaymentMax
    }
    


}