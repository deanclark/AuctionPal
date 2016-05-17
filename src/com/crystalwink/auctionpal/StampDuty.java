/*
 * <b>Description:
 * @TODO Update description for StampDuty.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           StampDuty.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;


// TODO: Auto-generated Javadoc
/**
 * The Class StampDuty.
 *
 * @author dclark
 * 
 * 
 * Extract from Direct.gov http://www.direct.gov.uk/en/MoneyTaxAndBenefits/Taxes/TaxOnPropertyAndRentalIncome/DG_4015918
 * 
 * First-time buyers
 * If you are a first-time buyer the threshold for when you start to pay SDLT is £250,000.
 * This is only if you have never owned a house or flat in the UK or anywhere else in the world.
 * If you are buying with someone else they must never have owned property before either.
 * This higher threshold applies to purchases completed on or after 25 March 2010 and before 25 March 2012.
 * 
 * Purchase price of residential property      |  Rate of SDLT (percentage of the total purchase price)     |   Rate of SDLT - first-time buyers (percentage of the total purchase price)
 * £0 - £125,000		                       | 0%                        | 0%
 * £125,001 - £250,000	                       | 1%	                       | 0%
 * £250,001 - £500,000	                       | 3%	                       | 3%
 * £500,001 - £1 million	                   | 4%	                   	   | 4%
 * £1 million or more	                       | 5%	                       | 5%
 */
public class StampDuty
{
    
    /** The STAM p_ dut y_ holiday. */
    static boolean STAMP_DUTY_HOLIDAY         = false;  // applies to purchases completed on or after 25 March 2010 and before 25 March 2012.

    /** The THRESHOL d_ one. */
    static double THRESHOLD_ONE               = 125000;
    
    /** The THRESHOL d_ on e_ disadvantaged. */
    static double THRESHOLD_ONE_DISADVANTAGED = 150000; // see isDisadvantagedArea Area 150,000;
    
    /** The THRESHOL d_ two. */
    static double THRESHOLD_TWO               = 250000;
    
    /** The THRESHOL d_ three. */
    static double THRESHOLD_THREE             = 500000;
    
    /** The THRESHOL d_ four. */
    static double THRESHOLD_FOUR              = 1000000;
    
    /** The PERCENTAG e_ zero. */
    static double PERCENTAGE_ZERO  = 0;
    
    /** The PERCENTAG e_ one. */
    static double PERCENTAGE_ONE   = 1;  // TODO First time buyer rate 0% up to 250K until 24th March 2012 
    
    /** The PERCENTAG e_ two. */
    static double PERCENTAGE_TWO   = 3;
    
    /** The PERCENTAG e_ three. */
    static double PERCENTAGE_THREE = 4;
    
    /** The PERCENTAG e_ four. */
    static double PERCENTAGE_FOUR  = 5;
    
    /** The disadvantaged area. */
    private static boolean disadvantagedArea = false;
    
    /** The first time buyer. */
    private static boolean firstTimeBuyer = false;
    
    // Rates as of 1st Sept 2011
    //    <150,000         = 0
    //    150000-250000    = 1
    //    250000-500000    = 3
    //    500000-1,000,000 = 4
    //    1,000,000+       = 5
    
    /**
     * Gets the stamp duty land tax percentage.
     *
     * @param purchasePrice the purchase price
     * @return the stamp duty land tax percentage
     */
    public static double getStampDutyLandTaxPercentage(double purchasePrice)
    {
        double percentage = PERCENTAGE_ZERO;
        
        if(purchasePrice <= THRESHOLD_ONE)
            percentage = PERCENTAGE_ZERO;
        
        else if(purchasePrice <= THRESHOLD_ONE_DISADVANTAGED && isDisadvantagedArea())
            percentage = PERCENTAGE_ZERO;
        
        else if(purchasePrice <= THRESHOLD_TWO)
        {
            percentage = PERCENTAGE_ONE;
            
            if(isFirstTimeBuyer() && STAMP_DUTY_HOLIDAY)
                percentage = PERCENTAGE_ZERO;
        }
        else if(purchasePrice <= THRESHOLD_THREE)
            percentage = PERCENTAGE_TWO;
        else if(purchasePrice <= THRESHOLD_FOUR)
            percentage = PERCENTAGE_THREE;
        else
            percentage = PERCENTAGE_FOUR;
            
        return percentage;
    }

    /**
     * Gets the stamp duty land tax threshold.
     *
     * @param percentage the percentage
     * @return the stamp duty land tax threshold
     */
    public static double getStampDutyLandTaxThreshold(double percentage)
    {
        double thresholdPrice = 0;
        
        if(percentage == PERCENTAGE_FOUR)
            thresholdPrice = THRESHOLD_FOUR;
        else if(percentage == PERCENTAGE_THREE)
            thresholdPrice = THRESHOLD_THREE;
        else if(percentage == PERCENTAGE_TWO)
            thresholdPrice = THRESHOLD_TWO;
        else if(percentage == PERCENTAGE_ONE)
        {
            if(isFirstTimeBuyer() && STAMP_DUTY_HOLIDAY)
                thresholdPrice = THRESHOLD_TWO;
            else
                if(isDisadvantagedArea())
                    thresholdPrice = THRESHOLD_ONE_DISADVANTAGED;
                else
                    thresholdPrice = THRESHOLD_ONE;
        }
            
        return thresholdPrice;
    }

    /**
     * Gets the stamp duty land tax.
     *
     * @param purchasePrice the purchase price
     * @return the stamp duty land tax
     */
    public static double getStampDutyLandTax(double purchasePrice)
    {
        double duty = 0;
            
        duty = purchasePrice * (getStampDutyLandTaxPercentage(purchasePrice)/100);
        return duty;
    }

    /**
     * check for the crossing of a Stamp Duty Land registry threshold crossing.
     * If crossed the boundary point will be returned.
     * If not  crossed the offerPriceTwo will be returned
     *
     * @param offerPriceOne the offer price one
     * @param offerPriceTwo the offer price two
     * @return the double
     */
    public static double stampDutyLandTaxThresholdCrossed(double offerPriceOne, double offerPriceTwo)
    {
        double offerPrice = offerPriceTwo;
        double offerPercentageOne = getStampDutyLandTaxPercentage(offerPriceOne);
        double offerPercentageTwo = getStampDutyLandTaxPercentage(offerPriceTwo);
        
            
        // if the two prices are within different percentage bands a threshold has been crossed
        if (offerPercentageOne != offerPercentageTwo)
            offerPrice = getStampDutyLandTaxThreshold(offerPercentageTwo);
        
        return offerPrice;
    }

    /**
     * Sets the deprived area.
     *
     * @param disadvantagedAreaFlag the new deprived area
     */
    public static void setDeprivedArea(boolean disadvantagedAreaFlag)
    {
        StampDuty.disadvantagedArea = disadvantagedAreaFlag;
    }

    /**
     * Checks if is disadvantaged area.
     *
     * @return true, if is disadvantaged area
     */
    public static boolean isDisadvantagedArea()
    {
        return disadvantagedArea;
    }

    /**
     * Sets the first time buyer.
     *
     * @param firstTimeBuyerFlag the new first time buyer
     */
    public static void setFirstTimeBuyer(boolean firstTimeBuyerFlag)
    {
        StampDuty.firstTimeBuyer = firstTimeBuyerFlag;
    }

    /**
     * Checks if is first time buyer.
     *
     * @return true, if is first time buyer
     */
    public static boolean isFirstTimeBuyer()
    {
        // First time buyer rate 0% up to 250K until 24th March 2012
        return firstTimeBuyer;
    }

}
