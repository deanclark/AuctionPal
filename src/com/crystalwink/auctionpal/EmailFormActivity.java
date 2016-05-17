/*
 * <b>Description:
 * @TODO Update description for EmailFormActivity.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           EmailFormActivity.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import com.crystalwink.auctionpal.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailFormActivity.
 */
public class EmailFormActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);  // hide application title
		
	}

	/**
	 * Send feedback.
	 *
	 * @param button the button
	 */
	public void sendFeedback(View button) {

		
		final EditText nameField = (EditText) findViewById(R.id.EditTextName);
		String name = nameField.getText().toString();
			
		final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
		String email = emailField.getText().toString();
		
		final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
		String feedback = feedbackField.getText().toString();
		
		final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
		String feedbackType = feedbackSpinner.getSelectedItem().toString();

		
		final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
		boolean bRequiresResponse = responseCheckbox.isChecked();

		// Take the fields and format the message contents
		String subject = formatFeedbackSubject(feedbackType);

		String message = formatFeedbackMessage(feedbackType, name,
			 email, feedback, bRequiresResponse);
		
		// Create the message
		sendFeedbackMessage(subject, message);
	}

	
	/**
	 * Format feedback subject.
	 *
	 * @param feedbackType the feedback type
	 * @return the string
	 */
	protected String formatFeedbackSubject(String feedbackType) {
		
		String strFeedbackSubjectFormat = getResources().getString(
				R.string.feedbackmessagesubject_format);

		String strFeedbackSubject = String.format(strFeedbackSubjectFormat, feedbackType);
		
		return strFeedbackSubject;

	}
	
	/**
	 * Format feedback message.
	 *
	 * @param feedbackType the feedback type
	 * @param name the name
	 * @param email the email
	 * @param feedback the feedback
	 * @param bRequiresResponse the b requires response
	 * @return the string
	 */
	protected String formatFeedbackMessage(String feedbackType, String name,
			String email, String feedback, boolean bRequiresResponse) {
		
		String strFeedbackFormatMsg = getResources().getString(
				R.string.feedbackmessagebody_format);

		String strRequiresResponse = getResponseString(bRequiresResponse);

		String strFeedbackMsg = String.format(strFeedbackFormatMsg,
				feedbackType, feedback, name, email, strRequiresResponse);
		
		return strFeedbackMsg;

	}
	

	/**
	 * Gets the response string.
	 *
	 * @param bRequiresResponse the b requires response
	 * @return the response string
	 */
	protected String getResponseString(boolean bRequiresResponse)
	{
		if(bRequiresResponse==true)
		{
			return getResources().getString(R.string.feedbackmessagebody_responseyes);
		} else {
			return getResources().getString(R.string.feedbackmessagebody_responseno);
		}
			
	}

	/**
	 * Send feedback message.
	 *
	 * @param subject the subject
	 * @param message the message
	 */
	public void sendFeedbackMessage(String subject, String message) {

		Intent messageIntent = new Intent(android.content.Intent.ACTION_SEND);

		String aEmailList[]    = { getResources().getString(R.string.email_address_bcc) };
        String aEmailBCCList[] = { getResources().getString(R.string.email_address_bcc) };

		messageIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
		messageIntent.putExtra(android.content.Intent.EXTRA_BCC,   aEmailBCCList);

		messageIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

		messageIntent.setType("plain/text");
		messageIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

		startActivity(messageIntent);
	}

}