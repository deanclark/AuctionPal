/*
 * <b>Description:
 * @TODO Update description for PropertyForSale.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           PropertyForSale.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.text.DecimalFormat;
import java.util.Vector;

// TODO: Auto-generated Javadoc
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;

/*
 * Google MapView http://code.google.com/android/add-ons/google-apis/mapkey.html	
 * 			tutorial: http://codemagician.wordpress.com/2010/05/06/android-google-mapview-tutorial-done-right/
 * use postcode to extract data from http://www.upmystreet.com/bs48-2eg.html
 */
/**
 * The Class PropertyForSale.
 */
public class PropertyForSale {

	/** The OFFE r_ percentag e_ privat e_ owne d_ start. */
	private final int OFFER_PERCENTAGE_PRIVATE_OWNED_START  = 90; // minimum offer 90%  of asking price
	
	/** The OFFE r_ percentag e_ privat e_ owne d_ end. */
	private final int OFFER_PERCENTAGE_PRIVATE_OWNED_END    = 100;  // maximum offer 100% of asking price
	
	/** The OFFE r_ percentag e_ ban k_ owne d_ start. */
	private final int OFFER_PERCENTAGE_BANK_OWNED_START     = 60; // minimum offer 60%  of asking price
	
	/** The OFFE r_ percentag e_ ban k_ owne d_ end. */
	private final int OFFER_PERCENTAGE_BANK_OWNED_END       = 85; // maximum offer 85%  of asking price
	
	/**
	 * The Enum VendorType.
	 */
	enum VendorType{
		
		/** The private owned. */
		privateOwned,
		
		/** The bank owned. */
		bankOwned
	}
	
	/** The vendor type names. */
	static String[] vendorTypeNames = {"privateOwned","bankOwned"};
	
	/**
	 * The Enum AgentType.
	 */
	enum AgentType{
		
		/** The agent. */
		agent,
		
		/** The auction. */
		auction,
		
		/** The privately. */
		privately
	}
	
	/** The vendor. */
	private VendorType vendor = VendorType.privateOwned;
	
	/** The agent. */
	private AgentType agent = AgentType.agent;
	
	/** The asking price. */
	private double askingPrice = 0.0; // Mandatory Field askingPrice or Guide(Auction)
	
	/** The address. */
	private String address = "property address";
	
	/** The name. */
	private String name = "enter a memerable name for this property";
	
	/** The renovation required. */
	private boolean renovationRequired = false;
	
	/** The renovation cost estimate. */
	private double renovationCostEstimate = 0.0;
	
	/** The value after renovation estimate. */
	private double valueAfterRenovationEstimate = 0.0;
	
	/** The number of beds. */
	private int numberOfBeds = 3;
	
	/** The number of baths. */
	private int numberOfBaths = 1;
	
	/** The number of wc. */
	private int numberOfWc = 0;
	
	/** The number of garage spaces. */
	private int numberOfGarageSpaces = 0;
	
	/** The number of off street parking spaces. */
	private int numberOfOffStreetParkingSpaces = 0;
	
	/** The gas central heating fitted. */
	private boolean gasCentralHeatingFitted = true;
	
	/** The free hold. */
	private boolean freeHold = true;
	
	/** The ground rent. */
	private double groundRent = 0.0;
	
	/** The council tax band. */
	private String councilTaxBand = "C";
	
	/** The council tax fee. */
	private double councilTaxFee = 1200.00;
	
    // The one and only this
    /** The _property. */
    private static PropertyForSale _property = null;
    
    /**
     * Singleton get instance.
     *
     * @return Property instance
     */
    public static PropertyForSale getInstance()
    {
        if (_property == null)
        {
            _property = new PropertyForSale();
        }
        return _property;
    }

	/**
	 * Sets the vendor.
	 *
	 * @param owner the new vendor
	 */
	public void setVendor(VendorType owner) {
		this.vendor = owner;
	}

	/**
	 * Gets the vendor.
	 *
	 * @return the vendor
	 */
	public VendorType getVendor() {
		return vendor;
	}

	/**
	 * Sets the agent.
	 *
	 * @param agent the new agent
	 */
	public void setAgent(AgentType agent) {
		this.agent = agent;
	}

	/**
	 * Gets the agent.
	 *
	 * @return the agent
	 */
	public AgentType getAgent() {
		return agent;
	}

	/**
	 * Gets the vendor type name.
	 *
	 * @return the vendor type name
	 */
	public String getVendorTypeName() {
		return vendorTypeNames[getVendor().ordinal()];
	}

	/**
	 * Sets the asking price.
	 *
	 * @param askingPrice the new asking price
	 */
	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}

	/**
	 * Gets the asking price.
	 *
	 * @return the asking price
	 */
	public double getAskingPrice() {
		return askingPrice;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the renovation required.
	 *
	 * @param renovationRequired the new renovation required
	 */
	public void setRenovationRequired(boolean renovationRequired) {
		this.renovationRequired = renovationRequired;
	}

	/**
	 * Checks if is renovation required.
	 *
	 * @return true, if is renovation required
	 */
	public boolean isRenovationRequired() {
		return renovationRequired;
	}

	/**
	 * Sets the renovation cost estimate.
	 *
	 * @param renovationCostEstimate the new renovation cost estimate
	 */
	public void setRenovationCostEstimate(double renovationCostEstimate) {
		this.renovationCostEstimate = renovationCostEstimate;
	}

	/**
	 * Gets the renovation cost estimate.
	 *
	 * @return the renovation cost estimate
	 */
	public double getRenovationCostEstimate() {
		if(isRenovationRequired())
			return renovationCostEstimate;
		else
			return 0.0;
	}

	/**
	 * Sets the value after renovation estimate.
	 *
	 * @param valueAfterRenovationEstimate the new value after renovation estimate
	 */
	public void setValueAfterRenovationEstimate(double valueAfterRenovationEstimate) {
		this.valueAfterRenovationEstimate = valueAfterRenovationEstimate;
	}

	/**
	 * Gets the value after renovation estimate.
	 *
	 * @return the value after renovation estimate
	 */
	public double getValueAfterRenovationEstimate() {
		return valueAfterRenovationEstimate;
	}

	/**
	 * Sets the number of beds.
	 *
	 * @param numberOfBeds the new number of beds
	 */
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	/**
	 * Gets the number of beds.
	 *
	 * @return the number of beds
	 */
	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	/**
	 * Sets the number of baths.
	 *
	 * @param numberOfBaths the new number of baths
	 */
	public void setNumberOfBaths(int numberOfBaths) {
		this.numberOfBaths = numberOfBaths;
	}

	/**
	 * Gets the number of baths.
	 *
	 * @return the number of baths
	 */
	public int getNumberOfBaths() {
		return numberOfBaths;
	}

	/**
	 * Sets the number of wc.
	 *
	 * @param numberOfWc the new number of wc
	 */
	public void setNumberOfWc(int numberOfWc) {
		this.numberOfWc = numberOfWc;
	}

	/**
	 * Gets the number of wc.
	 *
	 * @return the number of wc
	 */
	public int getNumberOfWc() {
		return numberOfWc;
	}

	/**
	 * Sets the number of garage spaces.
	 *
	 * @param numberOfGarageSpaces the new number of garage spaces
	 */
	public void setNumberOfGarageSpaces(int numberOfGarageSpaces) {
		this.numberOfGarageSpaces = numberOfGarageSpaces;
	}

	/**
	 * Gets the number of garage spaces.
	 *
	 * @return the number of garage spaces
	 */
	public int getNumberOfGarageSpaces() {
		return numberOfGarageSpaces;
	}

	/**
	 * Sets the number of off street parking spaces.
	 *
	 * @param numberOfOffStreetParkingSpaces the new number of off street parking spaces
	 */
	public void setNumberOfOffStreetParkingSpaces(
			int numberOfOffStreetParkingSpaces) {
		this.numberOfOffStreetParkingSpaces = numberOfOffStreetParkingSpaces;
	}

	/**
	 * Gets the number of off street parking spaces.
	 *
	 * @return the number of off street parking spaces
	 */
	public int getNumberOfOffStreetParkingSpaces() {
		return numberOfOffStreetParkingSpaces;
	}

	/**
	 * Sets the gas central heating fitted.
	 *
	 * @param gasCentralHeatingFitted the new gas central heating fitted
	 */
	public void setGasCentralHeatingFitted(boolean gasCentralHeatingFitted) {
		this.gasCentralHeatingFitted = gasCentralHeatingFitted;
	}

	/**
	 * Checks if is gas central heating fitted.
	 *
	 * @return true, if is gas central heating fitted
	 */
	public boolean isGasCentralHeatingFitted() {
		return gasCentralHeatingFitted;
	}

	/**
	 * Sets the free hold.
	 *
	 * @param freeHold the new free hold
	 */
	public void setFreeHold(boolean freeHold) {
		this.freeHold = freeHold;
	}

	/**
	 * Checks if is free hold.
	 *
	 * @return true, if is free hold
	 */
	public boolean isFreeHold() {
		return freeHold;
	}

	/**
	 * Sets the ground rent.
	 *
	 * @param groundRent the new ground rent
	 */
	public void setGroundRent(double groundRent) {
		this.groundRent = groundRent;
	}

	/**
	 * Gets the ground rent.
	 *
	 * @return the ground rent
	 */
	public double getGroundRent() {
		return groundRent;
	}

	/**
	 * Sets the council tax band.
	 *
	 * @param councilTaxBand the new council tax band
	 */
	public void setCouncilTaxBand(String councilTaxBand) {
		this.councilTaxBand = councilTaxBand;
	}

	/**
	 * Gets the council tax band.
	 *
	 * @return the council tax band
	 */
	public String getCouncilTaxBand() {
		return councilTaxBand;
	}

	/**
	 * Sets the council tax fee.
	 *
	 * @param councilTaxFee the new council tax fee
	 */
	public void setCouncilTaxFee(double councilTaxFee) {
		this.councilTaxFee = councilTaxFee;
	}

	/**
	 * Gets the council tax fee.
	 *
	 * @return the council tax fee
	 */
	public double getCouncilTaxFee() {
		return councilTaxFee;
	}	

	/**
	 * Gets the maximum offer.
	 *
	 * @return the maximum offer
	 */
	public double getMaximumOffer() {

		double maximumOffer = askingPrice * ((double) OFFER_PERCENTAGE_PRIVATE_OWNED_END / 100);
		
		if(vendor == VendorType.bankOwned)
		{
			maximumOffer = askingPrice * ((double) OFFER_PERCENTAGE_BANK_OWNED_END / 100);      // end at 85% of asking for bank owned (repo) properties
		}

		return maximumOffer;
	}	

	/**
	 * getRecomendedOfferIncrements provides a vector list of recommended offer amounts dependent on the current vendor/owner
	 * Bank owned property, offers in the range 60% to 85% of asking price.
	 * Privately owned property , offers in the range 90% to 100% of asking price.
	 * The numberOfIncrements can be specified but the recommended default is 4 offers.
	 *
	 * @param numberOfIncrements the number of increments
	 * @param offerIncrementLogicLinear evenly spaced increments, or descending step size as approaches final offer.
	 * @return Vector of doubles
	 */
	public Vector<Double> getRecomendedOfferIncrements(int numberOfIncrements, boolean offerIncrementLogicLinear) {

		Vector<Double> incrementsVector;
		incrementsVector = new Vector<Double>();

        double offerPrice = 0.0;
        double previousOfferPrice = 0.0;
		
		double offerRangeStart = OFFER_PERCENTAGE_PRIVATE_OWNED_START;  // start at 90% of asking
		double offerRangeEnd   = OFFER_PERCENTAGE_PRIVATE_OWNED_END;    // end   at 100% of asking
		if(vendor == VendorType.bankOwned)
		{
			offerRangeStart = OFFER_PERCENTAGE_BANK_OWNED_START;    // start at 60% of asking for bank owned (repo) properties
			offerRangeEnd   = OFFER_PERCENTAGE_BANK_OWNED_END;      // end   at 85% of asking for bank owned (repo) properties
		}
		
		double percentageOfferRange = (offerRangeEnd - offerRangeStart);  // (85% - 60%) = 25% or 100% - 90% if privately owned
		double percentageIncrementsIinear = percentageOfferRange / (numberOfIncrements - 1);  // (85% - 60%) = 25% or 100% - 90% if privately owned
		
		double incrementalPercentage = 0;  // init

		double deviser = percentageOfferRange / 2.5;  // 10%(4) 25%(10)
		
		// e.g. Offer1 = 90%(0), Offer2 94%(4), Offer3 96%(2), Offer4 97%(1), Offer5 97.5(0.5)
		for(int increment=0; increment<numberOfIncrements; increment++)
		{
			if(increment!= 0)
				incrementalPercentage = incrementalPercentage + (deviser / increment);
				
			if(offerIncrementLogicLinear == true)
				offerPrice = (askingPrice * (offerRangeStart / 100)) + (askingPrice * ((percentageIncrementsIinear * increment) / 100));
			else
				offerPrice = (askingPrice * (offerRangeEnd / 100)) + (askingPrice * ((incrementalPercentage - percentageOfferRange) / 100));
			
			if(offerPrice <= (askingPrice * (offerRangeEnd / 100)))
			{
			    // add an offer amount on the Stamp Duty Threshold if it has been crossed.
			    if( (increment != 0) && (Math.abs(offerPrice - StampDuty.stampDutyLandTaxThresholdCrossed(previousOfferPrice,offerPrice))  < .0000001 )  )
			    {
	                incrementsVector.add(StampDuty.stampDutyLandTaxThresholdCrossed(previousOfferPrice, offerPrice));
			    }
                incrementsVector.add(offerPrice);
			}
			
			// save for next iteration
			previousOfferPrice = offerPrice;
		}
		
		return incrementsVector;
	}	
}
