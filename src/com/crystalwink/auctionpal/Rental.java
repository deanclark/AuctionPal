/*
 * <b>Description:
 * @TODO Update description for Rental.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Rental.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

// TODO: Auto-generated Javadoc
/**
 * The Class Rental.
 */
public class Rental {
	
	/** The potential income pcm. */
	private double potentialIncomePcm = 750.00;  // income per calendar month
	
	/** The rental cover. */
	private double rentalCover = 125; // 125% of mortgage repayments (source Halifax)
	
	/** The maximum repayment. */
	private double maximumRepayment = 0.0; // 120% of mortgage repayments

	/** The other buy to let properties. */
	private int    otherBuyToLetProperties = 0;   // maximum of 3 properties (Halifax)
	
	/** The maximum buy to let properties. */
	private int    maximumBuyToLetProperties = 3; // maximum 3 (Halifax)  
	
	/** The other buy to let comitments. */
	private double otherBuyToLetComitments = 0.0; // maximum £2M Halifax
	
	/** The maximum buy to let comitments. */
	private double maximumBuyToLetComitments = 2000000; // £2M Halifax over maximum of 3 properties 
	
    // The one and only this
    /** The _rental. */
    private static Rental _rental = null;
    
    /**
     * Singleton get instance.
     *
     * @return Rental instance
     */
    public static Rental getInstance()
    {
        if (_rental == null)
        {
        	_rental = new Rental();
        }
        return _rental;
    }

	/**
	 * Sets the potential income pcm.
	 *
	 * @param potentialIncomePcm the new potential income pcm
	 */
	public void setPotentialIncomePcm(double potentialIncomePcm) {
		this.potentialIncomePcm = potentialIncomePcm;
	}

	/**
	 * Gets the potential income pcm.
	 *
	 * @return the potential income pcm
	 */
	public double getPotentialIncomePcm() {
		return potentialIncomePcm;
	}

	/**
	 * Sets the rental cover.
	 *
	 * @param rentalCover the new rental cover
	 */
	public void setRentalCover(double rentalCover) {
		this.rentalCover = rentalCover;
		this.getMaximumRepayment();
	}

	/**
	 * Gets the rental cover.
	 *
	 * @return the rental cover
	 */
	public double getRentalCover() {
		return rentalCover;
	}

	/**
	 * Gets the maximum repayment.
	 *
	 * @return the maximum repayment
	 */
	public double getMaximumRepayment() {
		maximumRepayment = (this.getPotentialIncomePcm() / this.getRentalCover() ) * 100.0;
		return maximumRepayment;
	}

}
