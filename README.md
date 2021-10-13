# flightinfo-display
Flight Information Display System
---------------------------------------------

A web application which displays the flights which provides service on a given input date. 

Application provides an interface where user can enter the date. Flights details will be displayed on submission of the request.

Application use Spring boot.

Code organize as this:

	1. src/main/java - model, controller, service and helper classes
	
	2. Src/main/resources - 
		a. Input CSV file 'flights.csv' with flight details
		b. /static - CSS files
		c. /templates - html files
		
	3. src/test/java - Test classes

Getting started
---------------
You need to install Java8, eclipse/intellij, maven.  Once the application is imported to Eclipse (File->Import->Maven->Existing Maven Projects-> Navigate to the Spring boot project location and select pom.xml)

	• Test cases be executed by selecting 'Run as Junit test' on the class 'FlightinfoDisplayApplicationTests'.
	
  	• To access the webapp, select 'Run as' on the SpringbootApplication class 'FlightinfoDisplayApplication' and then open a web browser and type 'http://localhost:8080/input'
