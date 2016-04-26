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
![alt text][2][1]
  [2]: doc-files/ScreenShot-Main-2012-06-13_19-02-22.png
  [1]: https://github.com/deanclark/HouseMartinAndroid/doc-files/ScreenShot-Main-2012-06-13_19-02-22.png "Image of Main Screen"


#### Screenshot of Offer Increments screen: 
![alt text][4][3]
  [4]: doc-files/ScreenShot-OfferIncrements-2012-06-13_19-02-30.png
  [3]: https://github.com/deanclark/HouseMartinAndroid/doc-files/ScreenShot-OfferIncrements-2012-06-13_19-02-30.png "Image of Main Screen"


#### Screenshot of Property Details screen: 
![alt text][6][5]
  [6]: doc-files/ScreenShot-PrpertyDetails-2012-06-13_19-02-55.png
  [5]: https://github.com/deanclark/HouseMartinAndroid/doc-files/ScreenShot-PrpertyDetails-2012-06-13_19-02-55.png "Image of Property Details Screen"


#### Screenshot of rent screen: 
![alt text][8][7]
  [8]: doc-files/ScreenShot-Rent-2012-06-13_19-02-38.png
  [7]: https://github.com/deanclark/HouseMartinAndroid/doc-files/ScreenShot-Rent-2012-06-13_19-02-38.png "Image of Rent Screen"


#### Screenshot of splash screen: 
![alt text][10][9]
  [10]: doc-files/ScreenShot-Splash-2012-06-13_19-02-03.png
  [9]: https://github.com/deanclark/HouseMartinAndroid/doc-files/ScreenShot-Splash-2012-06-13_19-02-03.png "Image of Splash Screen"


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
