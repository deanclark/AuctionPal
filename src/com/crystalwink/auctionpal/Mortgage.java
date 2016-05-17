/*
 * <b>Description:
 * @TODO Update description for Mortgage.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           Mortgage.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

// TODO: Auto-generated Javadoc
/**
 * The Class Mortgage.
 */
public class Mortgage {

	/**
	 * The Enum PaymentMethod.
	 */
	enum PaymentMethod{
		
		/** The interest only. */
		interestOnly,
		
		/** The repayment. */
		repayment,
		
		/** The mixture. */
		mixture // interest only and repayment
	}
	
	/**
	 * The Enum MortgageType.
	 */
	enum MortgageType {
		
		/** The personnal. */
		personnal,
		
		/** The buy to let. */
		buyToLet,
		
		/** The buy to renovate. */
		buyToRenovate,
		// business,
	}
	
	/**
	 * The Enum InterestType.
	 */
	enum InterestType{
		
		/** The fixed. */
		fixed,
		
		/** The tracker. */
		tracker
	}

	/** The provider. */
	private String provider = "unknown";
	
	/** The product name. */
	private String productName = "unknown";
	
	/** The mort type. */
	private MortgageType mortType = MortgageType.personnal;
	
	/** The int type. */
	private InterestType intType = InterestType.tracker; 
	
	/** The method. */
	private PaymentMethod method = PaymentMethod.interestOnly;
	
	/** The interest rate. */
	private double interestRate = 3.65;  // 3.65%
	
	/** The term. */
	private int term = 25;  // 3.65%
	
	/** The property value. */
	private double propertyValue = 0.0;
	
	/** The loan amount. */
	private double loanAmount = 0.0;
	
	/** The deposit. */
	private double deposit = 0.0;
	
	/** The loan to value. */
	private double loanToValue = 25; // 25%
	
	/** The arange ment fee. */
	private double arangeMentFee = 995.00;

	
	
    // The one and only this
    /** The _mortgage. */
    private static Mortgage _mortgage = null;
    
    /**
     * Singleton get instance.
     *
     * @return Mortgage instance
     */
    public static Mortgage getInstance()
    {
        if (_mortgage == null)
        {
            _mortgage = new Mortgage();
        }
        return _mortgage;
    }

	/**
	 * Sets the provider.
	 *
	 * @param provider the new provider
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * Gets the provider.
	 *
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the mort type.
	 *
	 * @param mortType the new mort type
	 */
	public void setMortType(MortgageType mortType) {
		this.mortType = mortType;
	}

	/**
	 * Gets the mort type.
	 *
	 * @return the mort type
	 */
	public MortgageType getMortType() {
		return mortType;
	}

	/**
	 * Sets the int type.
	 *
	 * @param intType the new int type
	 */
	public void setIntType(InterestType intType) {
		this.intType = intType;
	}

	/**
	 * Gets the int type.
	 *
	 * @return the int type
	 */
	public InterestType getIntType() {
		return intType;
	}

	/**
	 * Sets the method.
	 *
	 * @param method the new method
	 */
	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public PaymentMethod getMethod() {
		return method;
	}

	/**
	 * Sets the interest rate.
	 *
	 * @param interestRate the new interest rate
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * Gets the interest rate.
	 *
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * Sets the term.
	 *
	 * @param term the new term
	 */
	public void setTerm(int term) {
		this.term = term;
	}

	/**
	 * Gets the term.
	 *
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * Sets the property value.
	 *
	 * @param propertyValue the new property value
	 */
	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	/**
	 * Gets the property value.
	 *
	 * @return the property value
	 */
	public double getPropertyValue() {
		return propertyValue;
	}

	/**
	 * Sets the loan amount.
	 *
	 * @param loanAmount the new loan amount
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * Gets the loan amount.
	 *
	 * @return the loan amount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * Sets the deposit.
	 *
	 * @param deposit the new deposit
	 */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	/**
	 * Sets the deposit from ltv.
	 */
	public void setDepositFromLTV() {
		this.deposit = propertyValue * (getLoanToValue() / 100);
		setLoanAmount(this.propertyValue - this.deposit);
	}


	/**
	 * Gets the deposit.
	 *
	 * @return the deposit
	 */
	public double getDeposit() {
		return deposit;
	}

	/**
	 * Sets the loan to value.
	 *
	 * @param loanToValue the new loan to value
	 */
	public void setLoanToValue(double loanToValue) {
		this.loanToValue = loanToValue;
	}

	/**
	 * Gets the loan to value.
	 *
	 * @return the loan to value
	 */
	public double getLoanToValue() {
		return loanToValue;
	}

	/**
	 * Sets the arange ment fee.
	 *
	 * @param arangeMentFee the new arange ment fee
	 */
	public void setArangeMentFee(double arangeMentFee) {
		this.arangeMentFee = arangeMentFee;
	}

	/**
	 * Gets the arange ment fee.
	 *
	 * @return the arange ment fee
	 */
	public double getArangeMentFee() {
		return arangeMentFee;
	}

	/**
	 * Gets the repayment pcm.
	 *
	 * @return the repayment pcm
	 */
	public double getRepaymentPcm() {
		final int MONTHS_PER_YEAR = 12;
		double repaymentPcm = (getLoanAmount() * (getInterestRate() / 100)) / MONTHS_PER_YEAR;
		return repaymentPcm;
	}

}
