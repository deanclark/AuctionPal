/*
 * <b>Description:
 * @TODO Update description for Helper.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Helper.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */

package com.crystalwink.auctionpal;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Helper.
 */
public class Helper {
	
	/**
	 * Calculate Compound Interest given the following parameters.
	 *
	 * @param years the years
	 * @param rate the rate
	 * @param principal the principal
	 * @return vector of doubles payments over the number of years requested.
	 */
	public static Vector<Double> interest(int years, double rate, double principal)
	{
		Vector<Double> payments;
		payments = new Vector<Double>();
		
		double amount = 0.0;

		 for ( int year = 0; year <= years; year++ ) 
		 {
			 amount = principal * Math.pow( 1.0 + (rate / 100), year );
			 payments.add(amount);
			 
		 }

		return payments;
	}

	/**
	 * Interest annually.
	 *
	 * @param rate the rate
	 * @param principal the principal
	 * @return the double
	 */
	public static double interestAnnually(double rate, double principal)
	{
		double interestPerYear = principal * (rate / 100);
		
		return interestPerYear;
	}

	/**
	 * Interest monthly.
	 *
	 * @param rate the rate
	 * @param principal the principal
	 * @return the double
	 */
	public static double interestMonthly(double rate, double principal)
	{
		return (interestAnnually(rate, principal)) / 12 ;
	}
		
}
