/*
 * <b>Description:
 * @TODO Update description for SavingsSource.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           SavingsSource.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

// TODO: Auto-generated Javadoc
/**
 * The Class SavingsSource.
 */
public class SavingsSource {
	
	/** The source of savings name. */
	private String sourceOfSavingsName;
	
	/** The source of savings amount. */
	private double sourceOfSavingsAmount = 0.00;  // Savings Source Total

    // The one and only this
    /** The _source of savings. */
    private static SavingsSource _sourceOfSavings = null;

    /**
     * Singleton get instance.
     *
     * @param name the name
     * @return SourceOfIncome instance
     */
    public SavingsSource(String name)
    {
    	sourceOfSavingsName   = name;
    }

	/**
	 * Sets the source of savings amount.
	 *
	 * @param sourceOfSavingsAmount the new source of savings amount
	 */
	public void setSourceOfSavingsAmount(double sourceOfSavingsAmount) {
		this.sourceOfSavingsAmount   = sourceOfSavingsAmount;
	}

	/**
	 * Gets the source of savings amount.
	 *
	 * @return the source of savings amount
	 */
	public double getSourceOfSavingsAmount() {
		return sourceOfSavingsAmount;
	}

	/**
	 * Sets the ssource of savings name.
	 *
	 * @param sourceOfSavingsName the new ssource of savings name
	 */
	public void setSsourceOfSavingsName(String sourceOfSavingsName) {
		this.sourceOfSavingsName = sourceOfSavingsName;
	}

	/**
	 * Gets the source of savings name.
	 *
	 * @return the source of savings name
	 */
	public String getsourceOfSavingsName() {
		return sourceOfSavingsName;
	}


}
