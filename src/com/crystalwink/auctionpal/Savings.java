/*
 * <b>Description:
 * @TODO Update description for Savings.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Savings.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Savings.
 */
public class Savings {
	
	/** The savings total. */
	private double savingsTotal = 0;  // savings per calendar month

    // The one and only this
    /** The _savings. */
    private static Savings _savings = null;

    /** The savings source list. */
    Vector<SavingsSource> savingsSourceList;


    /**
     * Singleton get instance.
     *
     * @return Savings instance
     */
    public static Savings getInstance()
    {
        if (_savings == null)
        {
        	_savings = new Savings();
        }

        return _savings;
    }


	/**
	 * Sets the savings total.
	 *
	 * @param savingsTotal the new savings total
	 */
	private void setSavingsTotal(double savingsTotal) {
		this.savingsTotal = savingsTotal;
	}

	/**
	 * Gets the savings total.
	 *
	 * @return the savings total
	 */
	public double getSavingsTotal() {
		// TODO summation of all savings sources
		savingsTotal = 0;

		// size of search list
		for (int savingsIndex = 0; savingsIndex < savingsSourceList.size(); savingsIndex++) {
			savingsTotal += savingsSourceList.get(savingsIndex).getSourceOfSavingsAmount();
		}
		return savingsTotal;
	}

	/**
	 * Delete all source of savings.
	 */
	public void deleteAllSourceOfSavings() {
		savingsSourceList.removeAllElements();
	}

	/**
	 * Adds the source of savings.
	 *
	 * @param savingsSourceName the savings source name
	 * @param savingsAmount the savings amount
	 */
	public void addSourceOfSavings(String savingsSourceName, double savingsAmount) {
		SavingsSource aNewSourceOfSavings = new SavingsSource(savingsSourceName);
		aNewSourceOfSavings.setSourceOfSavingsAmount(savingsAmount);

		checkForInit();
		savingsSourceList.addElement(aNewSourceOfSavings);
	}


	/**
	 * Check for init.
	 */
	public void checkForInit() {
		if(savingsSourceList == null)
			savingsSourceList = new Vector<SavingsSource>();
	}

	/**
	 * Gets the savings by name.
	 *
	 * @param savingsName the savings name
	 * @return the savings by name
	 */
	public SavingsSource getSavingsByName(String savingsName) {
		// size of search list
		for (int savingsIndex = 0; savingsIndex < savingsSourceList.size(); savingsIndex++) {
			if(savingsSourceList.get(savingsIndex).getsourceOfSavingsName().equalsIgnoreCase(savingsName))
				return savingsSourceList.get(savingsIndex);
		}
		return null;
	}


}
