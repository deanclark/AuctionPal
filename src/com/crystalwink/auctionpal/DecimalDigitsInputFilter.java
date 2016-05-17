/*
 * <b>Description:
 * @TODO Update description for DecimalDigitsInputFilter.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           DecimalDigitsInputFilter.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.InputFilter;
import android.text.Spanned;

// TODO: Auto-generated Javadoc
/**
 * The Class DecimalDigitsInputFilter.
 */
public class DecimalDigitsInputFilter implements InputFilter { 
	 
	/** The m pattern. */
	Pattern mPattern; 
	 
	/**
	 * Instantiates a new decimal digits input filter.
	 *
	 * @param digitsBeforeZero the digits before zero
	 * @param digitsAfterZero the digits after zero
	 */
	public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) { 
	    mPattern=Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?"); 
	} 
	 
//	@Override 
//	public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) { 
//	 
//	        Matcher matcher=mPattern.matcher(dest);        
//	        if(!matcher.matches()) 
//	            return ""; 
//	        return null; 
//	    }

	/* (non-Javadoc)
 * @see android.text.InputFilter#filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int)
 */
@Override
	public CharSequence filter(CharSequence arg0, int arg1, int arg2, Spanned arg3, int arg4, int arg5) {
        Matcher matcher=mPattern.matcher(arg3);        
        if(!matcher.matches()) 
            return ""; 
		return null;
	} 
	 
	} 

