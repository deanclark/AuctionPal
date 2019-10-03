Housemartin AuctionPal (Android)
================================ 

To provide guidance to a potential property buyer given known monetary value or asking price of a 
property and using statistical information to provide a guide to the offer or bidding process.  
Basic mortgage calculator functionality will be provided with the addition of a historical 
comparison against similar properties within the same geographical location taking into account 
house price inflation will be used as a guide to maximum offer price.  
Rental income potential will be calculated using current interest rates, loan-to-value, monthly 
rental value and expected occupancy percentage.


#### Screenshot of main screen: 
!["Image of Main Screen"](https://github.com/deanclark/AuctionPal/blob/master/doc-files/ScreenShot-Main-2012-06-13_19-02-22.png)


#### Screenshot of Offer Increments screen: 
!["Image of Main Screen"](https://github.com/deanclark/AuctionPal/blob/master/doc-files/ScreenShot-OfferIncrements-2012-06-13_19-02-30.png)


#### Screenshot of Property Details screen: 
!["Image of Property Details Screen"](https://github.com/deanclark/AuctionPal/blob/master/doc-files/ScreenShot-PrpertyDetails-2012-06-13_19-02-55.png)


#### Screenshot of rent screen: 
!["Image of Rent Screen"](https://github.com/deanclark/AuctionPal/blob/master/doc-files/ScreenShot-Rent-2012-06-13_19-02-38.png)


#### Screenshot of splash screen: 
!["Image of Splash Screen"](https://github.com/deanclark/AuctionPal/blob/master/doc-files/ScreenShot-Splash-2012-06-13_19-02-03.png)


Controls
-----------

* Specifiy the asking price for the property
* Update the interest rate
* View the calculations



Running the application
-----------

 
#### To compile:

*     ant

#### To run:
   
   * from within Eclipse right click the AndroidManifest.xml and Run As->Android Application
    

#### To rebuild Eclipse Project:
*     mvn eclipse:clean eclipse:eclipse -DdownloadSources -Declipse:useProjectReferences=false -Dwtpversion=2.0

#### JUnit
* 	from within Eclipse right click the AndroidManifest.xml and Run As->Android Test
	
	
#### Ant build of jar file
*     ant createjar
