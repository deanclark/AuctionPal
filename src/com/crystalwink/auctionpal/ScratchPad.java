/*
 * <b>Description:
 * @TODO Update description for ScratchPad.java
 * 
 * <p>
 * Copyright: Copyright (c) 2012 - All Rights Reserved
 * <p>
 * Company: Crystalwink Ltd.
 * 
 * file           ScratchPad.java
 * creation date: 24-Apr-2012
 * @author        deancl
 */
package com.crystalwink.auctionpal;

import java.text.DecimalFormat;
import java.util.Vector;

//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;


/**
 * The Class ScratchPad.
 */
public class ScratchPad {
//	public class ScratchPad extends JFrame {

	/**
	 * @param args
	 */
/*
 	public static void main(String[] args) {
		 DecimalFormat precisionTwo = new DecimalFormat( "0.00" );
//		 JTextArea outputTextArea = new JTextArea( 11, 30 );

		 // Test Compound interest calculator used for House Price Inflation (HPI)
		 int yearsInvested = 8; 
		 double interestRate = 9; // 9%
		 double principalAmount = 30000;
		 Vector<Double> interestPaymentsVector = Helper.interest(yearsInvested, interestRate, principalAmount);
		 //outputTextArea.append( "House Price Inflation (HPI) assuming " + interestRate + "% \n" );
		 for (int ii=0; ii<interestPaymentsVector.size(); ii++){
			 //outputTextArea.append( "    Payment " + ii + " : " + precisionTwo.format( interestPaymentsVector.get(ii)) + "\n" );
		 }
		 //outputTextArea.append( "\n" );


		 // Test Property Class
		 Property newProperty = Property.getInstance();
         newProperty.setAskingPrice(157000);  // TODO add input option to GUI
         StampDuty.setDeprivedArea(true);  // TODO add tickbox to GUI
//         StampDuty.setFirstTimeBuyer(true);  // TODO add tickbox to GUI
		 newProperty.setVendor(Property.VendorType.privateOwned);
		 //newProperty.setVendor(Property.VendorType.bankOwned);
		 newProperty.setAgent(Property.AgentType.agent);
		 //outputTextArea.append( "Property Info - vendor " + newProperty.getVendorTypeName() + "\n" );
		 //outputTextArea.append( "Asking Price: £" + newProperty.getAskingPrice() + "  Maximum Offer: £" + newProperty.getMaximumOffer() + "\n" );

         //outputTextArea.append( "Asking Price(Stamp Duty Land Tax): £" + StampDuty.getStampDutyLandTax(newProperty.getAskingPrice()) +  "  Maximum Offer: £" + StampDuty.getStampDutyLandTax(newProperty.getMaximumOffer()) + "\n" );
         
         //outputTextArea.append( "FirstTimeBuyer: " + (StampDuty.isFirstTimeBuyer() ? "YES" : "NO") + "  Deprived Area : " + (StampDuty.isDisadvantagedArea() ? "YES" : "NO") + "\n" );
         

		 int numberOfOfferSteps = 10;
		 Vector<Double> incrementsVector = newProperty.getRecomendedOfferIncrements(numberOfOfferSteps, false);  // steps, (t)linear/(f)descending
		 //outputTextArea.append( "Offer Increments: " + incrementsVector.size() + "\n" );
		 for (int ii=0; ii<incrementsVector.size(); ii++){
			 //outputTextArea.append( "    Offer " + (ii+1) + " : £" + precisionTwo.format( incrementsVector.get(ii)) + "     SDLT(" + StampDuty.getStampDutyLandTaxPercentage(incrementsVector.get(ii)) + "%):     £" + precisionTwo.format( StampDuty.getStampDutyLandTax(incrementsVector.get(ii))) + "\n" );
		 }
		 //outputTextArea.append( "\n" );
		 
		 

		 Mortgage newMortgage = Mortgage.getInstance();
		 newMortgage.setInterestRate(4.5);  // TODO read from GUI
		 newMortgage.setPropertyValue(newProperty.getAskingPrice());
		 newMortgage.setLoanToValue(30);  // TODO read from GUI // 30%
		 newMortgage.setTerm(25);  // TODO read from GUI  // 25 years
		 newMortgage.setDepositFromLTV();
		 
		 //outputTextArea.append( "Mortgage Info\n" );
		 //outputTextArea.append( "Asking Price £" + newMortgage.getPropertyValue() + "\t" + " Deposit £" + newMortgage.getDeposit() + "\t" + " LTV " + newMortgage.getLoanToValue() + "%\n" );
		 //outputTextArea.append( "Loan Amount " + newMortgage.getLoanAmount() + "% \t" + "Interest Rate " + newMortgage.getInterestRate() + "% \t" + " Monthly £" + newMortgage.getRepaymentPcm() + "\n" );
         //outputTextArea.append( "Interest Yearly £" + Helper.interestAnnually(newMortgage.getInterestRate(), newMortgage.getLoanAmount()) + " Interest Monthly £" + Helper.interestMonthly(newMortgage.getInterestRate(), newMortgage.getLoanAmount()) + " \n" );


		 // Test buy-to-let 
		 // TODO - get property location from GPS  
		 Rental newRental = Rental.getInstance();
		 // TODO - determine average rental on similar properties of this size within the same geographic area
		 newRental.setPotentialIncomePcm(650.00);  // TODO read from GUI
		 // TODO get RentalCover from mortgage information
		 newRental.setRentalCover(120);  // TODO read from GUI  // 120%
		 //outputTextArea.append( "Rental Info\n" );
		 //outputTextArea.append( "\nRent £" + precisionTwo.format( newRental.getPotentialIncomePcm()) + "\t" + " Cover " + newRental.getRentalCover() + "%\t" + " Max Repayments £" + precisionTwo.format( newRental.getMaximumRepayment()) + "\n" );
		 // Compare rental newMortgage.getRepaymentPcm()

		 double grossAnnualInterest = 0.0;
		 double grossAnnualIncome = 0.0;
		 double netAnnualIncome = 0.0;
		 
		if (newMortgage.getRepaymentPcm() > newRental.getMaximumRepayment())
			 //outputTextArea.append( "WARNING! rental income exceeds rental cover threshold! \n" );

		 grossAnnualInterest = Helper.interestAnnually(newMortgage.getInterestRate(), newMortgage.getLoanAmount());
		 grossAnnualIncome = newRental.getPotentialIncomePcm() * 12;
		 netAnnualIncome = grossAnnualIncome - grossAnnualInterest;
		 
		 //outputTextArea.append( "Rental income potential £" + netAnnualIncome + "(Annual NET)\n" ); 
		 
		 //outputTextArea.append( "\n" );
		 

		 
		 interestPaymentsVector = Helper.interest(newMortgage.getTerm(), newMortgage.getInterestRate(), newMortgage.getLoanAmount());
		 //outputTextArea.append( "Interest Payments\n" );
		 for (int ii=0; ii<interestPaymentsVector.size(); ii++){
			 //outputTextArea.append( "    Payment " + ii + " : " + precisionTwo.format( interestPaymentsVector.get(ii)) + "\n" );
		 }
//		 outputTextArea.append( "\n" );
		 
//		 JOptionPane.showMessageDialog( null, outputTextArea, "Title", JOptionPane.INFORMATION_MESSAGE );
		 System.exit( 0 ); // terminate the application
		 
	}
*/	
}
