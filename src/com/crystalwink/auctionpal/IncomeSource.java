/*
 * <b>Description:
 * @TODO Update description for IncomeSource.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           IncomeSource.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

// TODO: Auto-generated Javadoc
/**
 * The Class IncomeSource.
 */
public class IncomeSource {
	
	/** The source of income name. */
	private String sourceOfIncomeName;
	
	/** The source of income pcm. */
	private double sourceOfIncomePcm = 0.00;  // SourceOfIncome per calendar month
	
	/** The source of income annual. */
	private double sourceOfIncomeAnnual = 0.00;  // SourceOfIncome per calendar month

    // The one and only this
    /** The _source of income. */
    private static IncomeSource _sourceOfIncome = null;

    /**
     * Singleton get instance.
     *
     * @param name the name
     * @return SourceOfIncome instance
     */
    public IncomeSource(String name)
    {
    	sourceOfIncomeName   = name;
    }

	/**
	 * Sets the source of income pcm.
	 *
	 * @param sourceOfIncomePcm the new source of income pcm
	 */
	public void setSourceOfIncomePcm(double sourceOfIncomePcm) {
		this.sourceOfIncomePcm   = sourceOfIncomePcm;
		this.sourceOfIncomeAnnual = sourceOfIncomePcm * 12;
	}

	/**
	 * Gets the source of income pcm.
	 *
	 * @return the source of income pcm
	 */
	public double getSourceOfIncomePcm() {
		return sourceOfIncomePcm;
	}

	/**
	 * Sets the source of income annual.
	 *
	 * @param sourceOfIncomeAnnual the new source of income annual
	 */
	public void setsourceOfIncomeAnnual(double sourceOfIncomeAnnual) {
		this.sourceOfIncomeAnnual = sourceOfIncomeAnnual;
		this.sourceOfIncomePcm    = sourceOfIncomeAnnual / 12;
	}

	/**
	 * Gets the source of income annual.
	 *
	 * @return the source of income annual
	 */
	public double getsourceOfIncomeAnnual() {
		return sourceOfIncomeAnnual;
	}

	/**
	 * Sets the ssource of income name.
	 *
	 * @param sourceOfIncomeName the new ssource of income name
	 */
	public void setSsourceOfIncomeName(String sourceOfIncomeName) {
		this.sourceOfIncomeName = sourceOfIncomeName;
	}

	/**
	 * Gets the source of income name.
	 *
	 * @return the source of income name
	 */
	public String getsourceOfIncomeName() {
		return sourceOfIncomeName;
	}


}
