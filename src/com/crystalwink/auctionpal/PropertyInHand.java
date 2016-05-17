/*
 * <b>Description:
 * @TODO Update description for PropertyInHand.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           PropertyInHand.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyInHand.
 */
public class PropertyInHand {
	
	/** The property in hand name. */
	private String propertyInHandName             = "Barrs Court";	// e.g. "Home"
	
	/** The property in hand value. */
	private double propertyInHandValue            = 0.00;  // PropertyInHand Value (estimated)
	
	/** The property in hand loan remaining. */
	private double propertyInHandLoanRemaining    = 0.00;  // PropertyInHand Mortgage Loan Remaining
	
	/** The property in hand term remaining. */
	private double propertyInHandTermRemaining    = 0.00;  // PropertyInHand Mortgage Term Remaining
	
	/** The property in hand loan type. */
	private double propertyInHandLoanType         = 0;     // PropertyInHand Mortgage Type
	
	/** The property in hand loan int rate. */
	private double propertyInHandLoanIntRate      = 0.0;   // PropertyInHand Mortgage Interest Rate
	
	/** The property in hand loan to value. */
	private double propertyInHandLoanToValue      = 0.0;   // PropertyInHand Mortgage Interest Rate
	
	/** The property in hand deposit potential. */
	private double propertyInHandDepositPotential = 0.0;   // PropertyInHand Mortgage Interest Rate


    // The one and only this
    /** The _property in hand. */
    private static PropertyInHand _propertyInHand = null;

    /**
     * Singleton get instance.
     *
     * @param name the name
     * @return PropertyInHand instance
     */
    public PropertyInHand(String name)
    {
    	propertyInHandName   = name;
    }

	/**
	 * Sets the property in hand value.
	 *
	 * @param propertyInHandValue the new property in hand value
	 */
	public void setPropertyInHandValue(double propertyInHandValue) {
		this.propertyInHandValue   = propertyInHandValue;
	}

	/**
	 * Gets the property in hand value.
	 *
	 * @return the property in hand value
	 */
	public double getPropertyInHandValue() {
		return propertyInHandValue;
	}

	/**
	 * Sets the property in hand loan remaining.
	 *
	 * @param propertyInHandLoanRemaining the new property in hand loan remaining
	 */
	public void setpropertyInHandLoanRemaining(double propertyInHandLoanRemaining) {
		this.propertyInHandLoanRemaining = propertyInHandLoanRemaining;
	}

	/**
	 * Gets the property in hand loan remaining.
	 *
	 * @return the property in hand loan remaining
	 */
	public double getpropertyInHandLoanRemaining() {
		return propertyInHandLoanRemaining;
	}

	/**
	 * Sets the sproperty in hand name.
	 *
	 * @param propertyInHandName the new sproperty in hand name
	 */
	public void setSpropertyInHandName(String propertyInHandName) {
		this.propertyInHandName = propertyInHandName;
	}

	/**
	 * Gets the property in hand name.
	 *
	 * @return the property in hand name
	 */
	public String getpropertyInHandName() {
		return propertyInHandName;
	}

	/**
	 * Sets the property in hand term remaining.
	 *
	 * @param propertyInHandTermRemaining the new property in hand term remaining
	 */
	public void setPropertyInHandTermRemaining(double propertyInHandTermRemaining) {
		this.propertyInHandTermRemaining = propertyInHandTermRemaining;
	}

	/**
	 * Gets the property in hand term remaining.
	 *
	 * @return the property in hand term remaining
	 */
	public double getPropertyInHandTermRemaining() {
		return propertyInHandTermRemaining;
	}

	/**
	 * Sets the property in hand loan type.
	 *
	 * @param propertyInHandLoanType the new property in hand loan type
	 */
	public void setPropertyInHandLoanType(double propertyInHandLoanType) {
		this.propertyInHandLoanType = propertyInHandLoanType;
	}

	/**
	 * Gets the property in hand loan type.
	 *
	 * @return the property in hand loan type
	 */
	public double getPropertyInHandLoanType() {
		return propertyInHandLoanType;
	}

	/**
	 * Sets the property in hand loan int rate.
	 *
	 * @param propertyInHandLoanIntRate the new property in hand loan int rate
	 */
	public void setPropertyInHandLoanIntRate(double propertyInHandLoanIntRate) {
		this.propertyInHandLoanIntRate = propertyInHandLoanIntRate;
	}

	/**
	 * Gets the property in hand loan int rate.
	 *
	 * @return the property in hand loan int rate
	 */
	public double getPropertyInHandLoanIntRate() {
		return propertyInHandLoanIntRate;
	}

	/**
	 * Sets the property in hand loan to value.
	 *
	 * @param propertyInHandLoanToValue the new property in hand loan to value
	 */
	public void setPropertyInHandLoanToValue(double propertyInHandLoanToValue) {
		this.propertyInHandLoanToValue = propertyInHandLoanToValue;
	}

	/**
	 * Gets the property in hand loan to value.
	 *
	 * @return the property in hand loan to value
	 */
	public double getPropertyInHandLoanToValue() {
		return propertyInHandLoanToValue;
	}

	/**
	 * Sets the property in hand deposit potential.
	 *
	 * @param propertyInHandDepositPotential the new property in hand deposit potential
	 */
	public void setPropertyInHandDepositPotential(
			double propertyInHandDepositPotential) {
		this.propertyInHandDepositPotential = propertyInHandDepositPotential;
	}

	/**
	 * Gets the property in hand deposit potential.
	 *
	 * @return the property in hand deposit potential
	 */
	public double getPropertyInHandDepositPotential() {
		return propertyInHandDepositPotential;
	}


}
