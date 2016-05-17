/*
 * <b>Description:
 * @TODO Update description for Properties.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Properties.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Properties.
 */
public class Properties {
	
	/** The properties total value. */
	private double propertiesTotalValue        = 0.00;  // sum of all properties value
	
	/** The properties total loan. */
	private double propertiesTotalLoan         = 0;     // sum of all properties loan value
	
	/** The properties total loan to value. */
	private double propertiesTotalLoanToValue  = 0;     // sum of all properties loan value

    // The one and only this
    /** The _properties. */
    private static Properties _properties = null;

    /** The properties list. */
    Vector<PropertyInHand> propertiesList;


    /**
     * Singleton get instance.
     *
     * @return Properties instance
     */
    public static Properties getInstance()
    {
        if (_properties == null)
        {
        	_properties = new Properties();
        }

        return _properties;
    }

    /**
     * Sets the properties total loan.
     *
     * @param combinedPropertiesTotalLoan the new properties total loan
     */
    private void setPropertiesTotalLoan(double combinedPropertiesTotalLoan) {
		this.propertiesTotalLoan = combinedPropertiesTotalLoan;
	}

	/**
	 * Gets the properties total loan.
	 *
	 * @return the properties total loan
	 */
	public double getPropertiesTotalLoan() {
		// TODO summation of all properties sources
		propertiesTotalLoan = 0;

		// size of search list
		for (int propertiesIndex = 0; propertiesIndex < propertiesList.size(); propertiesIndex++) {
			propertiesTotalLoan += propertiesList.get(propertiesIndex).getpropertyInHandLoanRemaining();
		}
		return propertiesTotalLoan;
	}

	/**
	 * Sets the properties total value.
	 *
	 * @param combinedPropertiesValue the new properties total value
	 */
	private void setPropertiesTotalValue(double combinedPropertiesValue) {
		this.propertiesTotalValue = combinedPropertiesValue;
	}

	/**
	 * Gets the properties total value.
	 *
	 * @return the properties total value
	 */
	public double getPropertiesTotalValue() {
		// TODO summation of all properties sources
		propertiesTotalValue = 0;

		// size of search list
		for (int propertiesIndex = 0; propertiesIndex < propertiesList.size(); propertiesIndex++) {
			propertiesTotalValue += propertiesList.get(propertiesIndex).getPropertyInHandValue();
		}
		return propertiesTotalValue;
	}

	
	/**
	 * Gets the properties total loan to value.
	 *
	 * @return the properties total loan to value
	 */
	public double getPropertiesTotalLoanToValue() {
		return (100 / (getPropertiesTotalValue()  / getPropertiesTotalLoan()));
	}
	
	/**
	 * Gets the properties total deposit potential.
	 *
	 * @return the properties total deposit potential
	 */
	public double getPropertiesTotalDepositPotential()
	{
		// assume 90% LTV,
		if( getPropertiesTotalLoanToValue() < 90)
			return ( (getPropertiesTotalValue() / 100) * (90 - getPropertiesTotalLoanToValue()) );  // total / 100 * (remaining LTV)
		else
			return 0;
		
	}

	/**
	 * Delete all source of properties.
	 */
	public void deleteAllSourceOfProperties() {
		propertiesList.removeAllElements();
	}

	/**
	 * Adds the property to list.
	 *
	 * @param propertyName the property name
	 * @param propertyInHandValue the property in hand value
	 */
	public void addPropertyToList(String propertyName, double propertyInHandValue) {
		PropertyInHand aNewProperty = new PropertyInHand(propertyName);
		aNewProperty.setPropertyInHandValue(propertyInHandValue);

		checkForInit();
		propertiesList.addElement(aNewProperty);
	}

	/**
	 * Gets the property by name.
	 *
	 * @param propertyName the property name
	 * @return the property by name
	 */
	public PropertyInHand getPropertyByName(String propertyName) {
		// size of search list
		for (int propertiesIndex = 0; propertiesIndex < propertiesList.size(); propertiesIndex++) {
			if(propertiesList.get(propertiesIndex).getpropertyInHandName().equalsIgnoreCase(propertyName))
				return propertiesList.get(propertiesIndex);
		}
		return null;
	}

	/**
	 * Check for init.
	 */
	public void checkForInit() {
		if(propertiesList == null)
			propertiesList = new Vector<PropertyInHand>();
	}

}
