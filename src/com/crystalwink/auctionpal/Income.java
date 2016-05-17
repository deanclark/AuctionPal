/*
 * <b>Description:
 * @TODO Update description for Income.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Income.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * Description: Contains details of all sources of income including salary, rental income and other forms of income.
 *  
 * @author deancl
 *
 */
public class Income {
	
	/** The income pcm. */
	private double incomePcm = 750.00;  // income per calendar month
	
	/** The income annual. */
	private double incomeAnnual = 0;  // income per calendar month

    // The one and only this
    /** The _income. */
    private static Income _income = null;

    /** The income source list. */
    Vector<IncomeSource> incomeSourceList;


    /**
     * Singleton get instance.
     *
     * @return Income instance
     */
    public static Income getInstance()
    {
        if (_income == null)
        {
        	_income = new Income();
        }
        
        return _income;
    }

	/**
	 * Sets the income pcm.
	 *
	 * @param potentialIncomePcm the new income pcm
	 */
	public void setIncomePcm(double potentialIncomePcm) {
		this.incomePcm = potentialIncomePcm;
		setIncomeAnnual(incomePcm * 12);
	}

	/**
	 * Gets the income pcm.
	 *
	 * @return the income pcm
	 */
	public double getIncomePcm() {
		return incomePcm;
	}

	/**
	 * Sets the income annual.
	 *
	 * @param incomeAnnual the new income annual
	 */
	private void setIncomeAnnual(double incomeAnnual) {
		this.incomeAnnual = incomeAnnual;
	}

	/**
	 * Gets the income annual.
	 *
	 * @return the income annual
	 */
	public double getIncomeAnnual() {
		// TODO summation of all income sources
		incomeAnnual = 0;
		
		// size of search list
		for (int incomeIndex = 0; incomeIndex < incomeSourceList.size(); incomeIndex++) {
			incomeAnnual += incomeSourceList.get(incomeIndex).getsourceOfIncomeAnnual();
		}
		return incomeAnnual;
	}

	/**
	 * Delete all source of income.
	 */
	public void deleteAllSourceOfIncome() {
		incomeSourceList.removeAllElements();
	}

	/**
	 * Adds the source of income per annual.
	 *
	 * @param incomeSourceName the income source name
	 * @param annual the annual
	 */
	public void addSourceOfIncomePerAnnual(String incomeSourceName, double annual) {
		IncomeSource aNewSourceOfIncome = new IncomeSource(incomeSourceName);
		aNewSourceOfIncome.setsourceOfIncomeAnnual(annual);
		
		checkForInit();
		incomeSourceList.addElement(aNewSourceOfIncome);
	}

	/**
	 * Adds the source of income per monthly.
	 *
	 * @param incomeSourceName the income source name
	 * @param monthly the monthly
	 */
	public void addSourceOfIncomePerMonthly(String incomeSourceName, double monthly) {
		IncomeSource aNewSourceOfIncome = new IncomeSource(incomeSourceName);
		aNewSourceOfIncome.setsourceOfIncomeAnnual(monthly * 12);
		
		checkForInit();
		incomeSourceList.addElement(aNewSourceOfIncome);
	}

	/**
	 * Check for init.
	 */
	public void checkForInit() {
		if(incomeSourceList == null)
			incomeSourceList = new Vector<IncomeSource>();
	}
	
}
